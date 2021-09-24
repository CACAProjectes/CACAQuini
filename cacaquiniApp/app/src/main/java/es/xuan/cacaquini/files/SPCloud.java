package es.xuan.cacaquini.files;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.IOException;
import java.io.Serializable;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Serializar;

public class SPCloud implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    //private DatabaseReference m_dRefUsuaris = null;
    private DatabaseReference m_dRefUsuari = null;
    //
    private String m_valUsuaris = "";
    private String m_valUsuari = "";

    public Object getValUsuaris() {
        try {
            if (m_valUsuaris!=null && !m_valUsuaris.equals(""))
                return Serializar.desSerializar(m_valUsuaris);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
    public void setValUsuaris(Object p_valUsuaris) {
        try {
            if (p_valUsuaris!=null)
                m_dRefUsuaris.setValue(Serializar.serializar(p_valUsuaris));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */

    public Object getValUsuari() {
        try {
            if (m_valUsuari!=null && !m_valUsuari.equals(""))
                return Serializar.desSerializar(m_valUsuari);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setValUsuari(Object p_valUsuari) {
        try {
            if (m_dRefUsuari!=null && p_valUsuari!=null)
                m_dRefUsuari.setValue(Serializar.serializar(p_valUsuari));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SPCloud(String p_strNickNameUsuari) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //m_dRefUsuaris = database.getReference(Constants.CTE_CLOUD_USUARIS);
        if (!p_strNickNameUsuari.equals(""))
            m_dRefUsuari = database.getReference(Constants.CTE_CLOUD_USUARI + p_strNickNameUsuari);
        //
        sincronitzarGetValues();
    }

    private void sincronitzarGetValues() {
        // [START read_message]
        /*
        // Llista d'usuaris
        m_dRefUsuaris.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                m_valUsuaris = dataSnapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.err.println(error);
            }
        });
         */
        // Usuari
        if (m_dRefUsuari != null) {
            m_dRefUsuari.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    m_valUsuari = dataSnapshot.getValue(String.class);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    System.err.println(error);
                }
            });
        }
        // [END read_message]
    }
}
