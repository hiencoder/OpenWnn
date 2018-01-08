package name.yxl.openwnn;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.Contacts.ContactMethods;
import android.provider.Contacts.People;
import android.provider.Contacts.Phones;
import java.util.ArrayList;
import java.util.Iterator;

public class ContactAccessorSdk3_4 extends ContactAccessor {
    public void getContacts(ContentResolver contentResolver, ArrayList<WnnWord> convResult, String keyword, ArrayList<String> list) {
        String[] projection = new String[]{"_id", "name", "number", "primary_phone", "primary_email"};
        if (contentResolver != null) {
            String selection = "name" + keyword;
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                selection = new StringBuilder(String.valueOf(selection)).append("  OR phonetic_name").append((String) it.next()).toString();
            }
            ContentResolver contentResolver2 = contentResolver;
            Cursor cur = contentResolver2.query(People.CONTENT_URI, projection, selection, null, "name");
            if (cur != null && cur.moveToFirst()) {
                int nameIndex = cur.getColumnIndex("name");
                int phoneIndex = cur.getColumnIndex("number");
                int emailIndex = cur.getColumnIndex("primary_email");
                do {
                    String name = cur.getString(nameIndex);
                    if (name != null && name.length() > 0) {
                        convResult.add(new WnnWord(name, ""));
                    }
                    if (name == null) {
                        name = "";
                    }
                    String phone = cur.getString(phoneIndex);
                    if (phone != null && phone.length() > 0) {
                        convResult.add(new WnnWord(phone, ""));
                    }
                    getData(contentResolver, convResult, cur.getInt(emailIndex), name);
                } while (cur.moveToNext());
                convResult.add(new WnnWord(".n.n.n.", ".n.n.n."));
            }
        }
    }

    private void getPhone(ContentResolver contentResolver, ArrayList<WnnWord> convResult, int id) {
        String[] projection = new String[]{"number", "type"};
        String selection = "person=" + id;
        Cursor cur = contentResolver.query(Phones.CONTENT_URI, projection, selection, null, null);
        if (cur != null && cur.moveToFirst()) {
            int colIndex = cur.getColumnIndex("number");
            do {
                String number = cur.getString(colIndex);
                if (number != null && number.length() > 0) {
                    convResult.add(new WnnWord(number, ""));
                }
            } while (cur.moveToNext());
        }
    }

    private void getData(ContentResolver contentResolver, ArrayList<WnnWord> convResult, int id, String name) {
        String[] projection = new String[]{"data"};
        String selection = "contact_methods._id = " + id;
        Cursor cur = contentResolver.query(ContactMethods.CONTENT_URI, projection, selection, null, null);
        if (cur != null && cur.moveToFirst()) {
            int colIndex = cur.getColumnIndex("data");
            do {
                String email = cur.getString(colIndex);
                if (!(email == null || email.length() <= 0 || email.equalsIgnoreCase(name))) {
                    convResult.add(new WnnWord(email, ""));
                }
            } while (cur.moveToNext());
        }
    }
}
