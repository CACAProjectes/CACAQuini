package es.xuan.cacaquini.files;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import es.xuan.cacaquini.model.EscrutiniBD;
import es.xuan.cacaquini.varis.Constants;
import es.xuan.cacaquini.varis.Utils;

public class FilesCloud implements Serializable {
    private static final long serialVersionUID = 1L;

    private static String m_contingutFileDownload = "";

    public static String getContingutFileDownload() {
        return m_contingutFileDownload;
    }

    public static void listAllFiles(String p_strCarpeta) {
        // p_strCarpeta = "CCC-CACAQuini"
        FirebaseStorage storage = FirebaseStorage.getInstance();
        // [START storage_list_all]
        StorageReference listRef = storage.getReference().child(p_strCarpeta);
        //
        listRef.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference prefix : listResult.getPrefixes()) {
                            // All the prefixes under listRef.
                            // You may call listAll() recursively on them.
                            System.out.println(prefix);
                        }

                        for (StorageReference item : listResult.getItems()) {
                            // All the items under listRef.
                            System.out.println(item);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.err.println(e);
                    }
                });
        // [END storage_list_all]
    }

    public static void uploadFile(String p_strFitxer, byte[] p_bytes) throws IOException {
        // p_strFitxer = "CCC-CACAQuini/prova.txt"
        FirebaseStorage storage = FirebaseStorage.getInstance();
        // [START storage_list_all]
        StorageReference mountainsRef = storage.getReference().child(p_strFitxer);
        //byte[] bytes = new byte[]{'H', 'o','l', 'a',' ', '!','!', '!'};
        UploadTask uploadTask = mountainsRef.putBytes(p_bytes);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                System.err.println(exception);
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
            }
        });
        // [END upload_memory]
    }

    public static void downloadFile(String p_strFitxer) throws IOException {
        //
        FirebaseStorage storage = FirebaseStorage.getInstance();
        // [START storage_list_all]
        StorageReference storageRef = storage.getReference().child(p_strFitxer);
        // [START download_full_example]
        long ONE_MEGABYTE = 1024 * 1024;
        storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Use the bytes to display the image
                m_contingutFileDownload = new String(bytes, StandardCharsets.UTF_8);
                //System.out.println("Tamany del fitxer " + p_strFitxer + ": " + m_contingutFileDownload.length());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                System.err.println(exception);
            }
        });
        // [END download_full_example]
    }
    public static ArrayList<EscrutiniBD> convertString2Escrutinis(String p_strContingut) {
        //  JORNADA
        //  JORNADA	DATA
        //  RECAUDACIO
        //  IMPOSTOS
        //  PREMIS
        //  PLE_15_ENCERT
        //  PLE_15_PREMI
        //  C14_ENCERT
        //  C14_PREMI
        //  C13_ENCERT
        //  C13_PREMI
        //  C12_ENCERT
        //  C12_PREMI
        //  C11_ENCERT
        //  C11_PREMI
        //  C10_ENCERT
        //  C10_PREMI
        ArrayList<EscrutiniBD> escrutinis = new ArrayList<>();
        //
        if (p_strContingut!=null && p_strContingut.equals(""))
            return escrutinis;
        //
        int iComptador = 0;
        String[] linies = p_strContingut.split(System.lineSeparator());
        for (String linia : linies) {
            EscrutiniBD escrutini = new EscrutiniBD();
            // Saltar la primera linia
            if (iComptador++ > 0) {
                //  Parsear els camps
                String[] values = linia.split(Constants.CTE_SEPARADOR_TEXT);
                int ind = 0;
                //  JORNADA
                escrutini.setJORNADA(Utils.string2Integer(values[ind]));
                //  DATA
                ind++;
                escrutini.setDATA(Utils.string2Data(values[ind]));
                //  RECAUDACIO
                ind++;
                escrutini.setRECAUDACIO(Utils.string2Double(values[ind]));
                //  IMPOSTOS
                ind++;
                escrutini.setIMPOSTOS(Utils.string2Double(values[ind]));
                //  PREMIS
                ind++;
                escrutini.setPREMIS(Utils.string2Double(values[ind]));
                //  PLE_15_ENCERT
                ind++;
                escrutini.setPLE_15_ENCERT(Utils.string2Integer(values[ind]));
                //  PLE_15_PREMI
                ind++;
                escrutini.setPLE_15_PREMI(Utils.string2Double(values[ind]));
                //  C14_ENCERT
                ind++;
                escrutini.setC14_ENCERT(Utils.string2Integer(values[ind]));
                //  C14_PREMI
                ind++;
                escrutini.setC14_PREMI(Utils.string2Double(values[ind]));
                //  C13_ENCERT
                ind++;
                escrutini.setC13_ENCERT(Utils.string2Integer(values[ind]));
                //  C13_PREMI
                ind++;
                escrutini.setC13_PREMI(Utils.string2Double(values[ind]));
                //  C12_ENCERT
                ind++;
                escrutini.setC12_ENCERT(Utils.string2Integer(values[ind]));
                //  C12_PREMI
                ind++;
                escrutini.setC12_PREMI(Utils.string2Double(values[ind]));
                //  C11_ENCERT
                ind++;
                escrutini.setC11_ENCERT(Utils.string2Integer(values[ind]));
                //  C11_PREMI
                ind++;
                escrutini.setC11_PREMI(Utils.string2Double(values[ind]));
                //  C10_ENCERT
                ind++;
                escrutini.setC10_ENCERT(Utils.string2Integer(values[ind]));
                //  C10_PREMI
                ind++;
                escrutini.setC10_PREMI(Utils.string2Double(values[ind]));
            }
            escrutinis.add(escrutini);
        }
        return escrutinis;
    }

}
