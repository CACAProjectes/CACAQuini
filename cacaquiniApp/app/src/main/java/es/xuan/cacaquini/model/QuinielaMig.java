package es.xuan.cacaquini.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class QuinielaMig implements Serializable {

	private static final long serialVersionUID = 1L;
	//
	private Date dataQuiniela;
	private int numJornada;
	private double bote;
	private ArrayList<PartitMig> partits;
	private double[][] premisEscrutinis = null;

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
	public Date getDataQuiniela() {
		return dataQuiniela;
	}
	public void setDataQuiniela(Date dataQuiniela) {
		this.dataQuiniela = dataQuiniela;
	}
	public int getNumJornada() {
		return numJornada;
	}
	public void setNumJornada(int numJornada) {
		this.numJornada = numJornada;
	}
	public ArrayList<PartitMig> getPartits() {
		return partits;
	}
	public void setPartits(ArrayList<PartitMig> partits) {
		this.partits = partits;
	}
	public void addPartit(PartitMig partit) {
		if (getPartits() == null)
			setPartits(new ArrayList<PartitMig>());
		this.partits.add(partit);		
	}

}
