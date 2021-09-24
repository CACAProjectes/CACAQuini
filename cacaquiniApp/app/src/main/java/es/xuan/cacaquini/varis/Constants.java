package es.xuan.cacaquini.varis;

import android.graphics.Color;
import android.graphics.Typeface;

import java.io.Serializable;
import java.math.BigDecimal;

import es.xuan.cacaquini.model.Perfil;

public class Constants implements Serializable {
    public static final String CTE_PERCENTATGE_STR = "%";
    private static final long serialVersionUID = 1L;
    //
    public static final String CTE_ESTA_EN_JOC = "J";
    public static final String CTE_CAPCALERA_JORNADA = "JORNADA";
    public static final String CTE_EURO = "€";
    //
    public static final double CTE_DOUBLE_CERO = 0.00;
    public static final double CTE_APOSTA_SIMPLE = 0.75;
    public static final double CTE_PREMI_PER_ENCERT = 0.05;
    public static final double CTE_DOUBLE_CENT = 100.00;
    public static final BigDecimal CTE_BIGDEC_CERO = new BigDecimal(0.00);
    public static final BigDecimal CTE_BIGDEC_APOSTA_SIMPLE = new BigDecimal(0.75);
    //
    //public static final String CTE_PATH_ESCRUTINI = "CCC-CACAQuini/Escrutini-CACAQuini.csv";
    //public static final String CTE_PATH_USERS = "Users-CACAQuini/";
    public static final int CTE_RESULT_CANVI_USUARI = 2;
    public static final int CTE_RESULT_NOU_USUARI = 3;
    public static final int CTE_RESULT_ACTUALITZACIO_USUARI = 4;
    public static final int CTE_RESULT_CANCELLAT_SENSE_CANVIS = 5;
    public static final int CTE_RESULT_CANCELLAT_BUIT = 6;
    public static final int CTE_RESULT_ACTUALITZACIO_USUARI_ADMIN = 7;

    public static final String CTE_CLOUD_USUARIS = "CACAQuini-Usuaris";
    public static final String CTE_CLOUD_APOSTES_USUARI = "CACAQuini-Apostes-";
    public static final String CTE_CLOUD_USUARI = "CACAQuini-Usuari-";
    public static final String CTE_CLOUD_ESCRUTINI = "CACAQuini-Escrutinis";
    public static final String CTE_PATH_ESCRUTINI = "/apps/cacaquini/Escrutini-CACAQuini.csv";
    public static final String CTE_KEY_ADMINISTRADOR = Perfil.ADMINISTRADOR.toString();
    public static final String CTE_KEY_USUARI = Perfil.USUARI.toString();
    public static final String CTE_CLAU_SP_CACAQUINI_USUARI = "SP_CACAQUINI_USUARI";
    public static final String CTE_CLAU_SP_CACAQUINI_USUARI_ADMIN = "SP_CACAQUINI_USUARI_ADMIN";
    public static final String CTE_CLAU_INTENT_CACAQUINI_USUARI = "INTENT_CACAQUINI_USUARI";
    public static final String CTE_CLAU_INTENT_CACAQUINI_USUARI_NICKNAME = "INTENT_CACAQUINI_USUARI_NICK";
    //
    public static final String CTE_PATH_APPS = "/apps";
    public static final String CTE_PATH_APP = "/apps/cacaquini/";
    public static final String CTE_PATH_APP_PREFIX = "cacaquiniela_";
    public static final String CTE_PATH_APP_SUFIX = ".csv";
    public static final String CTE_PATH_APP_LOGS = "/apps/cacaquini/logs.txt";
    //
    public static final String CTE_SEPARADOR_ELEMENT_CLASSIF = ",";
    public static final String CTE_SEPARADOR_CLASSIFICACIO = "/";
    public static final String CTE_SEPARADOR_SETS = "/";
    public static final String CTE_CANVI_LINEA_DESCRIP = "\n";
    public static final String CTE_SEPARADOR_RESULTAT = " - ";
    public static final String CTE_SEPARADOR_RESULTAT_RED = "-";
    public static final String CTE_SEPARADOR_TEXT = ";";
    public static final String CTE_ESPAI_BLANC = " ";
    //
    public static final int CTE_DIUMENGE = 1;
    public static final int CTE_DIES_SETMANA = 7;
    public static final long CTE_VIBRATION_MS = 50;
    //
    public static final int CTE_MIN_DESP_CANVI_DRAG_DROP = 300;
    public static final int CTE_DESPLACAMENT = 2;
    public static final int CTE_CAL_WIDTH_NORMAL = 100;
    public static final int CTE_CAL_HEIGHT_NORMAL = 100;
    public static final int CTE_CAL_WIDTH_SEL = 130;
    public static final int CTE_CAL_HEIGHT_SEL = 130;
    public static final int CTE_CAL_TEXT_SIZE_NORMAL = 20;
    public static final int CTE_CAL_TEXT_SIZE_SEL = 25;
	public static final int CTE_CAL_TEXT_TYPE_NORMAL = Typeface.NORMAL;
	public static final int CTE_CAL_TEXT_TYPE_SEL = Typeface.BOLD;
	public static final int CTE_CAL_TEXT_COLOR_NORMAL = Color.WHITE;
	public static final int CTE_CAL_TEXT_COLOR_SEL = Color.BLACK;
}
