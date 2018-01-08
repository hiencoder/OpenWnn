package name.yxl.openwnn;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class FlickWnnStartupPanel extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (OpenWnnJAJP.getInstance() == null) {
            OpenWnnJAJP openWnnJAJP = new OpenWnnJAJP(this);
        }
        Misc.setupNaistJDic(this);
        if (Misc.isCarrierSBM(this)) {
            addPreferencesFromResource(R.xml.openwnn_pref_sbm);
        } else {
            addPreferencesFromResource(R.xml.openwnn_pref_ja);
        }
        if (Integer.parseInt(VERSION.SDK) <= 10) {
            finish();
            Intent intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.LanguageSettings");
            startActivity(intent);
        }
    }
}
