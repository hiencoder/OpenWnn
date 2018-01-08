package name.yxl.openwnn;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipInputStream;

public class Misc {
    private static boolean mIsCarrierChecked = false;
    private static boolean mIsCarrierSBM = false;

    public static void copyAssetFile(Context context, String srcFilePath) {
        OutputStream outputStream;
        String dst = "/data/data/com.pm9.flickwnn/naist_jdic/";
        new File(dst).mkdirs();
        File dstFile = new File(new StringBuilder(String.valueOf(dst)).append(srcFilePath).toString());
        try {
            InputStream input = context.getResources().getAssets().open(srcFilePath);
            OutputStream output = new FileOutputStream(dstFile);
            try {
                byte[] buffer = new byte[4096];
                while (true) {
                    int n = input.read(buffer);
                    if (-1 == n) {
                        input.close();
                        output.close();
                        outputStream = output;
                        return;
                    }
                    output.write(buffer, 0, n);
                }
            } catch (FileNotFoundException e) {
                outputStream = output;
                dstFile.delete();
            } catch (IOException e2) {
                outputStream = output;
                dstFile.delete();
            }
        } catch (FileNotFoundException e3) {
            dstFile.delete();
        } catch (IOException e4) {
            dstFile.delete();
        }
    }

    public static void copyAssetZipFile(Context context, String srcFilePath, int count) {
        String dst = "/data/data/com.pm9.flickwnn/naist_jdic/";
        new File(dst).mkdirs();
        File dstFile = new File(new StringBuilder(String.valueOf(dst)).append(srcFilePath).toString());
        AssetManager as = context.getResources().getAssets();
        OutputStream output = null;
        try {
            output = new FileOutputStream(dstFile);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        for (int i = 1; i <= count; i++) {
            try {
                InputStream input = as.open(new StringBuilder(String.valueOf(srcFilePath)).append(".").append(i).append(".zip").toString(), 2);
                ZipInputStream zis = new ZipInputStream(input);
                if (zis.getNextEntry() != null) {
                    byte[] buf = new byte[65536];
                    while (true) {
                        int size = zis.read(buf, 0, buf.length);
                        if (size <= -1) {
                            break;
                        }
                        output.write(buf, 0, size);
                    }
                    zis.closeEntry();
                }
                zis.close();
                input.close();
            } catch (FileNotFoundException e) {
                dstFile.delete();
            } catch (IOException e2) {
                dstFile.delete();
            }
        }
        try {
            output.close();
        } catch (IOException e3) {
            dstFile.delete();
        }
    }

    public static void setupNaistJDic(Context context) {
        InputStream input;
        InputStream input2 = null;
        AssetManager as = context.getResources().getAssets();
        String dst = "/data/data/com.pm9.flickwnn/naist_jdic/";
        boolean f_copy = false;
        if (new File(new StringBuilder(String.valueOf(dst)).append("jdic.version").toString()).exists()) {
            byte[] b1 = new byte[10];
            byte[] b2 = new byte[10];
            String b1s = "";
            String b2s = "";
            try {
                input2 = as.open("jdic.version");
                input2.read(b1);
                input2.close();
                b1s = new String(b1);
                input = input2;
            } catch (IOException e) {
                e.printStackTrace();
                input = input2;
            }
            try {
                input2 = new FileInputStream(new StringBuilder(String.valueOf(dst)).append("jdic.version").toString());
                try {
                    input2.read(b2);
                    input2.close();
                    b2s = new String(b2);
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                input2 = input;
            }
            if (!b1s.equals(b2s)) {
                f_copy = true;
            }
        } else {
            f_copy = true;
        }
        if (!new File(new StringBuilder(String.valueOf(dst)).append("jdic2.idx").toString()).exists()) {
            f_copy = true;
        }
        if (!new File(new StringBuilder(String.valueOf(dst)).append("jdic.dic").toString()).exists()) {
            f_copy = true;
        }
        if (f_copy) {
            Toast.makeText(context.getApplicationContext(), R.string.dialog_setup_naistjdic_start, 1).show();
            copyAssetFile(context, "COPYING");
            copyAssetZipFile(context, "jdic2.idx", 1);
            copyAssetZipFile(context, "jdic.dic", 2);
            copyAssetFile(context, "jdic.version");
            Toast.makeText(context.getApplicationContext(), R.string.dialog_setup_naistjdic_done, 1).show();
        }
    }

    public static boolean isCarrierSBM(Context context) {
        if (mIsCarrierChecked) {
            return mIsCarrierSBM;
        }
        mIsCarrierChecked = true;
        if (Build.DISPLAY.contains("oftbank") || Build.DISPLAY.contains("OFTBANK")) {
            mIsCarrierSBM = true;
            return true;
        }
        String simOpco = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getSimOperator();
        if (simOpco == null) {
            return false;
        }
        if (!"44020".equals(simOpco) && !"440020".equals(simOpco)) {
            return false;
        }
        mIsCarrierSBM = true;
        return true;
    }
}
