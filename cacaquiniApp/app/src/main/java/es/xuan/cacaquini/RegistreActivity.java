package es.xuan.cacaquini;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import es.xuan.cacaquini.model.Perfil;
import es.xuan.cacaquini.model.Usuari;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Serializar;
import es.xuan.cacaquini.varis.Utils;

public class RegistreActivity extends AppCompatActivity {
    private Vibrator m_vibr;
    private EditText m_etNickName;
    private EditText m_etNomUsuariReg;
    private EditText m_etCogNomUsuariReg;
    private EditText m_etEmailReg;
    private EditText m_etPerfil;
    private EditText m_etSaldoReg;
    private ImageView m_ivCanviarUsuari;
    private boolean isAdministrador = false;
    private boolean isUsuariNou = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre_act);
        //
        gestionarAdministrador();
        //
        inicialitzarPantalla();
        // 
        omplirRegistre();
        //
        gestionarAdministradorPantalla();
    }


    private void gestionarAdministrador() {
        // SharedPreferences
        SharedPreferences spDades = getSharedPreferences(Constants.CTE_CLAU_SP_CACAQUINI_USUARI_ADMIN, MODE_PRIVATE);
        try {
            String strPerfil = Objects.requireNonNull(Utils.recuperarInfoSP(spDades)).toString();
            isAdministrador = strPerfil.equals(Perfil.ADMINISTRADOR.toString());
        } catch (Exception ex) {
            isAdministrador = false;
        }
    }
    private void gestionarAdministradorPantalla() {
        if (isAdministrador) {
            m_ivCanviarUsuari.setVisibility(View.VISIBLE);
            //m_etNomUsuariReg.setEnabled(false);
            //m_etCogNomUsuariReg.setEnabled(false);
            //m_etEmailReg.setEnabled(false);
        }
        else {
            m_ivCanviarUsuari.setVisibility(View.GONE);
            //m_etNomUsuariReg.setEnabled(true);
            //m_etCogNomUsuariReg.setEnabled(true);
            //m_etEmailReg.setEnabled(true);
        }
    }
    private void omplirRegistre() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String messageFromActivity = bundle.getString(Constants.CTE_CLAU_INTENT_CACAQUINI_USUARI);
            if (messageFromActivity != null && !messageFromActivity.equals("")) {
                try {
                    Usuari usuari = (Usuari) Serializar.desSerializar(messageFromActivity);
                    if (usuari != null) {
                        isUsuariNou = false;
                        m_etNickName.setEnabled(isAdministrador);
                        m_etNickName.setText(usuari.getNickname());
                        m_etNomUsuariReg.setText(usuari.getNom());
                        m_etCogNomUsuariReg.setText(usuari.getCognoms());
                        m_etEmailReg.setText(usuari.getEmail());
                        m_etPerfil.setText(usuari.getPerfil().toString());
                        m_etSaldoReg.setText(Utils.formatMoneda(usuari.getSaldo()));
                   }
                    else {
                        isUsuariNou = true;
                        m_etNickName.setEnabled(true);
                        m_etPerfil.setText(getString(R.string.perfil_usuari_valor));
                        m_etSaldoReg.setText(R.string.saldo_inicial_quantitat_string);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private Usuari omplirUsuari() {
        Usuari usuari = new Usuari();
        usuari.setNickname(m_etNickName.getText().toString());
        usuari.setNom(m_etNomUsuariReg.getText().toString());
        usuari.setCognoms(m_etCogNomUsuariReg.getText().toString());
        usuari.setEmail(m_etEmailReg.getText().toString());
        usuari.setPerfil(Perfil.valueOf(m_etPerfil.getText().toString()));
        usuari.setSaldo(Utils.string2Double(m_etSaldoReg.getText().toString()));
        usuari.setDataActualitzacio(new Date());
        return usuari;
    }

    private void inicialitzarPantalla() {
        m_vibr = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
        //
        m_etNickName = findViewById(R.id.etNickName);
        m_ivCanviarUsuari = findViewById(R.id.ivCanviarUsuari);
        m_ivCanviarUsuari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                //
                if (m_etNickName.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), getString(R.string.missatge_informar_usuari), Toast.LENGTH_LONG).show();
                }
                else {
                    finalitzarApp(Constants.CTE_RESULT_CANVI_USUARI);
                }
            }
        });
        m_etNomUsuariReg = findViewById(R.id.etNomUsuariReg);
        m_etCogNomUsuariReg = findViewById(R.id.etCogNomUsuariReg);
        m_etEmailReg = findViewById(R.id.etEmailReg);
        m_etPerfil = findViewById(R.id.etPerfil);
        m_etSaldoReg = findViewById(R.id.etSaldoReg);
        //  Botó guardar registre nou
        Button m_btGuardar = findViewById(R.id.btGuardar);
        m_btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                //
                if (m_etNickName.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), getString(R.string.missatge_informar_usuari), Toast.LENGTH_LONG).show();
                }
                else {
                    if (isUsuariNou)
                        finalitzarApp(Constants.CTE_RESULT_NOU_USUARI);
                    else if (isAdministrador)
                        finalitzarApp(Constants.CTE_RESULT_ACTUALITZACIO_USUARI_ADMIN);
                    else
                        finalitzarApp(Constants.CTE_RESULT_ACTUALITZACIO_USUARI);
                }
            }
        });
        //  Botó cancel·lar operació
        Button m_btCancellar = findViewById(R.id.btCancellar);
        m_btCancellar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                //
                if (m_etNickName.getText().toString().equals(""))
                    finalitzarApp(Constants.CTE_RESULT_CANCELLAT_BUIT);
                else
                    finalitzarApp(Constants.CTE_RESULT_CANCELLAT_SENSE_CANVIS);
            }
        });
    }

    private void finalitzarApp(int pResult) {
        try {
            Usuari usuari = omplirUsuari();
            Intent intent = new Intent();
            intent.putExtra(Constants.CTE_CLAU_INTENT_CACAQUINI_USUARI, Serializar.serializar(usuari));
            setResult(pResult, intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish();
    }
}