package es.xuan.cacaquini.model;

import java.io.Serializable;
import java.util.Date;

public class EscrutiniBD implements Serializable {
    private static final long serialVersionUID = 1L;

    private int JORNADA;
    private Date DATA;
    private double RECAUDACIO;
    private double IMPOSTOS;
    private double PREMIS;
    private int PLE_15_ENCERT;
    private double PLE_15_PREMI;
    private int C14_ENCERT;
    private double C14_PREMI;
    private int C13_ENCERT;
    private double C13_PREMI;
    private int C12_ENCERT;
    private double C12_PREMI;
    private int C11_ENCERT;
    private double C11_PREMI;
    private int C10_ENCERT;
    private double C10_PREMI;
    private double BOTE_NET;
    private double BOTE;

    public double getBOTE_NET() {
        return BOTE_NET;
    }

    public void setBOTE_NET(double BOTE_NET) {
        this.BOTE_NET = BOTE_NET;
    }

    public double getBOTE() {
        return BOTE;
    }

    public void setBOTE(double BOTE) {
        this.BOTE = BOTE;
    }

    public int getJORNADA() {
        return JORNADA;
    }

    public void setJORNADA(int JORNADA) {
        this.JORNADA = JORNADA;
    }

    public Date getDATA() {
        return DATA;
    }

    public void setDATA(Date DATA) {
        this.DATA = DATA;
    }

    public double getRECAUDACIO() {
        return RECAUDACIO;
    }

    public void setRECAUDACIO(double RECAUDACIO) {
        this.RECAUDACIO = RECAUDACIO;
    }

    public double getIMPOSTOS() {
        return IMPOSTOS;
    }

    public void setIMPOSTOS(double IMPOSTOS) {
        this.IMPOSTOS = IMPOSTOS;
    }

    public double getPREMIS() {
        return PREMIS;
    }

    public void setPREMIS(double PREMIS) {
        this.PREMIS = PREMIS;
    }

    public int getPLE_15_ENCERT() {
        return PLE_15_ENCERT;
    }

    public void setPLE_15_ENCERT(int PLE_15_ENCERT) {
        this.PLE_15_ENCERT = PLE_15_ENCERT;
    }

    public double getPLE_15_PREMI() {
        return PLE_15_PREMI;
    }

    public void setPLE_15_PREMI(double PLE_15_PREMI) {
        this.PLE_15_PREMI = PLE_15_PREMI;
    }

    public int getC14_ENCERT() {
        return C14_ENCERT;
    }

    public void setC14_ENCERT(int c14_ENCERT) {
        C14_ENCERT = c14_ENCERT;
    }

    public double getC14_PREMI() {
        return C14_PREMI;
    }

    public void setC14_PREMI(double c14_PREMI) {
        C14_PREMI = c14_PREMI;
    }

    public int getC13_ENCERT() {
        return C13_ENCERT;
    }

    public void setC13_ENCERT(int c13_ENCERT) {
        C13_ENCERT = c13_ENCERT;
    }

    public double getC13_PREMI() {
        return C13_PREMI;
    }

    public void setC13_PREMI(double c13_PREMI) {
        C13_PREMI = c13_PREMI;
    }

    public int getC12_ENCERT() {
        return C12_ENCERT;
    }

    public void setC12_ENCERT(int c12_ENCERT) {
        C12_ENCERT = c12_ENCERT;
    }

    public double getC12_PREMI() {
        return C12_PREMI;
    }

    public void setC12_PREMI(double c12_PREMI) {
        C12_PREMI = c12_PREMI;
    }

    public int getC11_ENCERT() {
        return C11_ENCERT;
    }

    public void setC11_ENCERT(int c11_ENCERT) {
        C11_ENCERT = c11_ENCERT;
    }

    public double getC11_PREMI() {
        return C11_PREMI;
    }

    public void setC11_PREMI(double c11_PREMI) {
        C11_PREMI = c11_PREMI;
    }

    public int getC10_ENCERT() {
        return C10_ENCERT;
    }

    public void setC10_ENCERT(int c10_ENCERT) {
        C10_ENCERT = c10_ENCERT;
    }

    public double getC10_PREMI() {
        return C10_PREMI;
    }

    public void setC10_PREMI(double c10_PREMI) {
        C10_PREMI = c10_PREMI;
    }
}
