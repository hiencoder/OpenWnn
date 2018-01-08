package name.yxl.openwnn;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MushroomListActivity extends Activity implements OnItemClickListener {
    private static AlertDialog mDlg = null;
    private String ACTION_INTERCEPT = "com.adamrocker.android.simeji.ACTION_INTERCEPT";
    private String REPLACE = "com.adamrocker.android.simeji.REPLACE";
    private String mGetString;
    private ArrayList<MyListBean> mList;

    class C00231 implements OnClickListener {
        C00231() {
        }

        public void onClick(DialogInterface dialog, int which) {
            Intent ret = new Intent("FROM_MUSHROOM");
            ret.putExtra("replace_key", "");
            MushroomListActivity.this.sendBroadcast(ret);
            MushroomListActivity.mDlg.dismiss();
            MushroomListActivity.mDlg = null;
            MushroomListActivity.this.finish();
        }
    }

    public class MyAdapter extends ArrayAdapter<MyListBean> {
        private LayoutInflater inflater_;
        private ArrayList<MyListBean> items_;

        public MyAdapter(Context context, LayoutInflater inflater, int textViewResourceId, ArrayList<MyListBean> items) {
            super(context, textViewResourceId, items);
            this.inflater_ = inflater;
            this.items_ = items;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = this.inflater_.inflate(R.layout.mushroom_list_item, null);
            }
            MyListBean item = (MyListBean) this.items_.get(position);
            if (item != null) {
                ((ImageView) convertView.findViewById(R.id.icon)).setImageDrawable(item.getIcon());
                ((TextView) convertView.findViewById(R.id.text1)).setText(item.getTitle());
            }
            return convertView;
        }
    }

    public class MyListBean {
        private Drawable iconId_;
        private ResolveInfo info_;
        private String title_;

        public Drawable getIcon() {
            return this.iconId_;
        }

        public void setIcon(Drawable iconId) {
            this.iconId_ = iconId;
        }

        public String getTitle() {
            return this.title_;
        }

        public void setTitle(String title) {
            this.title_ = title;
        }

        public void setInfo(ResolveInfo info) {
            this.info_ = info;
        }

        public ResolveInfo getInfo() {
            return this.info_;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        showDialog();
    }

    private void showDialog() {
        this.mGetString = getIntent().getStringExtra("replace_key");
        if (this.mGetString == null) {
            this.mGetString = "";
        }
        PackageManager pm = getPackageManager();
        Intent intent = new Intent(this.ACTION_INTERCEPT);
        intent.addCategory(this.REPLACE);
        this.mList = new ArrayList();
        List<ResolveInfo> rList = pm.queryIntentActivities(intent, 0);
        if (rList != null) {
            int N = rList.size();
            if (N > 0) {
                for (int i = 0; i < N; i++) {
                    ResolveInfo ri = (ResolveInfo) rList.get(i);
                    MyListBean item1 = new MyListBean();
                    item1.setIcon(ri.loadIcon(pm));
                    item1.setTitle(ri.loadLabel(pm).toString());
                    item1.setInfo(ri);
                    this.mList.add(item1);
                }
            }
        }
        MyAdapter adapter = new MyAdapter(this, getLayoutInflater(), 17367043, this.mList);
        ListView lv = new ListView(this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        mDlg = new Builder(this).setTitle(R.string.whichMushroomApplication).setPositiveButton("Cancel", new C00231()).setView(lv).create();
        mDlg.show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        ResolveInfo info = ((MyListBean) this.mList.get(position)).getInfo();
        Intent intent2 = new Intent(this.ACTION_INTERCEPT);
        intent2.addCategory(this.REPLACE);
        intent2.setClassName(info.activityInfo.applicationInfo.packageName, info.activityInfo.name);
        intent2.putExtra("replace_key", this.mGetString);
        startActivityForResult(intent2, 0);
        this.mList = null;
    }

    public void onActivityResult(int req, int result, Intent intent) {
        String str = "";
        if (req == 0 && result == -1) {
            str = intent.getStringExtra("replace_key");
        }
        Intent ret = new Intent("FROM_MUSHROOM");
        ret.putExtra("replace_key", str);
        sendBroadcast(ret);
        mDlg.dismiss();
        mDlg = null;
        finish();
    }
}
