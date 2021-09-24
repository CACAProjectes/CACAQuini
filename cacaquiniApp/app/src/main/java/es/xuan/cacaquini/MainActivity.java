package es.xuan.cacaquini;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import es.xuan.cacaquini.files.SPCloud;
import es.xuan.cacaquini.gestio.GestorUsuari;
import es.xuan.cacaquini.migracio.VBMigracioQuini;
import es.xuan.cacaquini.model.Quiniela;
import es.xuan.cacaquini.model.QuinielaMig;
import es.xuan.cacaquini.model.Usuari;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Serializar;
import es.xuan.cacaquini.varis.Utils;
import es.xuan.cacaquini.view.Pantalla;

public class MainActivity extends AppCompatActivity {
    protected SharedPreferences m_spDades = null;
    protected Pantalla m_pantalla = null;
    protected Usuari m_usuari = null;
    protected SPCloud m_spCloud = null;
    protected int numJornadaEnCurs = 0;

    public int getNumJornadaEnCurs() {
        return numJornadaEnCurs;
    }
    public void setNumJornadaEnCurs(int numJornadaEnCurs) {
        this.numJornadaEnCurs = numJornadaEnCurs;
    }
    //
    private static final int REQUEST_CODE = 255;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  TODO: En principi no és necessari
        //comprovarPermissos();
        // TODO: Guardar en SP el perfil d'usuari - Només canviar per altres usuaris NO ADMINISTRADORS
        guardarKeyAdministrador();
        //  Llegir usuari SP
        recuperarUsuari();
        //  Guardar usuari en SP
        guardarQuinielaEnCurs2Usuari(getNumJornadaEnCurs());
        //  Inicialitzar pantalla
        inicialitzarPantalla();
    }

    private void guardarKeyAdministrador() {
        // SharedPreferences
        SharedPreferences spDades = getSharedPreferences(Constants.CTE_CLAU_SP_CACAQUINI_USUARI_ADMIN, MODE_PRIVATE);
        /*  TODO: Pensar una altre solució
        boolean isAdministrador = m_usuari.getPerfil().equals(Perfil.ADMINISTRADOR);
        if (isAdministrador)
            //  ADMINISTRADOR
            Utils.guardarInfoSP(spDades, Constants.CTE_KEY_ADMINISTRADOR);
        else
            //  USUARI
            Utils.guardarInfoSP(spDades, Constants.CTE_KEY_USUARI);
         */
        //  TODO: Habilitar per asignar el ADMIN directament
        //  ADMINISTRADOR
        //Utils.guardarInfoSP(spDades, Constants.CTE_KEY_ADMINISTRADOR);
    }

    public void guardarQuinielaEnCurs2Usuari(int p_numJornada) {
        if (m_usuari == null)
            return;
        Quiniela quiniela = null;
        //  Llegir quiniela actual Web
        if (p_numJornada == 0)
            quiniela = recuperarQuinielaActual();
        else {
            quiniela = recuperarQuinielaJornada(p_numJornada);
        }
        if (quiniela != null) {
            setNumJornadaEnCurs(quiniela.getNumJornada());
            m_usuari.actQuinielaEnCurs(quiniela.getNumJornada(), quiniela);
            guardarUsuariSP(m_usuari);
        }
    }

    public SharedPreferences getSpDades() {
        return m_spDades;
    }
    public SPCloud getSpCloud() {
        return m_spCloud;
    }
    public Usuari getUsuari() {
        return m_usuari;
    }

    private void finatlitzarApp() {
        finish();
        System.exit(0);
    }
    private Quiniela recuperarQuinielaActual() {
        //
        VBMigracioQuini migracioQuini = new VBMigracioQuini();
        QuinielaMig quinielaMig = migracioQuini.getQuinielaProxima();
        return Utils.convertQuiniMig2Quini(quinielaMig);
    }
    private Quiniela recuperarQuinielaJornada(int p_numJornada) {
        //
        VBMigracioQuini migracioQuini = new VBMigracioQuini();
        QuinielaMig quinielaMig = migracioQuini.getQuinielaResultats(p_numJornada);
        Quiniela quiniela = null;
        if (quinielaMig != null && quinielaMig.getPartits() != null && quinielaMig.getPartits().size() > 0)
            quiniela = Utils.convertQuiniMig2Quini(quinielaMig);
        else
            quiniela = null;
        return quiniela;
    }

    private void recuperarUsuari() {
        //  Inicialitzar SharedPreferences
        m_spDades = getSharedPreferences(Constants.CTE_CLAU_SP_CACAQUINI_USUARI, MODE_PRIVATE);
        //  Recuperar usuari del SP
        m_usuari = (Usuari)Utils.recuperarInfoSP(m_spDades);
        //
        if (m_usuari == null) {
            // No existeix USUARI. Es desvia al formulari
            sendMessageToActivity(null);
        }
    }

    private void guardarUsuariSP(Usuari p_usuari) {
        GestorUsuari.guardarUsuariSP(m_spDades, p_usuari);
    }

    private void inicialitzarPantalla() {
        if (m_usuari != null) {
            m_pantalla = new Pantalla(this);
            m_pantalla.inicialitzarPantalla(this);
        }
    }

    public void sendMessageToActivity(Usuari p_usuari) {
        try {
            Intent intent = new Intent(this, RegistreActivity.class);
            intent.putExtra(Constants.CTE_CLAU_INTENT_CACAQUINI_USUARI, Serializar.serializar(p_usuari));
            startActivityForResult(intent, REQUEST_CODE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardarDadesUsuariCloud(String p_strNickname) {
        m_spCloud = new SPCloud(p_strNickname);
        GestorUsuari.guardarUsuariCloud(m_spCloud, m_usuari);
    }

    private Usuari llegirDadesCloud(String p_strNickname) {
        m_spCloud = new SPCloud(p_strNickname);
        return (Usuari)m_spCloud.getValUsuari();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Constants.CTE_RESULT_NOU_USUARI) {
            //  Usuari nou
            try {
                String resultFromRegistreAct = data.getStringExtra(Constants.CTE_CLAU_INTENT_CACAQUINI_USUARI);
                Usuari usuari = (Usuari)Serializar.desSerializar(resultFromRegistreAct);
                if (usuari.getNickname().equals("")) {
                    // L'usuari no está ben informat al formulari
                    sendMessageToActivity(null);
                    Toast.makeText(getApplicationContext(), getString(R.string.missatge_existeix_usuari), Toast.LENGTH_LONG).show();
                }
                else {
                    llegirDadesCloud(usuari.getNickname());
                    mostrarMissatgeUsuariExistent(usuari);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (requestCode == REQUEST_CODE && resultCode == Constants.CTE_RESULT_ACTUALITZACIO_USUARI) {
            //  Usuari modificat
            try {
                String resultFromRegistreAct = data.getStringExtra(Constants.CTE_CLAU_INTENT_CACAQUINI_USUARI);
                Usuari usuari = (Usuari)Serializar.desSerializar(resultFromRegistreAct);
                omplirUsuariModificat(usuari);
                //  Guardar en SP
                guardarQuinielaEnCurs2Usuari(getNumJornadaEnCurs());
                //  Guardar en Cloud
                guardarDadesUsuariCloud(m_usuari.getNickname());
                //  Inicialitzar pantalla
                inicialitzarPantalla();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (requestCode == REQUEST_CODE && resultCode == Constants.CTE_RESULT_ACTUALITZACIO_USUARI_ADMIN) {
            //  Usuari modificat ADMIN
            try {
                String resultFromRegistreAct = data.getStringExtra(Constants.CTE_CLAU_INTENT_CACAQUINI_USUARI);
                Usuari usuari = (Usuari)Serializar.desSerializar(resultFromRegistreAct);
                omplirUsuariModificat(usuari);
                //  Guardar en SP
                guardarQuinielaEnCurs2Usuari(getNumJornadaEnCurs());
                //  Guardar en Cloud
                guardarDadesUsuariCloud(m_usuari.getNickname());
                //  Inicialitzar pantalla
                inicialitzarPantalla();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (requestCode == REQUEST_CODE && resultCode == Constants.CTE_RESULT_CANVI_USUARI) {
            //  Canvi d'usuari. Nomès ho pot fer l'Administrador
            try {
                String resultFromRegistreAct = data.getStringExtra(Constants.CTE_CLAU_INTENT_CACAQUINI_USUARI);
                Usuari usuari = (Usuari)Serializar.desSerializar(resultFromRegistreAct);
                llegirDadesCloud(usuari.getNickname());
                mostrarMissatgeConfirmacio(usuari.getNickname());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if (requestCode == REQUEST_CODE && resultCode == Constants.CTE_RESULT_CANCELLAT_SENSE_CANVIS) {
            //  Canvi d'usuari
            inicialitzarPantalla();
        }
        else if (requestCode == REQUEST_CODE && resultCode == Constants.CTE_RESULT_CANCELLAT_BUIT) {
            //  Usuari buit i Cancel·lat, ha de sortir de l'App
            finatlitzarApp();
        }
    }

    private void mostrarMissatgeUsuariExistent(final Usuari p_usuari) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.existeix_usuari));
        builder.setMessage(getString(R.string.pregunta_existeix_usuari).replace("#", p_usuari.getNickname()));
        builder.setPositiveButton(getString(R.string.resposta_nou), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                Usuari usuari = (Usuari)m_spCloud.getValUsuari();
                //
                boolean existeix = comprovarExistenciaUsuari(usuari);
                if (!existeix) {
                    //  Usuari NOU
                    m_usuari = p_usuari;
                    guardarQuinielaEnCurs2Usuari(getNumJornadaEnCurs());
                    //
                    inicialitzarPantalla();
                }
                else {
                    // Existeix l'USUARI. Es desvia al formulari
                    sendMessageToActivity(null);
                    Toast.makeText(getApplicationContext(), getString(R.string.missatge_existeix_usuari), Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton(getString(R.string.resposta_existent), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                Usuari usuari = (Usuari)m_spCloud.getValUsuari();
                boolean existeix = comprovarExistenciaUsuari(usuari);
                if (!existeix) {
                    //  Usuari NOU
                    m_usuari = p_usuari;
                    guardarQuinielaEnCurs2Usuari(getNumJornadaEnCurs());
                    //
                    inicialitzarPantalla();
                }
                else {
                    // Existeix l'USUARI. Es desvia al formulari
                    m_usuari = usuari;
                    guardarQuinielaEnCurs2Usuari(getNumJornadaEnCurs());
                    //
                    inicialitzarPantalla();
                }
            }
        });
        builder.create();
        builder.show();
    }

    private boolean comprovarExistenciaUsuari(Usuari p_usuari) {
        return (p_usuari != null);
    }

    private void mostrarMissatgeConfirmacio(String p_nickname) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.canvi_usuari));
        builder.setMessage(getString(R.string.pregunta_usuari).replace("#", p_nickname));
        builder.setPositiveButton(getString(R.string.resposta_si), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                m_usuari = (Usuari)m_spCloud.getValUsuari();
                if (m_usuari == null) {
                    sendMessageToActivity(null);
                    Toast.makeText(getApplicationContext(), getString(R.string.missatge_no_existeix_usuari), Toast.LENGTH_LONG).show();
                }
                else {
                    guardarQuinielaEnCurs2Usuari(getNumJornadaEnCurs());
                    //
                    inicialitzarPantalla();
                }
            }
        });
        builder.setNegativeButton(getString(R.string.resposta_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                // No realitza cap acció
            }
        });
        builder.create();
        builder.show();
    }
    private void omplirUsuariModificat(Usuari p_usuari) {
        if (m_usuari == null) {
            m_usuari = new Usuari();
        }
        m_usuari.setNom(p_usuari.getNom());
        m_usuari.setCognoms(p_usuari.getCognoms());
        m_usuari.setEmail(p_usuari.getEmail());
    }

    private void omplirUsuariNou(Usuari p_usuari) {
        if (m_usuari == null) {
            m_usuari = new Usuari();
        }
        m_usuari.setNickname(p_usuari.getNickname());
        m_usuari.setNom(p_usuari.getNom());
        m_usuari.setCognoms(p_usuari.getCognoms());
        m_usuari.setEmail(p_usuari.getEmail());
        m_usuari.setPerfil(p_usuari.getPerfil());
        m_usuari.setSaldo(p_usuari.getSaldo());
        m_usuari.setSaldoPremisQuinielas(Constants.CTE_DOUBLE_CERO);
        m_usuari.setQuinielasUsuari(new ArrayList<Quiniela>());
    }
}