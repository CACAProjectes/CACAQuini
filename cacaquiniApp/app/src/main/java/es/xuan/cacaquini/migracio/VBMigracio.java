package es.xuan.cacaquini.migracio;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class VBMigracio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//
	private final static String CTE_PROXY_IP = "10.126.132.10";
	private final static String CTE_PROXY_PORT = "8080";
	private static final String CTE_SEPARADOR_CSV = ";";
	private static final String CTE_CANVI_LINIA = System.lineSeparator();
	private static final String CTE_EXT_FILE_CSV = ".csv";
	//
	private BufferedWriter m_printWriter = null;

    public VBMigracio() {
    }

	private static String ckeck4Null(String pStrText) {
		if (pStrText == null)
			return "";
		return pStrText;
	}

	public static String getContingutURL(String pStrUrl) {
		URLConnection yc = null;
		InputStreamReader isr = null;
		StringBuilder lineStr = new StringBuilder();
		String strAux = "";
		try {
			yc = new URL(pStrUrl).openConnection();
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			isr = new InputStreamReader(yc.getInputStream(), StandardCharsets.UTF_8);
		} catch (Exception ex) {
			// Hi ha PROXY
		}
		/*
		if (isr == null) {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(CTE_PROXY_IP, Integer.parseInt(CTE_PROXY_PORT)));
			try {
				yc = new URL(pStrUrl).openConnection(proxy);
				isr = new InputStreamReader(yc.getInputStream(), StandardCharsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		 */
		if (isr != null) {
			try {
				//
				BufferedReader in = new BufferedReader(isr);
				while ((strAux = in.readLine()) != null) {
					lineStr.append(strAux);
				}
				in.close();
				isr.close();
			} catch (Exception ex) {
				System.err.println("Error -getContingutURL.1-: " + ex);
			}
		}
		return lineStr.toString();
	}
}
