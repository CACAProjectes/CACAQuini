package es.xuan.cacaquini.migracio;

import java.io.Serializable;
import java.util.Calendar;

import es.xuan.cacaquini.model.PartitMig;
import es.xuan.cacaquini.model.QuinielaMig;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Utils;

public class VBMigracioQuini extends VBMigracio implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String CTE_URL_QUINIELA_PROX = "https://www.quiniela15.com/pronostico-quiniela";
	private static final String CTE_URL_QUINIELA_JORNADA = "https://www.quiniela15.com/resultados-quiniela/";
	//	https://www.quiniela15.com/resultados-quiniela/8
	//
	public QuinielaMig getQuinielaProxima() {
        // Obtenir el contingut de la pagina
        String strContingut = getContingutURL(CTE_URL_QUINIELA_PROX);
        String strNumJornada = "0";
        String strDataJornada = "";
        String strEquipLocal = "";
        String strEquipVisitant = "";
        QuinielaMig quiniela = new QuinielaMig();        
        String marcaEquipsIni1 = "<span class=\"is-size-6 is-size-7-mobile has-text-weight-bold\">";
        String marcaEquipsFi1 = "</span>";
        int iComptador = 0;
        int ll1 = 0, ll2 = 0;
       	// Jornada actual i futures
       	strNumJornada = llegirNumJornada(strContingut);
    	quiniela.setNumJornada(Integer.parseInt(strNumJornada));
       	strDataJornada = llegirDataJornada(strContingut);
    	quiniela.setDataQuiniela(Utils.string2Data(strDataJornada));
    	//	Partits
        do {
            try {
            	//	Equip Local
                ll1 = strContingut.indexOf(marcaEquipsIni1, ll1);
                ll2 = strContingut.indexOf(marcaEquipsFi1, ll1 + 1);
            	strEquipLocal = strContingut.substring(ll1 + marcaEquipsIni1.length(), ll2);
            	//	Equip Visitant
                ll1 = strContingut.indexOf(marcaEquipsIni1, ll2);
                ll2 = strContingut.indexOf(marcaEquipsFi1, ll1 + 1);
            	strEquipVisitant = strContingut.substring(ll1 + marcaEquipsIni1.length(), ll2);
		        //
		        iComptador++;
		        //
		        PartitMig partit = new PartitMig();
		        partit.setNumPartit(iComptador);
		        partit.setNomEquipLocal(strEquipLocal);
		        partit.setNomEquipVisitant(strEquipVisitant);
		        partit.setResultatEquipLocal(0);
		        partit.setResultatEquipVisitant(0);
	        	partit.setSignePartit15l(' ');
	        	partit.setSignePartit15v(' ');
	        	partit.setSignePartit(' ');
	        	//
		        quiniela.addPartit(partit);	
		        //
		        ll1 = ll2;
            } catch (Exception ex) {
                System.err.println(ex);
            }
        } while (iComptador < 15);
        return quiniela;
    }

	private String llegirDataJornada(String strContingut) {
		String marcaJornadaActual = "Cierre pron";
		String marcaJornadaActualFin = ".";
		int ll1 = strContingut.indexOf(marcaJornadaActual);
		if (ll1<0)
			return "";
		int ll2 = strContingut.indexOf(marcaJornadaActualFin, ll1 + 1);
		String strResultat = strContingut.substring(ll1 + marcaJornadaActual.length(), ll2);
		strResultat = tractarText2Data(strResultat);
		return strResultat;
	}
	private String tractarText2Data(String p_strResultat) {
		String[] strAux = p_strResultat.split(" ");
		if (strAux.length < 8)
			return "";
		String data = strAux[2] + "/" +					//
				(calcularMes(strAux[4]) + 1) + "/" +	// Mes
				calcularAno(strAux[4]) + " " +			//
				strAux[7] ;								// Hora:Minutos
		//System.out.println(data);
		return data;
	}
	private int calcularAno(String p_mes) {
		int ano = 0;
		int mes = calcularMes(p_mes);
		//
		Calendar calendar = Calendar.getInstance();
		/*
		if (calendar.get(Calendar.MONTH) <= mes && mes >= 8)
			ano = calendar.get(Calendar.YEAR);
		else
			ano = calendar.get(Calendar.YEAR) + 1;

		 */
		ano = calendar.get(Calendar.YEAR);
		return ano;
	}

	private int calcularMes(String p_strMes) {
		int iComptador = 0;
		String[] mesos = {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
		for (String mes : mesos) {
			if (mes.equals(p_strMes))
				return iComptador;
			iComptador++;
		}
		return iComptador;
	}
	private String llegirNumJornada(String strContingut) {
		String numJornada = "0";
		try {
	        String marcaJornadaActual = "quiniela de la jornada";
	        String marcaJornadaActualFin = "|";
	        int ll1 = strContingut.indexOf(marcaJornadaActual);
	        int ll2 = strContingut.indexOf(marcaJornadaActualFin, ll1 + 1);
	        numJornada = strContingut.substring(ll1 + marcaJornadaActual.length(), ll2);
		} catch (Exception ex) {	
			numJornada = "0";
		}
		return numJornada.trim();
	}

	public QuinielaMig getQuinielaResultats(int p_iJornada) {
        // Obtenir el contingut de la pagina
        String strContingut = getContingutURL(CTE_URL_QUINIELA_JORNADA + p_iJornada);
        QuinielaMig quiniela = new QuinielaMig();        
        int iComptador = 0;
        int ll1 = 0;
        // 
    	quiniela.setNumJornada(p_iJornada);
		String strDataJornada = llegirDataJornada(strContingut);
		quiniela.setDataQuiniela(Utils.string2Data(strDataJornada));
        // Bote
        llegirBote(strContingut, quiniela);		        
    	//	Partits
        do {
            try {
		        PartitMig partit = new PartitMig();
            	//	Equip Local
                ll1 = llegirNomEquipLocal(strContingut, partit, ll1);
                if (ll1<0)
                	break;
            	//	Equip Visitant
                ll1 = llegirNomEquipVisitant(strContingut, partit, ll1);
            	//	Resultat
                ll1 = llegirResultat(strContingut, partit, ll1);
		        //
		        iComptador++;
		        //
		        partit.setNumPartit(iComptador);
	        	//
		        quiniela.addPartit(partit);	
            } catch (Exception ex) {
                System.err.println(ex);
            }
        } while (iComptador < 15);
        // Llegir pron?stics
        llegirPronostics(strContingut, quiniela, ll1);		        
        return quiniela;
	}

	private void llegirPronostics(String strContingut, QuinielaMig quiniela, int p_ind) {
		/*
			<div class="level-item has-text-centered mw-110">
                            1.738
            </div>
            <div class="level-right has-text-centered mw-110">
                135,38 <span class="is-hidden-desktop">?</span>
		 */
		double[][] dEncerts = {
				{0,0},
				{0,0},
				{0,0},
				{0,0},
				{0,0},
				{0,0}
		}; 
		String marcaPronosEncerts15Ini = "<div class=\"level-item has-text-centered-mobile mw-110\">";
		String marcaPronosEncerts15Fin = "</div>";
		String marcaPronosPremi15Ini = "<div class=\"level-right has-text-centered-mobile mw-110\">";
		String marcaPronosPremi15Fin = "<span";
		String marcaPronosEncertsIni = "<div class=\"level-item has-text-centered mw-110\">";
		String marcaPronosEncertsFin = "</div>";
		String marcaPronosPremiIni = "<div class=\"level-right has-text-centered mw-110\">";
		String marcaPronosPremiFin = "<span";
		// 	Ple al 15
		int ll1 = strContingut.indexOf(marcaPronosEncerts15Ini, p_ind);
		int ll2 = strContingut.indexOf(marcaPronosEncerts15Fin, ll1);
		if (ll1 > 0 && ll2> 0) {
			String strRes = strContingut.substring(ll1 + marcaPronosEncerts15Ini.length(), ll2);
			strRes = strRes.replace('.', ' ');
			strRes = strRes.replaceAll(" ", "");
			dEncerts[0][0] = new Double(strRes.trim());
			ll1 = strContingut.indexOf(marcaPronosPremi15Ini, ll2);
			ll2 = strContingut.indexOf(marcaPronosPremi15Fin, ll1);
			strRes = strContingut.substring(ll1 + marcaPronosPremi15Ini.length(), ll2);
			strRes = strRes.replace('.', ' ');
			strRes = strRes.replaceAll(" ", "");
			strRes = strRes.replace(',', '.');
			dEncerts[0][1] = new Double(strRes.trim());
		}
		else {
			return;
		}
		//	Del 14 al 10 encerts
		for (int i=1;i<6;i++) {
			try {
				ll1 = strContingut.indexOf(marcaPronosEncertsIni, ll2);
				ll2 = strContingut.indexOf(marcaPronosEncertsFin, ll1);
				if (ll1 > 0 && ll2> 0) {
					String strRes = strContingut.substring(ll1 + marcaPronosPremiIni.length(), ll2);
					strRes = strRes.replace('.', ' ');
					strRes = strRes.replaceAll(" ", "");
					dEncerts[i][0] = new Double(strRes.trim());
					ll1 = strContingut.indexOf(marcaPronosPremiIni, ll2);
					ll2 = strContingut.indexOf(marcaPronosPremiFin, ll1);
					strRes = strContingut.substring(ll1 + marcaPronosPremiIni.length(), ll2);
					strRes = strRes.replace('.', ' ');
					strRes = strRes.replaceAll(" ", "");
					strRes = strRes.replace(',', '.');
					dEncerts[i][1] = new Double(strRes.trim());
				}
			} catch(Exception ex) {				
			}		
		}
		quiniela.setPremisEscrutinis(dEncerts);
	}

	private void llegirBote(String strContingut, QuinielaMig quiniela) {
		//	<div class="button has-background-info has-text-weight-bold has-text-white">Bote: 1.400.000 ?</div>
		try {
			String marcaBoteIni = "Bote:";
			String marcaBoteFin = "</div>";
			int ll1 = strContingut.indexOf(marcaBoteIni);
			int ll2 = strContingut.indexOf(marcaBoteFin, ll1);
			if (ll1 > 0 && ll2> 0) {
				String strRes = strContingut.substring(ll1 + marcaBoteIni.length(), ll2);
				strRes = strRes.replace('.', ' ');
				strRes = strRes.replaceAll(" ", "");
				strRes = strRes.replaceAll(Constants.CTE_EURO, "");
				quiniela.setBote(new Double(strRes));
			}
		} catch(Exception ex) {
			quiniela.setBote(new Double(0.00));
		}		
	}

	private int llegirResultat(String strContingut, PartitMig partit, int p_ind) {
		//String marcaIni_1a = "is-vertical-center has-text-centered is-size-5 is-size-7-mobile\">";	// Resultat	1 - 1
		String marcaIni_1a = "is-vertical-center has-text-centered is-size-6 is-size-7-mobile\">";	// Resultat	1 - 1
		String marcaIni_1b = "has-text-weight-bold\">";												// Signe 	X
		//String marcaIni_2 = "is-vertical-center has-text-centered is-size-5 is-size-8-mobile\">";	// Partit no jugat encara
		String marcaIni_2 = "is-vertical-center has-text-centered is-size-6 is-size-8-mobile\">";	// Partit no jugat encara
		String marcaFiSpan = "</span>";
		String marcaBlink = "blink_me";
		//
        int ll1 = strContingut.indexOf(marcaIni_1a, p_ind);
        if (ll1 < 0) {
        	// Partit pendent
        	return p_ind + 1;
        }
        int ll2 = strContingut.indexOf(marcaIni_2, p_ind);
        String strRes = "";
        String strSigne = "";
        if (ll1 < ll2 || ll2 < 0) {
        	// Partit finalitzat
            ll2 = strContingut.indexOf(marcaFiSpan, ll1 + 1);
        	strRes = strContingut.substring(ll1 + marcaIni_1a.length(), ll2);
        	if (strRes.contains(marcaBlink)) {
            	// Partit pendent en joc, encara
        		parseResultatProv(partit, strRes);
            	strRes = "";
            	strSigne = "";
            	return ll2;
        	}
        	parserResultat(partit, strRes);
        	ll1 = strContingut.indexOf(marcaIni_1b, ll2);
            ll2 = strContingut.indexOf(marcaFiSpan, ll1 + 1);
            strSigne = strContingut.substring(ll1 + marcaIni_1b.length(), ll2);
            parserSigne(partit, strSigne);
        }
        else {
        	// Partit pendent
        	strRes = "";
        	strSigne = "";
        }
		return ll2;
	}

	private void parseResultatProv(PartitMig partit, String p_strRes) {
		try {
			String marcaBlink = "<span class=\"blink_me\">";
			int ind = p_strRes.indexOf(marcaBlink);
			String resProv = p_strRes.substring(ind + marcaBlink.length());
			String strAux[] = resProv.split("-");
			partit.setResultatEquipLocal(Integer.parseInt(strAux[0].trim()));
			partit.setResultatEquipVisitant(Integer.parseInt(strAux[1].trim()));
			partit.setEnJoc(true);
		}
		catch (Exception ex) {
		}
		
	}

	private void parserSigne(PartitMig partit, String strSigne) {
		if (strSigne.length() > 1) {
			String[] strAux = strSigne.split("-");
			partit.setSignePartit15l(strAux[0].trim().charAt(0));
			partit.setSignePartit15v(strAux[1].trim().charAt(0));
		}
		else
	        partit.setSignePartit(strSigne.charAt(0));
	}

	private void parserResultat(PartitMig partit, String strRes) {
		String marcaIni = "<span >";
		strRes = strRes.replaceAll(marcaIni, "");
		String strAux[] = strRes.split("-");
		if (!strAux[0].trim().equals(""))
			partit.setResultatEquipLocal(Integer.parseInt(strAux[0].trim()));
		else
			partit.setResultatEquipLocal(-1);
		if (!strAux[1].trim().equals(""))
			partit.setResultatEquipVisitant(Integer.parseInt(strAux[1].trim()));		
		else
			partit.setResultatEquipVisitant(-1);
	}

	private int llegirNomEquipVisitant(String strContingut, PartitMig partit, int p_ind) {
		String marcaEquipsIni = "is-size-6 is-size-7-mobile has-text-weight-bold\">";
		String marcaFiSpan = "</span>";
        int ll1 = strContingut.indexOf(marcaEquipsIni, p_ind);
		if (ll1<0)
			return -1;
        int ll2 = strContingut.indexOf(marcaFiSpan, ll1 + 1);
        partit.setNomEquipVisitant(strContingut.substring(ll1 + marcaEquipsIni.length(), ll2));
		return ll2;
	}

	private int llegirNomEquipLocal(String strContingut, PartitMig partit, int p_ind) {
		String marcaEquipsIni = "is-size-6 is-size-7-mobile has-text-weight-bold\">";
		String marcaFiSpan = "</span>";
        int ll1 = strContingut.indexOf(marcaEquipsIni, p_ind);
        if (ll1<0)
        	return -1;
        int ll2 = strContingut.indexOf(marcaFiSpan, ll1 + 1);
        partit.setNomEquipLocal(strContingut.substring(ll1 + marcaEquipsIni.length(), ll2));
		return ll2;
	}

}
