package es.xuan.cacaquini.gestio;

import java.io.Serializable;
import es.xuan.cacaquini.model.EstatQuiniela;
import es.xuan.cacaquini.model.Quiniela;
import es.xuan.cacaquini.model.Usuari;
import es.xuan.cacaquini.varis.Constants;

import static es.xuan.cacaquini.varis.Constants.CTE_APOSTA_SIMPLE;

public class GestorApostes implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
    public static ArrayList<EscrutiniBD> convertLinies2Escrutinis(ArrayList<String> p_linies) {
        ArrayList<EscrutiniBD> escrutinis = new ArrayList<>();
        for (String linia : p_linies) {
            if (linia.equals(""))
                break;
            EscrutiniBD escrutini = new EscrutiniBD();
            String[] strDades = linia.split(Constants.CTE_SEPARADOR_TEXT);
            if (!strDades[0].equals(Constants.CTE_CAPCALERA_JORNADA)) {
                // Saltar la primera linia
                escrutini.setJORNADA(Utils.string2Integer(strDades[0]));
                escrutini.setDATA(Utils.string2DataRed(strDades[1]));
                escrutini.setRECAUDACIO(Utils.string2Double(strDades[2]));
                escrutini.setIMPOSTOS(Utils.string2Double(strDades[3]));
                escrutini.setPREMIS(Utils.string2Double(strDades[4]));
                escrutini.setPLE_15_ENCERT(Utils.string2Integer(strDades[5]));
                escrutini.setPLE_15_PREMI(Utils.string2Double(strDades[6]));
                escrutini.setC14_ENCERT(Utils.string2Integer(strDades[7]));
                escrutini.setC14_PREMI(Utils.string2Double(strDades[8]));
                escrutini.setC13_ENCERT(Utils.string2Integer(strDades[9]));
                escrutini.setC13_PREMI(Utils.string2Double(strDades[10]));
                escrutini.setC12_ENCERT(Utils.string2Integer(strDades[11]));
                escrutini.setC12_PREMI(Utils.string2Double(strDades[12]));
                escrutini.setC11_ENCERT(Utils.string2Integer(strDades[13]));
                escrutini.setC11_PREMI(Utils.string2Double(strDades[14]));
                escrutini.setC10_ENCERT(Utils.string2Integer(strDades[15]));
                escrutini.setC10_PREMI(Utils.string2Double(strDades[16]));
                escrutini.setBOTE_NET(Utils.string2Double(strDades[17]));
                escrutini.setBOTE(Utils.string2Double(strDades[18]));
                escrutinis.add(escrutini);
            }
        }
        return escrutinis;
    }
     */

    public static double calcularSaldoApostat(String[] p_signes) {
        /*
            APOSTA = 0.75 * 2^NUM_APOSTA_DOBLE * 3^NUM_APOSTA_TRIPLE
         */
        int apostaSimple = 0;
        int apostaDoble = 0;
        int apostaTriple = 0;
        if (p_signes == null)
            return Constants.CTE_DOUBLE_CERO;
        for (String linia : p_signes) {
            if (linia.length() == 1)
                apostaSimple++;
            else if (linia.length() == 2)
                apostaDoble++;
            else if (linia.length() == 3)
                apostaTriple++;
        }
        if (apostaSimple + apostaDoble + apostaTriple < 16)
            // Si la quiniela no está complerta, no hi ha aposta
            return Constants.CTE_DOUBLE_CERO;
        // Aposta complerta
        double aposta = CTE_APOSTA_SIMPLE *
                Math.pow(2, apostaDoble) *
                Math.pow(3, apostaTriple);
        return aposta;
    }
    public static double calcularPremisUsuariQuiniela(Usuari p_usuari, Quiniela p_quiniela) {
        double premi = Constants.CTE_DOUBLE_CERO;
        int iNumJornada = p_quiniela.getNumJornada();
        try {
            // Obtenir escrutini de Cloud
            if (p_usuari.getQuinielasUsuari()!=null && p_usuari.getQuinielasUsuari().get(iNumJornada) != null) {
                double[][] escrutinis = p_quiniela.getPremisEscrutinis();
                // Comprovar premis
                premi = comprovarPremi(
                        p_usuari.getQuinielasUsuari().get(iNumJornada),
                        escrutinis);
                p_usuari.getQuinielasUsuari().get(iNumJornada).setPremiQuiniela(premi);
            }
        } catch (Exception ex) {
            System.err.println("calcularPremisUsuariQuiniela: " + ex);
        }
        return premi;
    }

    private static double comprovarPremi(Quiniela p_quinielasUsuari, double[][] p_escrutinis) {
        try {
            // Cercar les quinieles PENDENTS finalitzades
            if (p_escrutinis!=null && p_quinielasUsuari.getEstatQuiniela().equals(EstatQuiniela.FINALITZADA)) {
                int numEncerts = p_quinielasUsuari.getNumEncerts();
                switch (numEncerts) {
                    case 10 :
                        return p_escrutinis[5][1];
                    case 11 :
                        return p_escrutinis[4][1];
                    case 12 :
                        return p_escrutinis[3][1];
                    case 13 :
                        return p_escrutinis[2][1];
                    case 14 :
                        return p_escrutinis[1][1];
                    case 15 :
                        return p_escrutinis[0][1];
                    default:
                        break;
                }
            }
        } catch (Exception ex) {
        }
        return Constants.CTE_DOUBLE_CERO;
    }

    public static void calcularPremisUsuariPerEncerts(Quiniela p_quinielasUsuari) {
        int numEncerts = p_quinielasUsuari.getNumEncerts();
        p_quinielasUsuari.setPremiPerEncerts(Constants.CTE_PREMI_PER_ENCERT * numEncerts);
    }

    public static void sumarSaldoPremisPerEncerts(Usuari p_usuari, double p_saldoInicial) {
        double dbSaldo = p_saldoInicial;
        for (Quiniela quiniela : p_usuari.getQuinielasUsuari()) {
            if (quiniela!= null && quiniela.getEstatQuiniela().equals(EstatQuiniela.FINALITZADA)) {
                dbSaldo += quiniela.getPremiPerEncerts() - quiniela.getCosteQuiniela();
            }
        }
        p_usuari.setSaldo(dbSaldo);
    }

    public static void sumarPremisQuinielas(Usuari p_usuari) {
        double dbPremis = Constants.CTE_DOUBLE_CERO;
        for (Quiniela quiniela : p_usuari.getQuinielasUsuari()) {
            if (quiniela != null)
                dbPremis += quiniela.getPremiQuiniela();
        }
        p_usuari.setSaldoPremisQuinielas(dbPremis);
    }

    public static double calcularPercentatgeEncerts(Usuari p_usuari) {
        double numPartitsSeleccionatsQuiniela = 0;
        double numEncerts = 0;
        for (Quiniela quiniela : p_usuari.getQuinielasUsuari()) {
            if (quiniela!=null && quiniela.getEstatQuiniela().equals(EstatQuiniela.FINALITZADA)) {
                numEncerts += quiniela.getNumEncerts();
                numPartitsSeleccionatsQuiniela += comptarSignesOmplerts(quiniela);
            }
        }
        if (numPartitsSeleccionatsQuiniela == 0)
            return 0;
        return numEncerts / numPartitsSeleccionatsQuiniela;
    }

    private static int comptarSignesOmplerts(Quiniela p_quiniela) {
        int iComptador = 0;
        if (p_quiniela.getSignesPartitUsuari() == null)
            return 0;
        for (String signe : p_quiniela.getSignesPartitUsuari()) {
            if (!signe.equals(""))
                iComptador++;
        }
        return iComptador;
    }
}
