package es.xuan.cacaquini.model;

import java.io.Serializable;
import java.util.Date;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Utils;

public class Quiniela implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date dataActualitzacio = new Date();
    private int numJornada = 0;
    private Date dataJornada;
    private int numEncerts = 0;
    private double bote = Constants.CTE_DOUBLE_CERO;       // Premi del Bote de la quiniela
    private double costeQuiniela = Constants.CTE_DOUBLE_CERO;   // Coste de la quiniela
    private double premiPerEncerts = Constants.CTE_DOUBLE_CERO; // Premi per encerts. Premi especial
    private double premiQuiniela = Constants.CTE_DOUBLE_CERO;   // Premi de la quiniela: 10, 11, 12, 13, 14 i Ple al 15
    private EstatQuiniela estatQuiniela = EstatQuiniela.PDT;
    private double[][] premisEscrutinis = null;
    private String[] signesPartitUsuari = {
            "","","","","","","","",
            "","","","","","","",""};
    private String[] signesPartit = {
            "","","","","","","","",
            "","","","","","","",""};
    private String[] nomsEquipsLocal = {
            "","","","","","","","",
            "","","","","","","",""};
    private String[] nomsEquipsVisitant = {
            "","","","","","","","",
            "","","","","","","",""};
    private String[] marcadors = {
            "","","","","","","","",
            "","","","","","","",""};
    private String[] enJocs = {
            "","","","","","","","",
            "","","","","","","",""};

    public String[] getSignesPartitUsuari() {
        return signesPartitUsuari;
    }

    public void setSignesPartitUsuari(String[] signesPartitUsuari) {
        this.signesPartitUsuari = signesPartitUsuari;
    }

    public double[][] getPremisEscrutinis() {
        return premisEscrutinis;
    }

    public void setPremisEscrutinis(double[][] premisEscrutinis) {
        this.premisEscrutinis = premisEscrutinis;
    }

    public double getBote() {
        return bote;
    }

    public void setBote(double bote) {
        this.bote = bote;
    }

    public double getCosteQuiniela() {
        return costeQuiniela;
    }

    public void setCosteQuiniela(double costeQuiniela) {
        this.costeQuiniela = costeQuiniela;
    }

    public double getPremiPerEncerts() {
        return premiPerEncerts;
    }

    public void setPremiPerEncerts(double premiPerEncerts) {
        this.premiPerEncerts = premiPerEncerts;
    }

    public double getPremiQuiniela() {
        return premiQuiniela;
    }

    public void setPremiQuiniela(double premiQuiniela) {
        this.premiQuiniela = premiQuiniela;
    }
    public String[] getMarcadors() {
        return marcadors;
    }

    public void setMarcadors(String[] marcadors) {
        this.marcadors = marcadors;
    }

    public String[] getEnJocs() {
        return enJocs;
    }

    public void setEnJocs(String[] enJocs) {
        this.enJocs = enJocs;
    }

    public EstatQuiniela getEstatQuiniela() {
        return estatQuiniela;
    }

    public int getNumEncerts() {
        return numEncerts;
    }

    public void setNumEncerts(int numEncerts) {
        this.numEncerts = numEncerts;
    }

    public Date getDataActualitzacio() {
        return dataActualitzacio;
    }
    public void setDataActualitzacio(Date dataActualitzacio) {
        this.dataActualitzacio = dataActualitzacio;
    }
    public Date getDataJornada() {
        return dataJornada;
    }

    public String[] getNomsEquipsLocal() {
        return nomsEquipsLocal;
    }

    public void setNomsEquipsLocal(String[] nomsEquipsLocal) {
        this.nomsEquipsLocal = nomsEquipsLocal;
    }

    public String[] getNomsEquipsVisitant() {
        return nomsEquipsVisitant;
    }

    public void setNomsEquipsVisitant(String[] nomsEquipsVisitant) {
        this.nomsEquipsVisitant = nomsEquipsVisitant;
    }


    public void setDataJornada(Date dataJornada) {
        this.dataJornada = dataJornada;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public String[] getSignesPartit() {
        return signesPartit;
    }

    public void setSignesPartit(String[] signesPartit) {
        this.signesPartit = signesPartit;
    }

    public String toString() {
        String strRes = "";
        strRes +=
                getNumJornada() + Constants.CTE_SEPARADOR_TEXT +
                Utils.data2StringRED(getDataJornada()) + Constants.CTE_SEPARADOR_TEXT +
                Utils.data2StringExtend(getDataActualitzacio()) + Constants.CTE_SEPARADOR_TEXT +
                (getEstatQuiniela()==null ? EstatQuiniela.NOCOMP : getEstatQuiniela()) + Constants.CTE_SEPARADOR_TEXT;
        for (int i=0;i<getSignesPartit().length;i++) {
            if (i == 14) {
                strRes += (i + 1) + Constants.CTE_SEPARADOR_TEXT +
                        getNomsEquipsLocal()[i] + Constants.CTE_SEPARADOR_TEXT +
                        getMarcadors()[i] +
                        " - ";
            }
            else if (i == 15) {
                strRes += getMarcadors()[i] + Constants.CTE_SEPARADOR_TEXT +
                        getNomsEquipsLocal()[i] + Constants.CTE_SEPARADOR_TEXT +
                        getSignesPartit()[i-1] +
                        " - " +
                        getSignesPartit()[i] + Constants.CTE_SEPARADOR_TEXT;
            }
            else {
                strRes += (i + 1) + Constants.CTE_SEPARADOR_TEXT +
                        getNomsEquipsLocal()[i] + Constants.CTE_SEPARADOR_TEXT +
                        getNomsEquipsVisitant()[i] + Constants.CTE_SEPARADOR_TEXT +
                        getMarcadors()[i] + Constants.CTE_SEPARADOR_TEXT +
                        getSignesPartit()[i] + Constants.CTE_SEPARADOR_TEXT;
            }
        }
        // Número d'encerts
        strRes +=
                Utils.formatMoneda(getCosteQuiniela()) + Constants.CTE_SEPARADOR_TEXT +
                getNumEncerts() + Constants.CTE_SEPARADOR_TEXT +
                Utils.formatMoneda(getPremiQuiniela()) + Constants.CTE_SEPARADOR_TEXT +     // Premi oficial Quiniela
                Utils.formatMoneda(getPremiPerEncerts()) + Constants.CTE_SEPARADOR_TEXT;    // Premi especial per encerts
        return strRes;
    }

    public void setEstatQuiniela(EstatQuiniela p_estat) {
        estatQuiniela = p_estat;
    }
}
