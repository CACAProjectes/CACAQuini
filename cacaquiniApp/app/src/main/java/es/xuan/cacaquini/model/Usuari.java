package es.xuan.cacaquini.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import es.xuan.cacaquini.gestio.GestorApostes;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Utils;

public class Usuari implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date dataActualitzacio=new Date();
    private String nom="";
    private String cognoms="";
    private String nickname="";
    private String email="";
    private Perfil perfil = Perfil.USUARI;
    private double saldo = 0;                   // Saldo total de l'usuari
    private double saldoPremisQuinielas = 0;    // Saldo de premis oficials de totes les quinielas
    private ArrayList<Quiniela> quinielasUsuari = null;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoPremisQuinielas() {
        return saldoPremisQuinielas;
    }

    public void setSaldoPremisQuinielas(double saldoPremisQuinielas) {
        this.saldoPremisQuinielas = saldoPremisQuinielas;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Date getDataActualitzacio() {
        return dataActualitzacio;
    }

    public void setDataActualitzacio(Date dataActualitzacio) {
        this.dataActualitzacio = dataActualitzacio;
    }

    public ArrayList<Quiniela> getQuinielasUsuari() {
        if (quinielasUsuari == null)
            quinielasUsuari = new ArrayList<Quiniela>();
        return quinielasUsuari;
    }

    public void setQuinielasUsuari(int p_ind, Quiniela p_quiniela) {
        this.quinielasUsuari.set(p_ind, p_quiniela);
    }
    public void setQuinielasUsuari(ArrayList<Quiniela> quinielasUsuari) {
        this.quinielasUsuari = quinielasUsuari;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        String strRes = "";
        Quiniela quiniela = null;
        //for (Quiniela quiniela : getQuinielasUsuari()) {
        for (int i=1;i<getQuinielasUsuari().size();i++) {
            quiniela = getQuinielasUsuari().get(i);
            strRes +=
                getNickname() + Constants.CTE_SEPARADOR_TEXT +
                getEmail() + Constants.CTE_SEPARADOR_TEXT +
                getNom() + Constants.CTE_SEPARADOR_TEXT +
                getCognoms() + Constants.CTE_SEPARADOR_TEXT +
                Utils.formatMoneda(getSaldoPremisQuinielas()) + Constants.CTE_SEPARADOR_TEXT +
                Utils.formatMoneda(getSaldo()) + Constants.CTE_SEPARADOR_TEXT;
            //
            strRes += quiniela.toString();
            strRes += System.lineSeparator();
        }
        return strRes;
    }

    public void actQuinielaEnCurs(int p_numJornada, Quiniela p_quiniela) {
        if (p_numJornada >= getQuinielasUsuari().size()) {
            int iComptador = getQuinielasUsuari().size();
            for (int i=iComptador;i<=p_numJornada;i++)
                getQuinielasUsuari().add(new Quiniela());
        }
        Quiniela quiniela = getQuinielasUsuari().get(p_numJornada); // Quiniela en curs
        quiniela.setNumJornada(p_numJornada);
        quiniela.setPremisEscrutinis(p_quiniela.getPremisEscrutinis());
        quiniela.setBote(p_quiniela.getBote());
        quiniela.setSignesPartit(p_quiniela.getSignesPartit());
        quiniela.setMarcadors(p_quiniela.getMarcadors());
        // TODO: només actualitzar en cas d'estar informat
        if (p_quiniela.getDataJornada() != null)
            quiniela.setDataJornada(p_quiniela.getDataJornada());
        quiniela.setDataActualitzacio(p_quiniela.getDataActualitzacio());
        quiniela.setEnJocs(p_quiniela.getEnJocs());
        quiniela.setNomsEquipsLocal(p_quiniela.getNomsEquipsLocal());
        quiniela.setNomsEquipsVisitant(p_quiniela.getNomsEquipsVisitant());
        //
        getQuinielasUsuari().set(p_numJornada, quiniela);
    }
}
