package es.xuan.cacaquini.model;

import java.io.Serializable;

public class PartitMig implements Serializable {

	private static final long serialVersionUID = 1L;
	//
	private int numPartit;
	private String nomEquipLocal;
	private String nomEquipVisitant;
	private int resultatEquipLocal;
	private int resultatEquipVisitant;
	private char signePartit;
	private char signePartit15l;		// Segon signe del ple al 15 Local
	private char signePartit15v;		// Segon signe del ple al 15 Visitant
	private boolean isEnJoc = false;	// Resultat en joc

	public boolean isEnJoc() {
		return isEnJoc;
	}

	public void setEnJoc(boolean enJoc) {
		isEnJoc = enJoc;
	}

	public int getNumPartit() {
		return numPartit;
	}
	public void setNumPartit(int numPartit) {
		this.numPartit = numPartit;
	}
	public String getNomEquipLocal() {
		return nomEquipLocal;
	}
	public void setNomEquipLocal(String nomEquipLocal) {
		this.nomEquipLocal = nomEquipLocal;
	}
	public String getNomEquipVisitant() {
		return nomEquipVisitant;
	}
	public void setNomEquipVisitant(String nomEquipVisitant) {
		this.nomEquipVisitant = nomEquipVisitant;
	}
	public int getResultatEquipLocal() {
		return resultatEquipLocal;
	}
	public void setResultatEquipLocal(int resultatEquipLocal) {
		this.resultatEquipLocal = resultatEquipLocal;
	}
	public int getResultatEquipVisitant() {
		return resultatEquipVisitant;
	}
	public void setResultatEquipVisitant(int resultatEquipVisitant) {
		this.resultatEquipVisitant = resultatEquipVisitant;
	}
	public char getSignePartit() {
		return signePartit;
	}
	public void setSignePartit(char signePartit) {
		this.signePartit = signePartit;
	}
	public char getSignePartit15l() {
		return signePartit15l;
	}
	public void setSignePartit15l(char signePartit15l) {
		this.signePartit15l = signePartit15l;
	}
	public char getSignePartit15v() {
		return signePartit15v;
	}
	public void setSignePartit15v(char signePartit15v) {
		this.signePartit15v = signePartit15v;
	}

	
}
