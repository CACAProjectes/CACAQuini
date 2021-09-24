package es.xuan.cacaquini.files;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import es.xuan.cacaquini.varis.Constants;

public class FilesDao implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(FilesDao.class.getName());

    public static void guardarQuiniela(String pStrPath, String pStrContenido) {
        try {
            File newFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + Constants.CTE_PATH_APP, pStrPath);
            newFile.getParentFile().mkdirs();
            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(newFile), "UTF-8"));
            out.write(pStrContenido);
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> llegirFitxerLinies(String pPatch) {
        // "/apps/competicio"
        Path pathFitxer = Paths.get(Environment.getExternalStorageDirectory().getAbsolutePath(), pPatch);
        ArrayList<String> linesStr = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        try {
            List lines = Files.readAllLines(pathFitxer, charset);
            for (Object line : lines) {
                linesStr.add(line.toString());
            }
        } catch (IOException e) {
            logger.severe("Error: " + e);
        }
        return linesStr;
    }

    public static boolean isReadStoragePermissionGranted(Activity pActivity) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (pActivity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("","Permission is granted1");
                return true;
            } else {
                Log.v("","Permission is revoked1 -> granted1");
                ActivityCompat.requestPermissions(pActivity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("","Permission is granted1");
            return true;
        }
    }

    public static boolean isWriteStoragePermissionGranted(Activity pActivity) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (pActivity.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("","Permission is granted2");
                return true;
            } else {

                Log.v("","Permission is revoked2 -> granted2");
                ActivityCompat.requestPermissions(pActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("","Permission is granted2");
            return true;
        }
    }
}
