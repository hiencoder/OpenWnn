package name.yxl.openwnn;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import java.util.ArrayList;
import java.util.Iterator;

public class ContactAccessorSdk5 extends ContactAccessor {
    public void getContacts(ContentResolver contentResolver, ArrayList<WnnWord> convResult, String keyword, ArrayList<String> list) {
        if (contentResolver != null) {
            String selection = "display_name" + keyword;
            Iterator<String> it = list.iterator();
            if (Integer.parseInt(VERSION.SDK) < 8) {
                while (it.hasNext()) {
                    selection = new StringBuilder(String.valueOf(selection)).append(" OR display_name").append((String) it.next()).toString();
                }
            } else {
                while (it.hasNext()) {
                    selection = new StringBuilder(String.valueOf(selection)).append(" OR phonetic_name ").append((String) it.next()).toString();
                }
            }
            ContentResolver contentResolver2 = contentResolver;
            Cursor cur = contentResolver2.query(Contacts.CONTENT_URI, null, selection, null, "display_name");
            if (cur != null && cur.moveToFirst()) {
                int idIndex = cur.getColumnIndex("_id");
                int nameIndex = cur.getColumnIndex("display_name");
                do {
                    String id = cur.getString(idIndex);
                    String name = cur.getString(nameIndex);
                    if (name != null && name.length() > 0) {
                        convResult.add(new WnnWord(name, ""));
                    }
                    if (name == null) {
                        name = "";
                    }
                    if (Integer.parseInt(cur.getString(cur.getColumnIndex("has_phone_number"))) > 0) {
                        getPhone(contentResolver, convResult, id);
                    }
                    getData(contentResolver, convResult, id, name);
                } while (cur.moveToNext());
                convResult.add(new WnnWord(".n.n.n.", ".n.n.n."));
            }
        }
    }

    private void getPhone(ContentResolver contentResolver, ArrayList<WnnWord> convResult, String id) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor cp = contentResolver2.query(Phone.CONTENT_URI, null, "contact_id = ?", new String[]{id}, null);
        while (cp.moveToNext()) {
            String dial1 = cp.getString(cp.getColumnIndex("data1"));
            if (dial1 != null && dial1.length() > 0) {
                convResult.add(new WnnWord(dial1, ""));
            }
        }
        cp.close();
    }

    private void getData(ContentResolver contentResolver, ArrayList<WnnWord> convResult, String id, String name) {
        ContentResolver contentResolver2 = contentResolver;
        Cursor cm = contentResolver2.query(Email.CONTENT_URI, null, "contact_id = ?", new String[]{id}, null);
        while (cm.moveToNext()) {
            String email = cm.getString(cm.getColumnIndex("data1"));
            if (!(email == null || email.length() <= 0 || email.equalsIgnoreCase(name))) {
                convResult.add(new WnnWord(email, ""));
            }
        }
        cm.close();
    }
}
