package es.xuan.cacaquini.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.Serializable;
import java.lang.reflect.Field;
import es.xuan.cacaquini.MainActivity;
import es.xuan.cacaquini.R;
import es.xuan.cacaquini.files.SPCloud;
import es.xuan.cacaquini.gestio.GestorApostes;
import es.xuan.cacaquini.gestio.GestorUsuari;
import es.xuan.cacaquini.model.EstatQuiniela;
import es.xuan.cacaquini.model.Quiniela;
import es.xuan.cacaquini.model.Usuari;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Utils;

public class Pantalla implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private int x_cord_ini = 0;
    private int x_cord_fin = 0;
    //
    private MainActivity m_activity;
    private Vibrator m_vibr;
    private SharedPreferences m_spDades;
    private SPCloud m_spCloud;
    private EstatQuiniela m_quinielaBloquetjada = EstatQuiniela.PDT;
    // Usuari
    private Usuari m_usuari;
    //  Linia 1 - 1X2
    private TextView m_tvCol12 = null;
    private TextView m_tvCol13 = null;
    private TextView m_tvCol14 = null;
    private TextView m_tvCol15 = null;
    private TextView m_tvCol16 = null;
    private TextView m_tvCol17 = null;
    private TextView m_tvCol18 = null;
    //  Linia 2 - 1X2
    private TextView m_tvCol22 = null;
    private TextView m_tvCol23 = null;
    private TextView m_tvCol24 = null;
    private TextView m_tvCol25 = null;
    private TextView m_tvCol26 = null;
    private TextView m_tvCol27 = null;
    private TextView m_tvCol28 = null;
    //  Linia 3 - 1X2
    private TextView m_tvCol32 = null;
    private TextView m_tvCol33 = null;
    private TextView m_tvCol34 = null;
    private TextView m_tvCol35 = null;
    private TextView m_tvCol36 = null;
    private TextView m_tvCol37 = null;
    private TextView m_tvCol38 = null;
    //  Linia 4 - 1X2
    private TextView m_tvCol42 = null;
    private TextView m_tvCol43 = null;
    private TextView m_tvCol44 = null;
    private TextView m_tvCol45 = null;
    private TextView m_tvCol46 = null;
    private TextView m_tvCol47 = null;
    private TextView m_tvCol48 = null;
    //  Linia 5 - 1X2
    private TextView m_tvCol52 = null;
    private TextView m_tvCol53 = null;
    private TextView m_tvCol54 = null;
    private TextView m_tvCol55 = null;
    private TextView m_tvCol56 = null;
    private TextView m_tvCol57 = null;
    private TextView m_tvCol58 = null;
    //  Linia 6 - 1X2
    private TextView m_tvCol62 = null;
    private TextView m_tvCol63 = null;
    private TextView m_tvCol64 = null;
    private TextView m_tvCol65 = null;
    private TextView m_tvCol66 = null;
    private TextView m_tvCol67 = null;
    private TextView m_tvCol68 = null;
    //  Linia 7 - 1X2
    private TextView m_tvCol72 = null;
    private TextView m_tvCol73 = null;
    private TextView m_tvCol74 = null;
    private TextView m_tvCol75 = null;
    private TextView m_tvCol76 = null;
    private TextView m_tvCol77 = null;
    private TextView m_tvCol78 = null;
    //  Linia 8 - 1X2
    private TextView m_tvCol82 = null;
    private TextView m_tvCol83 = null;
    private TextView m_tvCol84 = null;
    private TextView m_tvCol85 = null;
    private TextView m_tvCol86 = null;
    private TextView m_tvCol87 = null;
    private TextView m_tvCol88 = null;
    //  Linia 9 - 1X2
    private TextView m_tvCol92 = null;
    private TextView m_tvCol93 = null;
    private TextView m_tvCol94 = null;
    private TextView m_tvCol95 = null;
    private TextView m_tvCol96 = null;
    private TextView m_tvCol97 = null;
    private TextView m_tvCol98 = null;
    //  Linia 10 - 1X2
    private TextView m_tvCol102 = null;
    private TextView m_tvCol103 = null;
    private TextView m_tvCol104 = null;
    private TextView m_tvCol105 = null;
    private TextView m_tvCol106 = null;
    private TextView m_tvCol107 = null;
    private TextView m_tvCol108 = null;
    //  Linia 11 - 1X2
    private TextView m_tvCol112 = null;
    private TextView m_tvCol113 = null;
    private TextView m_tvCol114 = null;
    private TextView m_tvCol115 = null;
    private TextView m_tvCol116 = null;
    private TextView m_tvCol117 = null;
    private TextView m_tvCol118 = null;
    //  Linia 12 - 1X2
    private TextView m_tvCol122 = null;
    private TextView m_tvCol123 = null;
    private TextView m_tvCol124 = null;
    private TextView m_tvCol125 = null;
    private TextView m_tvCol126 = null;
    private TextView m_tvCol127 = null;
    private TextView m_tvCol128 = null;
    //  Linia 13 - 1X2
    private TextView m_tvCol132 = null;
    private TextView m_tvCol133 = null;
    private TextView m_tvCol134 = null;
    private TextView m_tvCol135 = null;
    private TextView m_tvCol136 = null;
    private TextView m_tvCol137 = null;
    private TextView m_tvCol138 = null;
    //  Linia 14 - 1X2
    private TextView m_tvCol142 = null;
    private TextView m_tvCol143 = null;
    private TextView m_tvCol144 = null;
    private TextView m_tvCol145 = null;
    private TextView m_tvCol146 = null;
    private TextView m_tvCol147 = null;
    private TextView m_tvCol148 = null;
    //  Ple al 15a - 1X2
    private TextView m_tvCol15a2 = null;
    private TextView m_tvCol15a3 = null;
    private TextView m_tvCol15a5a = null;
    private TextView m_tvCol15a5b = null;
    private TextView m_tvCol15a6 = null;
    private TextView m_tvCol15a7 = null;
    private TextView m_tvCol15a8 = null;
    //  Ple al 15b - 1X2
    private TextView m_tvCol15b2 = null;
    private TextView m_tvCol15b3 = null;
    private TextView m_tvCol15b5a = null;
    private TextView m_tvCol15b5b = null;
    private TextView m_tvCol15b6 = null;
    private TextView m_tvCol15b7 = null;
    private TextView m_tvCol15b8 = null;
    //  Saldos
    private TextView m_tvSaldoCol32 = null;
    private TextView m_tvSaldoCol42 = null;
    private TextView m_tvSaldoCol52 = null;
    private TextView m_tvSaldoCol22 = null;
    private TextView m_tvSubCapcalera2 = null;
    private TextView m_tvSubCapcalera2a = null;
    private TextView m_tvSaldoCol72 = null;
    private TextView m_tvSaldoCol82 = null;
    private TextView m_tvSaldoCol92 = null;
    private TextView m_tvSubCapcaleraPerc = null;
    //
    private TextView m_tvEstatQuiniela = null;
    private TextView m_tvBote = null;
    // Titols
    private TextView m_fabJornadaActual = null;
    private TextView m_tvNomUsuari = null;

    public Pantalla(MainActivity p_activity) {
        // SharedPreferences p_spDades, Usuari p_usuari, Quiniela p_quiniela
        m_usuari = p_activity.getUsuari();
        m_spDades = p_activity.getSpDades();
        m_spCloud = p_activity.getSpCloud();
    }

    private void iniXarxesSocials() {
        // Enviar email - Gmail
        ImageView button2 = m_activity.findViewById(R.id.ivGmail);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW", Uri.parse(m_activity.getString(R.string.urlGmail)));
                m_activity.startActivity(viewIntent);
            }
        });
        // Facebook
        ImageView button3 = m_activity.findViewById(R.id.ivFacebook);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW", Uri.parse(m_activity.getString(R.string.urlFacebook)));
                m_activity.startActivity(viewIntent);
            }
        });
        // Twitter
        ImageView button4 = m_activity.findViewById(R.id.ivTwitter);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW", Uri.parse(m_activity.getString(R.string.urlTwitter)));
                m_activity.startActivity(viewIntent);
            }
        });
        // Instagram
        ImageView button5 = m_activity.findViewById(R.id.ivInstagram);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW", Uri.parse(m_activity.getString(R.string.urlInstagram)));
                m_activity.startActivity(viewIntent);
            }
        });
    }

    public void inicialitzarPantalla(MainActivity p_anActivity) {
        //
        m_activity = p_anActivity;
        m_vibr = (Vibrator) p_anActivity.getSystemService(p_anActivity.VIBRATOR_SERVICE);
        //  Inicialitzar els enllaços a les xarxes socials
        iniXarxesSocials();
        //  Inicialitzar i configuració de l'usuari

        ImageView m_ivUsuari = (ImageView)m_activity.findViewById(R.id.ivUsuari);
        m_ivUsuari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                //
                m_activity.sendMessageToActivity(m_usuari);
            }
        });
        //  Botó flotant per jornada actual
        m_fabJornadaActual = (TextView)m_activity.findViewById(R.id.fabJornadaActual);
        m_fabJornadaActual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                //
                m_activity.guardarQuinielaEnCurs2Usuari(0);
                //
                omplirDades();
            }
        });
        //  Botó flotant per jornada actual
        ImageView m_fabJornadaAnt = (ImageView)m_activity.findViewById(R.id.fabJornadaAnt);
        m_fabJornadaAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                int numJornada = m_activity.getNumJornadaEnCurs() - 1;
                if (numJornada > 0) {
                    recuperarQuinielaJornadaMem(numJornada);
                    omplirDades();
                }
            }
        });
        //  Botó flotant per jornada actual
        ImageView m_fabJornadaSeg = (ImageView)m_activity.findViewById(R.id.fabJornadaSeg);
        m_fabJornadaSeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                int numJornada = m_activity.getNumJornadaEnCurs() + 1;
                recuperarQuinielaJornadaMem(numJornada);
                omplirDades();
            }
        });
        //  Botó flotant per jornada actual
        FloatingActionButton m_fabRefresh = (FloatingActionButton)m_activity.findViewById(R.id.fabRefresh);
        m_fabRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                int numJornada = m_activity.getNumJornadaEnCurs();
                //recuperarQuinielaJornadaMem(numJornada);
                recuperarQuinielaRefresh(numJornada);
                omplirDades();
            }
        });
        // Drag&Drop de la quiniela
        desplacamentQuiniela();
        // Jornada
        m_tvNomUsuari = (TextView)m_activity.findViewById(R.id.tvNomUsuari);        // Nom usuari
        // Linia 1 - 1X2
        m_tvCol12 = (TextView)m_activity.findViewById(R.id.tvCol12);        // Equip local
        m_tvCol13 = (TextView)m_activity.findViewById(R.id.tvCol13);        // Resultat
        m_tvCol14 = (TextView)m_activity.findViewById(R.id.tvCol14);        // Equip visitant
        m_tvCol15 = inicialitzarLinia1X2(R.id.tvCol15);
        m_tvCol16 = inicialitzarLinia1X2(R.id.tvCol16);
        m_tvCol17 = inicialitzarLinia1X2(R.id.tvCol17);
        m_tvCol18 = (TextView)m_activity.findViewById(R.id.tvCol18);        // Resultat
        // Linia 2 - 1X2
        m_tvCol22 = (TextView)m_activity.findViewById(R.id.tvCol22);        // Equip local
        m_tvCol23 = (TextView)m_activity.findViewById(R.id.tvCol23);        // Resultat
        m_tvCol24 = (TextView)m_activity.findViewById(R.id.tvCol24);        // Equip visitant
        m_tvCol25 = inicialitzarLinia1X2(R.id.tvCol25);
        m_tvCol26 = inicialitzarLinia1X2(R.id.tvCol26);
        m_tvCol27 = inicialitzarLinia1X2(R.id.tvCol27);
        m_tvCol28 = (TextView)m_activity.findViewById(R.id.tvCol28);        // Resultat
        // Linia 3 - 1X2
        m_tvCol32 = (TextView)m_activity.findViewById(R.id.tvCol32);        // Equip local
        m_tvCol33 = (TextView)m_activity.findViewById(R.id.tvCol33);        // Resultat
        m_tvCol34 = (TextView)m_activity.findViewById(R.id.tvCol34);        // Equip visitant
        m_tvCol35 = inicialitzarLinia1X2(R.id.tvCol35);
        m_tvCol36 = inicialitzarLinia1X2(R.id.tvCol36);
        m_tvCol37 = inicialitzarLinia1X2(R.id.tvCol37);
        m_tvCol38 = (TextView)m_activity.findViewById(R.id.tvCol38);        // Resultat
        // Linia 4 - 1X2
        m_tvCol42 = (TextView)m_activity.findViewById(R.id.tvCol42);        // Equip local
        m_tvCol43 = (TextView)m_activity.findViewById(R.id.tvCol43);        // Resultat
        m_tvCol44 = (TextView)m_activity.findViewById(R.id.tvCol44);        // Equip visitant
        m_tvCol45 = inicialitzarLinia1X2(R.id.tvCol45);
        m_tvCol46 = inicialitzarLinia1X2(R.id.tvCol46);
        m_tvCol47 = inicialitzarLinia1X2(R.id.tvCol47);
        m_tvCol48 = (TextView)m_activity.findViewById(R.id.tvCol48);        // Resultat
        // Linia 5 - 1X2
        m_tvCol52 = (TextView)m_activity.findViewById(R.id.tvCol52);        // Equip local
        m_tvCol53 = (TextView)m_activity.findViewById(R.id.tvCol53);        // Resultat
        m_tvCol54 = (TextView)m_activity.findViewById(R.id.tvCol54);        // Equip visitant
        m_tvCol55 = inicialitzarLinia1X2(R.id.tvCol55);
        m_tvCol56 = inicialitzarLinia1X2(R.id.tvCol56);
        m_tvCol57 = inicialitzarLinia1X2(R.id.tvCol57);
        m_tvCol58 = (TextView)m_activity.findViewById(R.id.tvCol58);        // Resultat
        // Linia 6 - 1X2
        m_tvCol62 = (TextView)m_activity.findViewById(R.id.tvCol62);        // Equip local
        m_tvCol63 = (TextView)m_activity.findViewById(R.id.tvCol63);        // Resultat
        m_tvCol64 = (TextView)m_activity.findViewById(R.id.tvCol64);        // Equip visitant
        m_tvCol65 = inicialitzarLinia1X2(R.id.tvCol65);
        m_tvCol66 = inicialitzarLinia1X2(R.id.tvCol66);
        m_tvCol67 = inicialitzarLinia1X2(R.id.tvCol67);
        m_tvCol68 = (TextView)m_activity.findViewById(R.id.tvCol68);        // Resultat
        // Linia 7 - 1X2
        m_tvCol72 = (TextView)m_activity.findViewById(R.id.tvCol72);        // Equip local
        m_tvCol73 = (TextView)m_activity.findViewById(R.id.tvCol73);        // Resultat
        m_tvCol74 = (TextView)m_activity.findViewById(R.id.tvCol74);        // Equip visitant
        m_tvCol75 = inicialitzarLinia1X2(R.id.tvCol75);
        m_tvCol76 = inicialitzarLinia1X2(R.id.tvCol76);
        m_tvCol77 = inicialitzarLinia1X2(R.id.tvCol77);
        m_tvCol78 = (TextView)m_activity.findViewById(R.id.tvCol78);        // Resultat
        // Linia 8 - 1X2
        m_tvCol82 = (TextView)m_activity.findViewById(R.id.tvCol82);        // Equip local
        m_tvCol83 = (TextView)m_activity.findViewById(R.id.tvCol83);        // Resultat
        m_tvCol84 = (TextView)m_activity.findViewById(R.id.tvCol84);        // Equip visitant
        m_tvCol85 = inicialitzarLinia1X2(R.id.tvCol85);
        m_tvCol86 = inicialitzarLinia1X2(R.id.tvCol86);
        m_tvCol87 = inicialitzarLinia1X2(R.id.tvCol87);
        m_tvCol88 = (TextView)m_activity.findViewById(R.id.tvCol88);        // Resultat
        // Linia 9 - 1X2
        m_tvCol92 = (TextView)m_activity.findViewById(R.id.tvCol92);        // Equip local
        m_tvCol93 = (TextView)m_activity.findViewById(R.id.tvCol93);        // Resultat
        m_tvCol94 = (TextView)m_activity.findViewById(R.id.tvCol94);        // Equip visitant
        m_tvCol95 = inicialitzarLinia1X2(R.id.tvCol95);
        m_tvCol96 = inicialitzarLinia1X2(R.id.tvCol96);
        m_tvCol97 = inicialitzarLinia1X2(R.id.tvCol97);
        m_tvCol98 = (TextView)m_activity.findViewById(R.id.tvCol98);        // Resultat
        // Linia 10 - 1X2
        m_tvCol102 = (TextView)m_activity.findViewById(R.id.tvCol102);        // Equip local
        m_tvCol103 = (TextView)m_activity.findViewById(R.id.tvCol103);        // Resultat
        m_tvCol104 = (TextView)m_activity.findViewById(R.id.tvCol104);        // Equip visitant
        m_tvCol105 = inicialitzarLinia1X2(R.id.tvCol105);
        m_tvCol106 = inicialitzarLinia1X2(R.id.tvCol106);
        m_tvCol107 = inicialitzarLinia1X2(R.id.tvCol107);
        m_tvCol108 = (TextView)m_activity.findViewById(R.id.tvCol108);        // Resultat
        // Linia 11 - 1X2
        m_tvCol112 = (TextView)m_activity.findViewById(R.id.tvCol112);        // Equip local
        m_tvCol113 = (TextView)m_activity.findViewById(R.id.tvCol113);        // Resultat
        m_tvCol114 = (TextView)m_activity.findViewById(R.id.tvCol114);        // Equip visitant
        m_tvCol115 = inicialitzarLinia1X2(R.id.tvCol115);
        m_tvCol116 = inicialitzarLinia1X2(R.id.tvCol116);
        m_tvCol117 = inicialitzarLinia1X2(R.id.tvCol117);
        m_tvCol118 = (TextView)m_activity.findViewById(R.id.tvCol118);        // Resultat
        // Linia 12 - 1X2
        m_tvCol122 = (TextView)m_activity.findViewById(R.id.tvCol122);        // Equip local
        m_tvCol123 = (TextView)m_activity.findViewById(R.id.tvCol123);        // Resultat
        m_tvCol124 = (TextView)m_activity.findViewById(R.id.tvCol124);        // Equip visitant
        m_tvCol125 = inicialitzarLinia1X2(R.id.tvCol125);
        m_tvCol126 = inicialitzarLinia1X2(R.id.tvCol126);
        m_tvCol127 = inicialitzarLinia1X2(R.id.tvCol127);
        m_tvCol128 = (TextView)m_activity.findViewById(R.id.tvCol128);        // Resultat
        // Linia 13 - 1X2
        m_tvCol132 = (TextView)m_activity.findViewById(R.id.tvCol132);        // Equip local
        m_tvCol133 = (TextView)m_activity.findViewById(R.id.tvCol133);        // Resultat
        m_tvCol134 = (TextView)m_activity.findViewById(R.id.tvCol134);        // Equip visitant
        m_tvCol135 = inicialitzarLinia1X2(R.id.tvCol135);
        m_tvCol136 = inicialitzarLinia1X2(R.id.tvCol136);
        m_tvCol137 = inicialitzarLinia1X2(R.id.tvCol137);
        m_tvCol138 = (TextView)m_activity.findViewById(R.id.tvCol138);        // Resultat
        // Linia 14 - 1X2
        m_tvCol142 = (TextView)m_activity.findViewById(R.id.tvCol142);        // Equip local
        m_tvCol143 = (TextView)m_activity.findViewById(R.id.tvCol143);        // Resultat
        m_tvCol144 = (TextView)m_activity.findViewById(R.id.tvCol144);        // Equip visitant
        m_tvCol145 = inicialitzarLinia1X2(R.id.tvCol145);
        m_tvCol146 = inicialitzarLinia1X2(R.id.tvCol146);
        m_tvCol147 = inicialitzarLinia1X2(R.id.tvCol147);
        m_tvCol148 = (TextView)m_activity.findViewById(R.id.tvCol148);        // Resultat
        //  Linia 15a - 1X2
        m_tvCol15a2 = (TextView)m_activity.findViewById(R.id.tvCol15a2);    // Equip local
        m_tvCol15a3 = (TextView)m_activity.findViewById(R.id.tvCol15a3);    // Marcador local
        m_tvCol15a5a = inicialitzarLinia1X2(R.id.tvCol15a5a);
        m_tvCol15a5b = inicialitzarLinia1X2(R.id.tvCol15a5b);
        m_tvCol15a6 = inicialitzarLinia1X2(R.id.tvCol15a6);
        m_tvCol15a7 = inicialitzarLinia1X2(R.id.tvCol15a7);
        m_tvCol15a8 = (TextView)m_activity.findViewById(R.id.tvCol15a8);    // Signe local
        //  Linia 15b - 1X2
        m_tvCol15b2 = (TextView)m_activity.findViewById(R.id.tvCol15b2);    // Equip visitant
        m_tvCol15b3 = (TextView)m_activity.findViewById(R.id.tvCol15b3);    // Marcador visitant
        m_tvCol15b5a = inicialitzarLinia1X2(R.id.tvCol15b5a);
        m_tvCol15b5b = inicialitzarLinia1X2(R.id.tvCol15b5b);
        m_tvCol15b6 = inicialitzarLinia1X2(R.id.tvCol15b6);
        m_tvCol15b7 = inicialitzarLinia1X2(R.id.tvCol15b7);
        m_tvCol15b8 = (TextView)m_activity.findViewById(R.id.tvCol15b8);    // Signe visitant
        // Saldo
        m_tvSaldoCol32 = (TextView)m_activity.findViewById(R.id.tvSaldoCol32);          // Aposta simple
        m_tvSaldoCol42 = (TextView)m_activity.findViewById(R.id.tvSaldoCol42);          // Aposta doble
        m_tvSaldoCol52 = (TextView)m_activity.findViewById(R.id.tvSaldoCol52);          // Aposta triple
        m_tvSaldoCol22 = (TextView)m_activity.findViewById(R.id.tvSaldoCol22);          // Quantitat apostada
        //
        m_tvSubCapcalera2 = (TextView)m_activity.findViewById(R.id.tvSubCapcalera2);    // Saldo disponible - Capçalera
        m_tvSubCapcalera2a = (TextView)m_activity.findViewById(R.id.tvSubCapcalera2a);  // Saldo premis - Capçalera
        m_tvSaldoCol72 = (TextView)m_activity.findViewById(R.id.tvSaldoCol72);          // Núm. encerts
        //
        m_tvSaldoCol82 = (TextView)m_activity.findViewById(R.id.tvSaldoCol82);          // Premi per encerts
        m_tvSaldoCol92 = (TextView)m_activity.findViewById(R.id.tvSaldoCol92);          // Premi de la quiniela
        m_tvSubCapcaleraPerc = (TextView)m_activity.findViewById(R.id.tvSubCapcaleraPerc);          // Percentatge d'encerts
        //
        m_tvEstatQuiniela = (TextView)m_activity.findViewById(R.id.tvEstatQuiniela);    // Estat de la quiniela: BLOQUETJADA, INCOMPLETA, PREPARADA
        m_tvBote = (TextView)m_activity.findViewById(R.id.tvBote);    // Bote de la quiniela
        m_tvBote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                //
                Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
                if (quiniela != null && quiniela.getPremisEscrutinis() != null) {
                    String strInformacioEscrutini = textEscrutinis(quiniela);
                    Toast.makeText(m_activity.getApplicationContext(), strInformacioEscrutini, Toast.LENGTH_LONG).show();
                }
            }
        });
        //
        omplirDades();
    }

    private String textEscrutinis(Quiniela m_quiniela) {
        /*
                Premios de La Quiniela
        Categoría			Acertantes	Euros
        Pleno al 15			0			0,00
        1ª (14 Aciertos)	8			70.635,92
        2ª (13 Aciertos)	185			1.431,81
        3ª (12 Aciertos)	2.705		97,92
        4ª (11 Aciertos)	22.482		11,78
        5ª (10 Aciertos)	113.307		2,81
         */
        String strRes = "" +
                "- Premis de La Quiniela -" + Constants.CTE_CANVI_LINEA_DESCRIP +
                "Categoria ___ Encertants ___ Premi" + Constants.CTE_CANVI_LINEA_DESCRIP +
                "Ple al 15"+ Utils.omplirText(m_activity, Utils.formatSeparadorNum(m_quiniela.getPremisEscrutinis()[0][0]), 11)+Utils.omplirText(m_activity, Utils.formatMoneda(m_quiniela.getPremisEscrutinis()[0][1]), 16) + " " + Constants.CTE_CANVI_LINEA_DESCRIP +
                "1a. de 14"+ Utils.omplirText(m_activity, Utils.formatSeparadorNum(m_quiniela.getPremisEscrutinis()[1][0]), 10)+Utils.omplirText(m_activity, Utils.formatMoneda(m_quiniela.getPremisEscrutinis()[1][1]), 16) + " " + Constants.CTE_CANVI_LINEA_DESCRIP +
                "2a. de 13"+ Utils.omplirText(m_activity, Utils.formatSeparadorNum(m_quiniela.getPremisEscrutinis()[2][0]), 10)+Utils.omplirText(m_activity, Utils.formatMoneda(m_quiniela.getPremisEscrutinis()[2][1]), 16) + " " + Constants.CTE_CANVI_LINEA_DESCRIP +
                "3a. de 12"+ Utils.omplirText(m_activity, Utils.formatSeparadorNum(m_quiniela.getPremisEscrutinis()[3][0]), 10)+Utils.omplirText(m_activity, Utils.formatMoneda(m_quiniela.getPremisEscrutinis()[3][1]), 16) + " " + Constants.CTE_CANVI_LINEA_DESCRIP +
                "4a. de 11"+ Utils.omplirText(m_activity, Utils.formatSeparadorNum(m_quiniela.getPremisEscrutinis()[4][0]), 10)+Utils.omplirText(m_activity, Utils.formatMoneda(m_quiniela.getPremisEscrutinis()[4][1]), 16) + " " + Constants.CTE_CANVI_LINEA_DESCRIP +
                "5a. de 10"+ Utils.omplirText(m_activity, Utils.formatSeparadorNum(m_quiniela.getPremisEscrutinis()[5][0]), 10)+Utils.omplirText(m_activity, Utils.formatMoneda(m_quiniela.getPremisEscrutinis()[5][1]), 16) + " " + Constants.CTE_CANVI_LINEA_DESCRIP;
        return strRes;
    }

    private void recuperarQuinielaRefresh(int p_numJornada) {
            m_activity.guardarQuinielaEnCurs2Usuari(p_numJornada);
    }
    private void recuperarQuinielaJornadaMem(int p_numJornada) {
        if (p_numJornada >= m_usuari.getQuinielasUsuari().size()) {
            m_activity.guardarQuinielaEnCurs2Usuari(p_numJornada);
        }
        else {
            Quiniela quiniela = m_usuari.getQuinielasUsuari().get(p_numJornada);
            if (!(quiniela != null &&
                    quiniela.getEstatQuiniela().equals(EstatQuiniela.FINALITZADA) &&
                    quiniela.getSignesPartit() != null &&
                    quiniela.getSignesPartit().length > 0 &&
                    !quiniela.getSignesPartit()[0].equals(""))) {
                m_activity.guardarQuinielaEnCurs2Usuari(p_numJornada);
            }
            else {
                // En qualsevo cas s'ha d'actualitzar el número de la jornada
                m_activity.setNumJornadaEnCurs(p_numJornada);
            }
        }
    }

    private void omplirDades() {
        omplirJornadaNom();
        omplirPartits();
        omplirSaldoApostes();
        omplirPremis();
        //omplirDadesPartits2Usuari();
        omplirEstatQuiniela();
    }

    private void omplirEstatQuiniela() {
        m_tvEstatQuiniela.setText(m_quinielaBloquetjada.getEstat());
        m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs()).setEstatQuiniela(m_quinielaBloquetjada);
    }

    private int formatSigne(TextView pView, String[] pValorQuiniela, String[] pValorUsuari, int p_ind) {
        // Retorna el número de signe informat
        if (pValorQuiniela == null || (pValorQuiniela != null && pValorQuiniela[p_ind].trim().equals(""))) {
            pView.setBackgroundResource(R.color.colorPendent);
            pView.setText("?");
            return 0;
        }
        else {
            if (m_quinielaBloquetjada != EstatQuiniela.ENJOC) {
                m_quinielaBloquetjada = EstatQuiniela.BLOQ;
                m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs()).setEstatQuiniela(m_quinielaBloquetjada);
            }
            pView.setText(pValorQuiniela[p_ind]);
            if (pValorUsuari != null && pValorUsuari[p_ind].contains(pValorQuiniela[p_ind]) && !pValorUsuari[p_ind].equals("")) {
                pView.setBackgroundResource(R.color.colorEncert);
            }
            else {
                pView.setBackgroundResource(R.color.colorFail);
            }
        }
        return 1;
    }
    private void omplirPartits() {
        int iComptadorSignesInformats = 0;
        int iComptadorSignesSeleccionats = 0;
        int ind = 0;
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        m_quinielaBloquetjada = EstatQuiniela.PDT;
        quiniela.setEstatQuiniela(m_quinielaBloquetjada);
        // Linia 1
        m_tvCol12.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol13, ind);
        m_tvCol14.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol15, m_tvCol16, m_tvCol17);
        iComptadorSignesInformats += formatSigne(m_tvCol18, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 2
        ind++;
        m_tvCol22.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol23, ind);
        m_tvCol24.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol25, m_tvCol26, m_tvCol27);
        iComptadorSignesInformats += formatSigne(m_tvCol28, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 3
        ind++;
        m_tvCol32.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol33, ind);
        m_tvCol34.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol35, m_tvCol36, m_tvCol37);
        iComptadorSignesInformats += formatSigne(m_tvCol38, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 4
        ind++;
        m_tvCol42.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol43, ind);
        m_tvCol44.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol45, m_tvCol46, m_tvCol47);
        iComptadorSignesInformats += formatSigne(m_tvCol48, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 5
        ind++;
        m_tvCol52.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol53, ind);
        m_tvCol54.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol55, m_tvCol56, m_tvCol57);
        iComptadorSignesInformats += formatSigne(m_tvCol58, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 6
        ind++;
        m_tvCol62.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol63, ind);
        m_tvCol64.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol65, m_tvCol66, m_tvCol67);
        iComptadorSignesInformats += formatSigne(m_tvCol68, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 7
        ind++;
        m_tvCol72.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol73, ind);
        m_tvCol74.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol75, m_tvCol76, m_tvCol77);
        iComptadorSignesInformats += formatSigne(m_tvCol78, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 8
        ind++;
        m_tvCol82.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol83, ind);
        m_tvCol84.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol85, m_tvCol86, m_tvCol87);
        iComptadorSignesInformats += formatSigne(m_tvCol88, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 9
        ind++;
        m_tvCol92.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol93, ind);
        m_tvCol94.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol95, m_tvCol96, m_tvCol97);
        iComptadorSignesInformats += formatSigne(m_tvCol98, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 10
        ind++;
        m_tvCol102.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol103, ind);
        m_tvCol104.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol105, m_tvCol106, m_tvCol107);
        iComptadorSignesInformats += formatSigne(m_tvCol108, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 11
        ind++;
        m_tvCol112.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol113, ind);
        m_tvCol114.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol115, m_tvCol116, m_tvCol117);
        iComptadorSignesInformats += formatSigne(m_tvCol118, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 12
        ind++;
        m_tvCol122.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol123, ind);
        m_tvCol124.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol125, m_tvCol126, m_tvCol127);
        iComptadorSignesInformats += formatSigne(m_tvCol128, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 13
        ind++;
        m_tvCol132.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol133, ind);
        m_tvCol134.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol135, m_tvCol136, m_tvCol137);
        iComptadorSignesInformats += formatSigne(m_tvCol138, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 14
        ind++;
        m_tvCol142.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol143, ind);
        m_tvCol144.setText(Utils.parsearText(quiniela.getNomsEquipsVisitant()[ind]));
        iComptadorSignesSeleccionats += omplirSignesUsuari(ind, m_tvCol145, m_tvCol146, m_tvCol147);
        iComptadorSignesInformats += formatSigne(m_tvCol148, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 15a
        ind++;
        m_tvCol15a2.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));
        omplirMarcadorPartit(m_tvCol15a3, ind);
        iComptadorSignesSeleccionats += omplirSignesUsuariPle15(ind, m_tvCol15a5a, m_tvCol15a5b, m_tvCol15a6, m_tvCol15a7);
        iComptadorSignesInformats += formatSigne(m_tvCol15a8, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Linia 15b
        ind++;
        m_tvCol15b2.setText(Utils.parsearText(quiniela.getNomsEquipsLocal()[ind]));  // És el visitant del Ple al 15
        omplirMarcadorPartit(m_tvCol15b3, ind);
        iComptadorSignesSeleccionats += omplirSignesUsuariPle15(ind, m_tvCol15b5a, m_tvCol15b5b, m_tvCol15b6, m_tvCol15b7);
        iComptadorSignesInformats += formatSigne(m_tvCol15b8, quiniela.getSignesPartit(),
                quiniela.getSignesPartitUsuari(), ind);
        // Quiniela Finalitzada?
        if (iComptadorSignesInformats > 15) {
            m_quinielaBloquetjada = EstatQuiniela.FINALITZADA;
            quiniela.setEstatQuiniela(m_quinielaBloquetjada);
        }
    }

    private void omplirMarcadorPartit(TextView p_tvMarcador, int p_ind) {
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        p_tvMarcador.setText(quiniela.getMarcadors()[p_ind]);
        if (quiniela.getEnJocs()[p_ind].equals(Constants.CTE_ESTA_EN_JOC)) {
            p_tvMarcador.setBackgroundResource(R.color.colorPendent);
            //
            m_quinielaBloquetjada = EstatQuiniela.ENJOC;
            quiniela.setEstatQuiniela(m_quinielaBloquetjada);
        }
        else
            p_tvMarcador.setBackgroundResource(R.color.fons_blau5);
    }

    private int omplirSignesUsuariPle15(int p_ind, TextView p_tvCol0, TextView p_tvCol1, TextView p_tvCol2, TextView p_tvColM) {
        int iComptadorSel = 0;
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        // Signe 0
        if (quiniela.getSignesPartitUsuari() != null &&
                quiniela.getSignesPartitUsuari()[p_ind].contains("0")) {
            //  Valor seleccionat - BLAU
            p_tvCol0.setBackgroundResource(R.color.fons_blau2);
            p_tvCol0.setTextColor(m_activity.getColor(R.color.white));
            iComptadorSel = 1;
        }
        else {
            // Valor deseleccionat - GRIS
            p_tvCol0.setBackgroundResource(R.color.fons_blau5);
            p_tvCol0.setTextColor(m_activity.getColor(R.color.black));
        }
        // Signe 1
        if (quiniela.getSignesPartitUsuari() != null &&
                quiniela.getSignesPartitUsuari()[p_ind].contains("1")) {
            //  Valor seleccionat - BLAU
            p_tvCol1.setBackgroundResource(R.color.fons_blau2);
            p_tvCol1.setTextColor(m_activity.getColor(R.color.white));
            iComptadorSel = 1;
        }
        else {
            // Valor deseleccionat - GRIS
            p_tvCol1.setBackgroundResource(R.color.fons_blau5);
            p_tvCol1.setTextColor(m_activity.getColor(R.color.black));
        }
        // Signe 2
        if (quiniela.getSignesPartitUsuari() != null &&
                quiniela.getSignesPartitUsuari()[p_ind].contains("2")) {
            //  Valor seleccionat - BLAU
            p_tvCol2.setBackgroundResource(R.color.fons_blau2);
            p_tvCol2.setTextColor(m_activity.getColor(R.color.white));
            iComptadorSel = 1;
        }
        else {
            // Valor deseleccionat - GRIS
            p_tvCol2.setBackgroundResource(R.color.fons_blau5);
            p_tvCol2.setTextColor(m_activity.getColor(R.color.black));
        }
        // Signe M
        if (quiniela.getSignesPartitUsuari() != null &&
                quiniela.getSignesPartitUsuari()[p_ind].contains("M")) {
            //  Valor seleccionat - BLAU
            p_tvColM.setBackgroundResource(R.color.fons_blau2);
            p_tvColM.setTextColor(m_activity.getColor(R.color.white));
            iComptadorSel = 1;
        }
        else {
            // Valor deseleccionat - GRIS
            p_tvColM.setBackgroundResource(R.color.fons_blau5);
            p_tvColM.setTextColor(m_activity.getColor(R.color.black));
        }
        return iComptadorSel;
    }
    private int omplirSignesUsuari(int p_ind, TextView p_tvCol1, TextView p_tvColX, TextView p_tvCol2) {
        int iComptadorSel = 0;
        String[] signesPartitAux = {
                "","","","","","","","",
                "","","","","","","",""};
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        String[] signesPartit = quiniela.getSignesPartitUsuari();
        if (signesPartit == null) {
            signesPartit = signesPartitAux;
        }
        // Signe 1
        if (signesPartit[p_ind].contains("1")) {
            //  Valor seleccionat - BLAU
            p_tvCol1.setBackgroundResource(R.color.fons_blau2);
            p_tvCol1.setTextColor(m_activity.getColor(R.color.white));
            iComptadorSel = 1;
        }
        else {
            // Valor deseleccionat - GRIS
            p_tvCol1.setBackgroundResource(R.color.fons_blau5);
            p_tvCol1.setTextColor(m_activity.getColor(R.color.black));
        }
        // Signe X
        if (signesPartit[p_ind].contains("X")) {
            //  Valor seleccionat - BLAU
            p_tvColX.setBackgroundResource(R.color.fons_blau2);
            p_tvColX.setTextColor(m_activity.getColor(R.color.white));
            iComptadorSel = 1;
        }
        else {
            // Valor deseleccionat - GRIS
            p_tvColX.setBackgroundResource(R.color.fons_blau5);
            p_tvColX.setTextColor(m_activity.getColor(R.color.black));
        }
        // Signe 2
        if (signesPartit[p_ind].contains("2")) {
            //  Valor seleccionat - BLAU
            p_tvCol2.setBackgroundResource(R.color.fons_blau2);
            p_tvCol2.setTextColor(m_activity.getColor(R.color.white));
            iComptadorSel = 1;
        }
        else {
            // Valor deseleccionat - GRIS
            p_tvCol2.setBackgroundResource(R.color.fons_blau5);
            p_tvCol2.setTextColor(m_activity.getColor(R.color.black));
        }
        return iComptadorSel;
    }

    private void omplirJornadaNom() {
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        if (quiniela.getDataJornada() != null) {
            m_fabJornadaActual.setText(
                    m_activity.getString(R.string.text_jornada_titol) + " " +
                            quiniela.getNumJornada() + " - " +
                            Utils.data2String(quiniela.getDataJornada()).replaceAll("00:00", "")
            );
        }
        else {
            m_fabJornadaActual.setText(
                    m_activity.getString(R.string.text_jornada_titol) + " " +
                            quiniela.getNumJornada()
            );
        }
        m_tvNomUsuari.setText(m_usuari.getNickname());
    }

    private static int getBackgroundColor(TextView textView) {
        Drawable drawable = textView.getBackground();
        if (drawable instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) drawable;
            if (Build.VERSION.SDK_INT >= 11) {
                return colorDrawable.getColor();
            }
            try {
                Field field = colorDrawable.getClass().getDeclaredField("mState");
                field.setAccessible(true);
                Object object = field.get(colorDrawable);
                field = object.getClass().getDeclaredField("mUseColor");
                field.setAccessible(true);
                return field.getInt(object);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private int comptarEncerts() {
        int iEncerts = 0;
        if (getBackgroundColor(m_tvCol18) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol28) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol38) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol48) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol58) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol68) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol78) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol88) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol98) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol108) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol118) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol128) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol138) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol148) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        if (getBackgroundColor(m_tvCol15a8) == m_activity.getColor(R.color.colorEncert) &&
                getBackgroundColor(m_tvCol15b8) == m_activity.getColor(R.color.colorEncert))
            iEncerts++;
        return iEncerts;
    }

    private void omplirPremis() {
        //
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        // Comptar els encerts
        int iEncerts = comptarEncerts();
        quiniela.setNumEncerts(iEncerts);
        m_tvSaldoCol72.setText("" + iEncerts);
        // Total Premis Quinielas
        GestorApostes.calcularPremisUsuariQuiniela(m_usuari, quiniela);
        m_tvSaldoCol92.setText(
                Utils.formatMoneda(quiniela.getPremiQuiniela()));
        // TODO: Fer el càlcul total, sumatori de tots els premis de quinielas
        GestorApostes.sumarPremisQuinielas(m_usuari);
        m_tvSubCapcalera2a.setText(Utils.formatMoneda(m_usuari.getSaldoPremisQuinielas()));
        // Total Premis Especial per encerts
        GestorApostes.calcularPremisUsuariPerEncerts(quiniela);
        m_tvSaldoCol82.setText(
                Utils.formatMoneda(quiniela.getPremiPerEncerts()));
        // TODO: Fer el càlcul total, sumatori de tots els premis per encerts
        double dbSaldoInicial = Double.parseDouble(m_activity.getString(R.string.saldo_inicial_quantitat));
        GestorApostes.sumarSaldoPremisPerEncerts(m_usuari, dbSaldoInicial);
        m_tvSubCapcalera2.setText(Utils.formatMoneda(m_usuari.getSaldo()));
        //  Percentatges
        m_tvSubCapcaleraPerc.setText(Utils.formatPercentatge(GestorApostes.calcularPercentatgeEncerts(m_usuari)));
        // Bote
        m_tvBote.setText(
                m_activity.getString(R.string.premi_bote) +
                Utils.formatMoneda(quiniela.getBote()));
    }

    private TextView inicialitzarLinia1X2(int p_tv1X2) {
        final TextView tv = (TextView)m_activity.findViewById(p_tv1X2);
        tv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (!m_quinielaBloquetjada.equals(EstatQuiniela.ENJOC) &&
                        !m_quinielaBloquetjada.equals(EstatQuiniela.BLOQ) &&
                        !m_quinielaBloquetjada.equals(EstatQuiniela.FINALITZADA)) {
                    // Només es permet canviar pronóstics si no està bloquetjada
                    Utils.vibrar(m_vibr, Constants.CTE_VIBRATION_MS);
                    if (!validarCheck1X2Ple15(tv)) {
                        // Al ple al 15 només pot haver-hi un check
                        if (tv.getCurrentTextColor() != m_activity.getColor(R.color.white)) {
                            //  Valor seleccionat - BLAU
                            tv.setBackgroundResource(R.color.fons_blau2);
                            tv.setTextColor(m_activity.getColor(R.color.white));
                        } else {
                            // Valor deseleccionat - GRIS
                            tv.setBackgroundResource(R.color.fons_blau5);
                            tv.setTextColor(m_activity.getColor(R.color.black));
                        }
                    }
                    // Actualizar pronóstics
                    actualitzarPronosticsApostes();
                    // Omplir Saldo d'apostes
                    omplirSaldoApostes();
                    // Omplir estat
                    omplirEstatQuiniela();
                    // Guardar usuari
                    guardarDadesUsuari();
                }
            }
        });
        return tv;
    }

    private void guardarDadesUsuari() {
        Utils.guardarInfoSP(m_spDades, m_usuari);
        //
        if (m_quinielaBloquetjada == EstatQuiniela.PDT) {
            // Guardar usuari en cloud quan esta complerta la quiniela per l'usuari
            // i està pendent. Les bloquejades i finalitzades no fa res.
            m_activity.guardarDadesUsuariCloud(m_usuari.getNickname());
        }
    }

    private void omplirSaldoApostes() {
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        String[] signesPartit = quiniela.getSignesPartitUsuari();
        int[] apostes = calcularApostes(signesPartit);
        //  Aposta simple
        m_tvSaldoCol32.setText("" + apostes[0]);
        // Aposta doble
        m_tvSaldoCol42.setText("" + apostes[1]);
        // Aposta triple
        m_tvSaldoCol52.setText("" + apostes[2]);
        //  Suma d'apostes
        String[] apostesString = quiniela.getSignesPartitUsuari();
        double saldoApostes = GestorApostes.calcularSaldoApostat(apostesString);
        quiniela.setCosteQuiniela(saldoApostes);
        m_tvSaldoCol22.setText(Utils.formatMoneda(saldoApostes));
    }

    private int[] calcularApostes(String[] signesPartit) {
        int[] iApostes = new int[]{0,0,0};
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        if (signesPartit == null)
            return iApostes;
        for(String pronos : signesPartit) {
            if (pronos.length() == 1)
                iApostes[0]++;
            else if (pronos.length() == 2)
                iApostes[1]++;
            else if (pronos.length() == 3)
                iApostes[2]++;
        }
        // recalcular Ple al 15
        if (!signesPartit[14].equals("") || !signesPartit[15].equals(""))
            // Només suma 1 si tots dos estan informats
            if (iApostes[0] > 0)
                iApostes[0] = iApostes[0] - 1;
        // canviar l'estat
        if (iApostes[0] + iApostes[1] + iApostes[2] < 15 &&
                !m_quinielaBloquetjada.equals(EstatQuiniela.FINALITZADA) &&
                !m_quinielaBloquetjada.equals(EstatQuiniela.BLOQ)) {
            // No s'han omplert tots els signes
            m_quinielaBloquetjada = EstatQuiniela.NOCOMP;
            quiniela.setEstatQuiniela(m_quinielaBloquetjada);
        }
        else if (iApostes[0] + iApostes[1] + iApostes[2] >= 15 &&
                m_quinielaBloquetjada.equals(EstatQuiniela.NOCOMP)) {
            // s'han omplert tots els signes
            m_quinielaBloquetjada = EstatQuiniela.PDT;
            quiniela.setEstatQuiniela(m_quinielaBloquetjada);
        }
        return iApostes;
    }

    private boolean validarCheck1X2Ple15(TextView p_tv1X2) {
        boolean bEsPle15 = false;
        // Primera linia del Ple al 15
        if (m_tvCol15a5a.getId() == p_tv1X2.getId() ||
                m_tvCol15a5b.getId() == p_tv1X2.getId() ||
                m_tvCol15a6.getId() == p_tv1X2.getId() ||
                m_tvCol15a7.getId() == p_tv1X2.getId()) {
            //
            bEsPle15 = true;
            // Valor deseleccionat - GRIS
            boolean bCanvi = (p_tv1X2.getCurrentTextColor() != m_activity.getColor(R.color.white));
            m_tvCol15a5a.setBackgroundResource(R.color.fons_blau5);
            m_tvCol15a5a.setTextColor(m_activity.getColor(R.color.black));
            m_tvCol15a5b.setBackgroundResource(R.color.fons_blau5);
            m_tvCol15a5b.setTextColor(m_activity.getColor(R.color.black));
            m_tvCol15a6.setBackgroundResource(R.color.fons_blau5);
            m_tvCol15a6.setTextColor(m_activity.getColor(R.color.black));
            m_tvCol15a7.setBackgroundResource(R.color.fons_blau5);
            m_tvCol15a7.setTextColor(m_activity.getColor(R.color.black));
            if (bCanvi) {
                // Valor seleccionat - BLAU
                p_tv1X2.setBackgroundResource(R.color.fons_blau2);
                p_tv1X2.setTextColor(m_activity.getColor(R.color.white));
            }
        }
        // Segona linia del Ple al 15
        else if (m_tvCol15b5a.getId() == p_tv1X2.getId() ||
                    m_tvCol15b5b.getId() == p_tv1X2.getId() ||
                    m_tvCol15b6.getId() == p_tv1X2.getId() ||
                    m_tvCol15b7.getId() == p_tv1X2.getId()) {
                //
                bEsPle15 = true;
                // Valor deseleccionat - GRIS
                boolean bCanvi = (p_tv1X2.getCurrentTextColor() != m_activity.getColor(R.color.white));
                m_tvCol15b5a.setBackgroundResource(R.color.fons_blau5);
                m_tvCol15b5a.setTextColor(m_activity.getColor(R.color.black));
                m_tvCol15b5b.setBackgroundResource(R.color.fons_blau5);
                m_tvCol15b5b.setTextColor(m_activity.getColor(R.color.black));
                m_tvCol15b6.setBackgroundResource(R.color.fons_blau5);
                m_tvCol15b6.setTextColor(m_activity.getColor(R.color.black));
                m_tvCol15b7.setBackgroundResource(R.color.fons_blau5);
                m_tvCol15b7.setTextColor(m_activity.getColor(R.color.black));
            if (bCanvi) {
                // Valor seleccionat - BLAU
                p_tv1X2.setBackgroundResource(R.color.fons_blau2);
                p_tv1X2.setTextColor(m_activity.getColor(R.color.white));
                }
            }
        return bEsPle15;
    }
    public void actualitzarPronosticsApostes() {
        actualitzarSignes(0, m_tvCol15, m_tvCol16, m_tvCol17);
        actualitzarSignes(1, m_tvCol25, m_tvCol26, m_tvCol27);
        actualitzarSignes(2, m_tvCol35, m_tvCol36, m_tvCol37);
        actualitzarSignes(3, m_tvCol45, m_tvCol46, m_tvCol47);
        actualitzarSignes(4, m_tvCol55, m_tvCol56, m_tvCol57);
        actualitzarSignes(5, m_tvCol65, m_tvCol66, m_tvCol67);
        actualitzarSignes(6, m_tvCol75, m_tvCol76, m_tvCol77);
        actualitzarSignes(7, m_tvCol85, m_tvCol86, m_tvCol87);
        actualitzarSignes(8, m_tvCol95, m_tvCol96, m_tvCol97);
        actualitzarSignes(9, m_tvCol105, m_tvCol106, m_tvCol107);
        actualitzarSignes(10, m_tvCol115, m_tvCol116, m_tvCol117);
        actualitzarSignes(11, m_tvCol125, m_tvCol126, m_tvCol127);
        actualitzarSignes(12, m_tvCol135, m_tvCol136, m_tvCol137);
        actualitzarSignes(13, m_tvCol145, m_tvCol146, m_tvCol147);
        actualitzarSignesPle15(14, m_tvCol15a5a, m_tvCol15a5b, m_tvCol15a6, m_tvCol15a7);
        actualitzarSignesPle15(15, m_tvCol15b5a, m_tvCol15b5b, m_tvCol15b6, m_tvCol15b7);
    }

    private void actualitzarSignesPle15(int p_iNumLinia, TextView p_idTv0, TextView p_idTv1, TextView p_idTv2, TextView p_idTvM) {
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        String[] signesPartit = quiniela.getSignesPartitUsuari();
        signesPartit[p_iNumLinia] = "";
        if (p_idTv0.getCurrentTextColor() == m_activity.getColor(R.color.white)) {
            // Està seleccionat el 1 de la linia?
            signesPartit[p_iNumLinia] = "0";
        }
        else if (p_idTv1.getCurrentTextColor() == m_activity.getColor(R.color.white)) {
            // Està seleccionat el 1 de la linia?
            signesPartit[p_iNumLinia] = "1";
        }
        else if (p_idTv2.getCurrentTextColor() == m_activity.getColor(R.color.white)) {
            // Està seleccionat el 1 de la linia?
            signesPartit[p_iNumLinia] = "2";
        }
        else if (p_idTvM.getCurrentTextColor() == m_activity.getColor(R.color.white)) {
            // Està seleccionat el 1 de la linia?
            signesPartit[p_iNumLinia] = "M";
        }
        //
        quiniela.setSignesPartitUsuari(signesPartit);
        m_usuari.getQuinielasUsuari().set(quiniela.getNumJornada(), quiniela);
    }

    private void actualitzarSignes(int p_iNumLinia, TextView p_idTv1, TextView p_idTvX, TextView p_idTv2) {
        String[] signesPartitAux = {
                "","","","","","","","",
                "","","","","","","",""};
        Quiniela quiniela = m_usuari.getQuinielasUsuari().get(m_activity.getNumJornadaEnCurs());
        String[] signesPartit = quiniela.getSignesPartitUsuari();
        if (signesPartit == null) {
            signesPartit = signesPartitAux;
        }
        signesPartit[p_iNumLinia] = "";
        if (p_idTv1.getCurrentTextColor() == m_activity.getColor(R.color.white)) {
            // Està seleccionat el 1 de la linia?
            signesPartit[p_iNumLinia] += "1";
        }
        if (p_idTvX.getCurrentTextColor() == m_activity.getColor(R.color.white)) {
            // Està seleccionat el 1 de la linia?
            signesPartit[p_iNumLinia] += "X";
        }
        if (p_idTv2.getCurrentTextColor() == m_activity.getColor(R.color.white)) {
            // Està seleccionat el 1 de la linia?
            signesPartit[p_iNumLinia] += "2";
        }
        //
        quiniela.setSignesPartitUsuari(signesPartit);
        m_usuari.getQuinielasUsuari().set(quiniela.getNumJornada(), quiniela);
    }
    @SuppressLint("ClickableViewAccessibility")
    private void desplacamentQuiniela() {
        final LinearLayout llPrincipal = (LinearLayout)m_activity.findViewById(R.id.ll1);
        llPrincipal.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch(event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        //Log.d("desplacamentQuiniela", "Action is DragEvent.ACTION_DRAG_STARTED");
                        // Do nothing
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        //Log.d("desplacamentQuiniela", "Action is DragEvent.ACTION_DRAG_ENTERED");
                        x_cord_ini = 0;
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        //Log.d("desplacamentQuiniela", "Action is DragEvent.ACTION_DRAG_EXITED");
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        //Log.d("desplacamentQuiniela", "Action is DragEvent.ACTION_DRAG_LOCATION");
                        if (x_cord_ini == 0)
                            x_cord_ini = (int) event.getX();
                        x_cord_fin = (int) event.getX();
                        //Log.d("desplacamentQuiniela-ACTION_DRAG_LOCATION", "X: " + x_cord_fin + " - Y: " + y_cord_fin);
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        //Log.d("desplacamentQuiniela", "Action is DragEvent.ACTION_DRAG_ENDED");
                        int numJornada = 0;
                        if (x_cord_fin > x_cord_ini + Constants.CTE_MIN_DESP_CANVI_DRAG_DROP) {
                            // Desplaçament a la dreta
                            numJornada = m_activity.getNumJornadaEnCurs() - 1;
                            //
                            if (numJornada > 0)
                                actualizarDadesUsuari(numJornada);
                            //System.out.println("Dreta: " + x_cord_fin + " - " + (x_cord_ini + Constants.CTE_MIN_DESP_CANVI_DRAG_DROP));
                        }
                        else if (x_cord_fin < x_cord_ini - Constants.CTE_MIN_DESP_CANVI_DRAG_DROP) {
                            // Desplaçament a l'esquerra
                            numJornada = m_activity.getNumJornadaEnCurs() + 1;
                            //
                            actualizarDadesUsuari(numJornada);
                            //System.out.println("Dreta: " + x_cord_fin + " - " + (x_cord_ini - Constants.CTE_MIN_DESP_CANVI_DRAG_DROP));
                        }
                        break;

                    case DragEvent.ACTION_DROP:
                        //Log.d("desplacamentQuiniela", "ACTION_DROP event");
                        // Do nothing
                        break;
                    default: break;
                }
                return true;
            }
        });
        llPrincipal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, null, 0);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
    private void actualizarDadesUsuari(int p_numJornada) {
        //  Llegir quiniela actual Web
        recuperarQuinielaJornadaMem(p_numJornada);
        omplirDades();
    }
}
