package es.xuan.cacaquini.gestio;

import android.content.SharedPreferences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import es.xuan.cacaquini.files.FilesDao;
import es.xuan.cacaquini.files.SPCloud;
import es.xuan.cacaquini.model.EstatQuiniela;
import es.xuan.cacaquini.model.Quiniela;
import es.xuan.cacaquini.model.Usuari;
import es.xuan.cacaquini.model.UsuariSimple;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Utils;

public class GestorUsuari implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void guardarUsuariFitxer(Usuari p_usuari) {
        String strNomFitxer = Constants.CTE_PATH_APP_PREFIX + p_usuari.getNickname() + Constants.CTE_PATH_APP_SUFIX;
        // Capçalera
        String strContingut = "NICKNAME;EMAIL;NOM;COGNOMS;SALDO_ACTUAL;SALDO_APOSTAT;NUM_JORNADA;DATA_JORNADA;DATA_ACTUALITZAT;ESTAT;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_PARTIT;EQUIP_LOCAL;EQUIP_VISITANT;MARCADOR;SIGNE;NUM_ENCERTS;SALDO_PREMI;SALDO_DISPONIBLE" + System.lineSeparator();
        // Contingut d'usuari
        strContingut += p_usuari.toString();
        FilesDao.guardarQuiniela(strNomFitxer, strContingut);
        System.out.println(strContingut);
    }

    public static void recalcularSaldoDisponible(Usuari p_usuari, double p_saldoInicial) {
        double saldo = p_saldoInicial;
        double saldoPremis= Constants.CTE_DOUBLE_CERO;
        for (Quiniela quinielaUsuari : p_usuari.getQuinielasUsuari()) {
            if (!quinielaUsuari.getEstatQuiniela().equals(EstatQuiniela.NOCOMP)) {
                //  Acumulat del saldo total de l'usuari
                saldo = saldo - GestorApostes.calcularSaldoApostat(quinielaUsuari.getSignesPartit());
                p_usuari.setSaldo(saldo);
                //  Acumulat dels premis obtinguts per l'usuari
                saldoPremis = saldoPremis + quinielaUsuari.getPremiQuiniela();
                p_usuari.setSaldoPremisQuinielas(saldoPremis);
            }
            //quinielaUsuari.setSaldoDisponible(saldo);
            //  Omplir els signes que no estan omplerts
            //omplirSignesBuits(quinielaUsuari);
        }
    }

    private static void omplirSignesBuits(Quiniela p_quiniela) {
        // Valors per defecte
        String[] signesPartit = {
                "1","1","1","1","1","1","1","1",
                "1","1","1","1","1","1","1","1"};
        if ((p_quiniela.getSignesPartit() == null || p_quiniela.getSignesPartit()[0].equals("")) && p_quiniela.getEstatQuiniela().equals(EstatQuiniela.FINALITZADA))
            // Valors per defecte
            p_quiniela.setSignesPartit(signesPartit);
    }

    public static void guardarUsuariSP(SharedPreferences p_spDades, Usuari p_usuari) {
        if (p_usuari == null)
            return;
        // Guardar usuari
        Utils.guardarInfoSP(p_spDades, p_usuari);
    }
    public static void guardarUsuariCloud(SPCloud p_spCloud, Usuari p_usuari) {
        // Guardar usuari en Cloud
        try {
            // Guardar les dades del Usuari al Cloud
            p_spCloud.setValUsuari(p_usuari);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    public static void guardarUsuariLlistaUsuaris(SPCloud p_spCloud, UsuariSimple p_usuariSimple) {
        // Guardar usuari en Cloud i en la llista de usuaris
        try {
            // Llegir usuaris
            ArrayList<UsuariSimple> usuaris = (ArrayList<UsuariSimple>)p_spCloud.getValUsuaris();
            // Afegir usuari nou si no existeix
            usuaris = mergeUSuari2Usuaris(usuaris, p_usuariSimple);
            // Guardar les dades del Usuari al Cloud
            p_spCloud.setValUsuaris(usuaris);
            System.out.println("Usuaris: " + (usuaris != null ? usuaris.size() : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    private static ArrayList<UsuariSimple> mergeUSuari2Usuaris(ArrayList<UsuariSimple> p_usuaris, UsuariSimple p_usuariSimple) {
        boolean isNou = true;
        if (p_usuaris == null) {
            p_usuaris = new ArrayList<UsuariSimple>();
        }
        for (int i = 0; i<p_usuaris.size();i++) {
            UsuariSimple usuari = (UsuariSimple)p_usuaris.get(i);
            if (usuari.getNickname().equals(p_usuariSimple.getNickname())) {
                // Si ja existeix l'usuari, s'actualitzan el reste de camps
                usuari.setDataActualitzacio(new Date());
                usuari.setEmail(p_usuariSimple.getEmail());
                usuari.setPerfil(p_usuariSimple.getPerfil());
                isNou = false;
                break;
            }
        }
        if (isNou)
            p_usuaris.add(p_usuariSimple);
        return p_usuaris;
    }
}
