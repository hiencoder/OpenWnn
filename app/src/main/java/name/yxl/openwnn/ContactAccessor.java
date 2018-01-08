package name.yxl.openwnn;

import android.content.ContentResolver;
import android.os.Build.VERSION;
import java.util.ArrayList;

public abstract class ContactAccessor {
    private static ContactAccessor sInstance;

    public abstract void getContacts(ContentResolver contentResolver, ArrayList<WnnWord> arrayList, String str, ArrayList<String> arrayList2);

    public static ContactAccessor getInstance() {
        if (sInstance == null) {
            String className;
            if (Integer.parseInt(VERSION.SDK) < 5) {
                className = "name.yxl.openwnn.ContactAccessorSdk3_4";
            } else {
                className = "name.yxl.openwnn.ContactAccessorSdk5";
            }
            try {
                sInstance = (ContactAccessor) Class.forName(className).asSubclass(ContactAccessor.class).newInstance();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return sInstance;
    }
}
