package name.yxl.openwnn;

import name.yxl.openwnn.EN.OpenWnnEngineEN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import name.yxl.openwnn.EN.OpenWnnEngineEN;

public class EmojiDoCoMo {
    static final String EMOJI_FILE_NAME = "/data/data/com.pm9.flickwnn/emoji_list";
    public static char[] mEmojiCharList = new char[]{'', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''};
    public static int[] mEmojiRid = null;
    public static int[] mEmojiRidList = new int[]{R.drawable.imode_e63e, R.drawable.imode_e63f, R.drawable.imode_e640, R.drawable.imode_e641, R.drawable.imode_e642, R.drawable.imode_e643, R.drawable.imode_e644, R.drawable.imode_e645, R.drawable.imode_e646, R.drawable.imode_e647, R.drawable.imode_e648, R.drawable.imode_e649, R.drawable.imode_e64a, R.drawable.imode_e64b, R.drawable.imode_e64c, R.drawable.imode_e64d, R.drawable.imode_e64e, R.drawable.imode_e64f, R.drawable.imode_e650, R.drawable.imode_e651, R.drawable.imode_e652, R.drawable.imode_e653, R.drawable.imode_e654, R.drawable.imode_e655, R.drawable.imode_e656, R.drawable.imode_e657, R.drawable.imode_e658, R.drawable.imode_e659, R.drawable.imode_e65a, R.drawable.imode_e65b, R.drawable.imode_e65c, R.drawable.imode_e65d, R.drawable.imode_e65e, R.drawable.imode_e65f, R.drawable.imode_e660, R.drawable.imode_e661, R.drawable.imode_e662, R.drawable.imode_e663, R.drawable.imode_e664, R.drawable.imode_e665, R.drawable.imode_e666, R.drawable.imode_e667, R.drawable.imode_e668, R.drawable.imode_e669, R.drawable.imode_e66a, R.drawable.imode_e66b, R.drawable.imode_e66c, R.drawable.imode_e66d, R.drawable.imode_e66e, R.drawable.imode_e66f, R.drawable.imode_e670, R.drawable.imode_e671, R.drawable.imode_e672, R.drawable.imode_e673, R.drawable.imode_e674, R.drawable.imode_e675, R.drawable.imode_e676, R.drawable.imode_e677, R.drawable.imode_e678, R.drawable.imode_e679, R.drawable.imode_e67a, R.drawable.imode_e67b, R.drawable.imode_e67c, R.drawable.imode_e67d, R.drawable.imode_e67e, R.drawable.imode_e67f, R.drawable.imode_e680, R.drawable.imode_e681, R.drawable.imode_e682, R.drawable.imode_e683, R.drawable.imode_e684, R.drawable.imode_e685, R.drawable.imode_e686, R.drawable.imode_e687, R.drawable.imode_e688, R.drawable.imode_e689, R.drawable.imode_e68a, R.drawable.imode_e68b, R.drawable.imode_e68c, R.drawable.imode_e68d, R.drawable.imode_e68e, R.drawable.imode_e68f, R.drawable.imode_e690, R.drawable.imode_e691, R.drawable.imode_e692, R.drawable.imode_e693, R.drawable.imode_e694, R.drawable.imode_e695, R.drawable.imode_e696, R.drawable.imode_e697, R.drawable.imode_e698, R.drawable.imode_e699, R.drawable.imode_e69a, R.drawable.imode_e69b, R.drawable.imode_e69c, R.drawable.imode_e69d, R.drawable.imode_e69e, R.drawable.imode_e69f, R.drawable.imode_e6a0, R.drawable.imode_e6a1, R.drawable.imode_e6a2, R.drawable.imode_e6a3, R.drawable.imode_e6a4, R.drawable.imode_e6a5, R.drawable.imode_e6ac, R.drawable.imode_e6ad, R.drawable.imode_e6ae, R.drawable.imode_e6b1, R.drawable.imode_e6b2, R.drawable.imode_e6b3, R.drawable.imode_e6b7, R.drawable.imode_e6b8, R.drawable.imode_e6b9, R.drawable.imode_e6ba, R.drawable.imode_e6ce, R.drawable.imode_e6cf, R.drawable.imode_e6d0, R.drawable.imode_e6d1, R.drawable.imode_e6d2, R.drawable.imode_e6d3, R.drawable.imode_e6d4, R.drawable.imode_e6d5, R.drawable.imode_e6d6, R.drawable.imode_e6d7, R.drawable.imode_e6d8, R.drawable.imode_e6d9, R.drawable.imode_e6da, R.drawable.imode_e6db, R.drawable.imode_e6dc, R.drawable.imode_e6dd, R.drawable.imode_e6de, R.drawable.imode_e6df, R.drawable.imode_e6e0, R.drawable.imode_e6e1, R.drawable.imode_e6e2, R.drawable.imode_e6e3, R.drawable.imode_e6e4, R.drawable.imode_e6e5, R.drawable.imode_e6e6, R.drawable.imode_e6e7, R.drawable.imode_e6e8, R.drawable.imode_e6e9, R.drawable.imode_e6ea, R.drawable.imode_e6eb, R.drawable.imode_e6ec, R.drawable.imode_e6ed, R.drawable.imode_e6ee, R.drawable.imode_e6ef, R.drawable.imode_e6f0, R.drawable.imode_e6f1, R.drawable.imode_e6f2, R.drawable.imode_e6f3, R.drawable.imode_e6f4, R.drawable.imode_e6f5, R.drawable.imode_e6f6, R.drawable.imode_e6f7, R.drawable.imode_e6f8, R.drawable.imode_e6f9, R.drawable.imode_e6fa, R.drawable.imode_e6fb, R.drawable.imode_e6fc, R.drawable.imode_e6fd, R.drawable.imode_e6fe, R.drawable.imode_e6ff, R.drawable.imode_e700, R.drawable.imode_e701, R.drawable.imode_e702, R.drawable.imode_e703, R.drawable.imode_e704, R.drawable.imode_e705, R.drawable.imode_e706, R.drawable.imode_e707, R.drawable.imode_e708, R.drawable.imode_e709, R.drawable.imode_e70a, R.drawable.imode_e70b, R.drawable.imode_e70c, R.drawable.imode_e70d, R.drawable.imode_e70e, R.drawable.imode_e70f, R.drawable.imode_e710, R.drawable.imode_e711, R.drawable.imode_e712, R.drawable.imode_e713, R.drawable.imode_e714, R.drawable.imode_e715, R.drawable.imode_e716, R.drawable.imode_e717, R.drawable.imode_e718, R.drawable.imode_e719, R.drawable.imode_e71a, R.drawable.imode_e71b, R.drawable.imode_e71c, R.drawable.imode_e71d, R.drawable.imode_e71e, R.drawable.imode_e71f, R.drawable.imode_e720, R.drawable.imode_e721, R.drawable.imode_e722, R.drawable.imode_e723, R.drawable.imode_e724, R.drawable.imode_e725, R.drawable.imode_e726, R.drawable.imode_e727, R.drawable.imode_e728, R.drawable.imode_e729, R.drawable.imode_e72a, R.drawable.imode_e72b, R.drawable.imode_e72c, R.drawable.imode_e72d, R.drawable.imode_e72e, R.drawable.imode_e72f, R.drawable.imode_e730, R.drawable.imode_e731, R.drawable.imode_e732, R.drawable.imode_e733, R.drawable.imode_e734, R.drawable.imode_e735, R.drawable.imode_e736, R.drawable.imode_e737, R.drawable.imode_e738, R.drawable.imode_e739, R.drawable.imode_e73a, R.drawable.imode_e73b, R.drawable.imode_e73c, R.drawable.imode_e73d, R.drawable.imode_e73e, R.drawable.imode_e73f, R.drawable.imode_e740, R.drawable.imode_e741, R.drawable.imode_e742, R.drawable.imode_e743, R.drawable.imode_e744, R.drawable.imode_e745, R.drawable.imode_e746, R.drawable.imode_e747, R.drawable.imode_e748, R.drawable.imode_e749, R.drawable.imode_e74a, R.drawable.imode_e74b, R.drawable.imode_e74c, R.drawable.imode_e74d, R.drawable.imode_e74e, R.drawable.imode_e74f, R.drawable.imode_e750, R.drawable.imode_e751, R.drawable.imode_e752, R.drawable.imode_e753, R.drawable.imode_e754, R.drawable.imode_e755, R.drawable.imode_e756, R.drawable.imode_e757};

    public static String getInitialEmojiList() {
        return "";
    }

    public static String getEmojiList() {
        String emojiList = getInitialEmojiList();
        try {
            FileInputStream fis = new FileInputStream(EMOJI_FILE_NAME);
            InputStreamReader ir = new InputStreamReader(fis, "UTF-8");
            String tmp = new BufferedReader(ir).readLine();
            fis.close();
            ir.close();
            fis.close();
            return tmp;
        } catch (Exception e) {
            return emojiList;
        }
    }

    public static void updateEmoji(WnnWord word) {
        String emojiList = getInitialEmojiList();
        try {
            FileInputStream fis = new FileInputStream(EMOJI_FILE_NAME);
            InputStreamReader ir = new InputStreamReader(fis, "UTF-8");
            emojiList = new BufferedReader(ir).readLine();
            fis.close();
            ir.close();
            fis.close();
        } catch (Exception e) {
        }
        if (emojiList.indexOf(word.candidate) == -1) {
            emojiList = word.candidate + emojiList.substring(0, 11);
            try {
                FileOutputStream fos = new FileOutputStream(EMOJI_FILE_NAME);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(emojiList);
                bw.close();
                osw.close();
                fos.close();
            } catch (Exception e2) {
            }
        }
    }

    public static String getEmojiByPosition(long position) {
        return new String(new char[]{mEmojiCharList[(int) position]});
    }

    public static int getRid(char ch) {
        if (ch < '' || ch > '') {
            return 0;
        }
        int rid = mEmojiRid[ch - 58942];
        if (rid == 0) {
            return R.drawable.imode_e63e;
        }
        return rid;
    }

    public static void setEmojiRid() {
        if (mEmojiRid == null) {
            mEmojiRid = new int[OpenWnnEngineEN.PREDICT_LIMIT];
            mEmojiRid[0] = R.drawable.imode_e63e;
            mEmojiRid[1] = R.drawable.imode_e63f;
            mEmojiRid[2] = R.drawable.imode_e640;
            mEmojiRid[3] = R.drawable.imode_e641;
            mEmojiRid[4] = R.drawable.imode_e642;
            mEmojiRid[5] = R.drawable.imode_e643;
            mEmojiRid[6] = R.drawable.imode_e644;
            mEmojiRid[7] = R.drawable.imode_e645;
            mEmojiRid[8] = R.drawable.imode_e646;
            mEmojiRid[9] = R.drawable.imode_e647;
            mEmojiRid[10] = R.drawable.imode_e648;
            mEmojiRid[11] = R.drawable.imode_e649;
            mEmojiRid[12] = R.drawable.imode_e64a;
            mEmojiRid[13] = R.drawable.imode_e64b;
            mEmojiRid[14] = R.drawable.imode_e64c;
            mEmojiRid[15] = R.drawable.imode_e64d;
            mEmojiRid[16] = R.drawable.imode_e64e;
            mEmojiRid[17] = R.drawable.imode_e64f;
            mEmojiRid[18] = R.drawable.imode_e650;
            mEmojiRid[19] = R.drawable.imode_e651;
            mEmojiRid[20] = R.drawable.imode_e652;
            mEmojiRid[21] = R.drawable.imode_e653;
            mEmojiRid[22] = R.drawable.imode_e654;
            mEmojiRid[23] = R.drawable.imode_e655;
            mEmojiRid[24] = R.drawable.imode_e656;
            mEmojiRid[25] = R.drawable.imode_e657;
            mEmojiRid[26] = R.drawable.imode_e658;
            mEmojiRid[27] = R.drawable.imode_e659;
            mEmojiRid[28] = R.drawable.imode_e65a;
            mEmojiRid[29] = R.drawable.imode_e65b;
            mEmojiRid[30] = R.drawable.imode_e65c;
            mEmojiRid[31] = R.drawable.imode_e65d;
            mEmojiRid[32] = R.drawable.imode_e65e;
            mEmojiRid[33] = R.drawable.imode_e65f;
            mEmojiRid[34] = R.drawable.imode_e660;
            mEmojiRid[35] = R.drawable.imode_e661;
            mEmojiRid[36] = R.drawable.imode_e662;
            mEmojiRid[37] = R.drawable.imode_e663;
            mEmojiRid[38] = R.drawable.imode_e664;
            mEmojiRid[39] = R.drawable.imode_e665;
            mEmojiRid[40] = R.drawable.imode_e666;
            mEmojiRid[41] = R.drawable.imode_e667;
            mEmojiRid[42] = R.drawable.imode_e668;
            mEmojiRid[43] = R.drawable.imode_e669;
            mEmojiRid[44] = R.drawable.imode_e66a;
            mEmojiRid[45] = R.drawable.imode_e66b;
            mEmojiRid[46] = R.drawable.imode_e66c;
            mEmojiRid[47] = R.drawable.imode_e66d;
            mEmojiRid[48] = R.drawable.imode_e66e;
            mEmojiRid[49] = R.drawable.imode_e66f;
            mEmojiRid[50] = R.drawable.imode_e670;
            mEmojiRid[51] = R.drawable.imode_e671;
            mEmojiRid[52] = R.drawable.imode_e672;
            mEmojiRid[53] = R.drawable.imode_e673;
            mEmojiRid[54] = R.drawable.imode_e674;
            mEmojiRid[55] = R.drawable.imode_e675;
            mEmojiRid[56] = R.drawable.imode_e676;
            mEmojiRid[57] = R.drawable.imode_e677;
            mEmojiRid[58] = R.drawable.imode_e678;
            mEmojiRid[59] = R.drawable.imode_e679;
            mEmojiRid[60] = R.drawable.imode_e67a;
            mEmojiRid[61] = R.drawable.imode_e67b;
            mEmojiRid[62] = R.drawable.imode_e67c;
            mEmojiRid[63] = R.drawable.imode_e67d;
            mEmojiRid[64] = R.drawable.imode_e67e;
            mEmojiRid[65] = R.drawable.imode_e67f;
            mEmojiRid[66] = R.drawable.imode_e680;
            mEmojiRid[67] = R.drawable.imode_e681;
            mEmojiRid[68] = R.drawable.imode_e682;
            mEmojiRid[69] = R.drawable.imode_e683;
            mEmojiRid[70] = R.drawable.imode_e684;
            mEmojiRid[71] = R.drawable.imode_e685;
            mEmojiRid[72] = R.drawable.imode_e686;
            mEmojiRid[73] = R.drawable.imode_e687;
            mEmojiRid[74] = R.drawable.imode_e688;
            mEmojiRid[75] = R.drawable.imode_e689;
            mEmojiRid[76] = R.drawable.imode_e68a;
            mEmojiRid[77] = R.drawable.imode_e68b;
            mEmojiRid[78] = R.drawable.imode_e68c;
            mEmojiRid[79] = R.drawable.imode_e68d;
            mEmojiRid[80] = R.drawable.imode_e68e;
            mEmojiRid[81] = R.drawable.imode_e68f;
            mEmojiRid[82] = R.drawable.imode_e690;
            mEmojiRid[83] = R.drawable.imode_e691;
            mEmojiRid[84] = R.drawable.imode_e692;
            mEmojiRid[85] = R.drawable.imode_e693;
            mEmojiRid[86] = R.drawable.imode_e694;
            mEmojiRid[87] = R.drawable.imode_e695;
            mEmojiRid[88] = R.drawable.imode_e696;
            mEmojiRid[89] = R.drawable.imode_e697;
            mEmojiRid[90] = R.drawable.imode_e698;
            mEmojiRid[91] = R.drawable.imode_e699;
            mEmojiRid[92] = R.drawable.imode_e69a;
            mEmojiRid[93] = R.drawable.imode_e69b;
            mEmojiRid[94] = R.drawable.imode_e69c;
            mEmojiRid[95] = R.drawable.imode_e69d;
            mEmojiRid[96] = R.drawable.imode_e69e;
            mEmojiRid[97] = R.drawable.imode_e69f;
            mEmojiRid[98] = R.drawable.imode_e6a0;
            mEmojiRid[99] = R.drawable.imode_e6a1;
            mEmojiRid[100] = R.drawable.imode_e6a2;
            mEmojiRid[OpenWnnJAJP.ENGINE_MODE_FULL_KATAKANA] = R.drawable.imode_e6a3;
            mEmojiRid[OpenWnnJAJP.ENGINE_MODE_HALF_KATAKANA] = R.drawable.imode_e6a4;
            mEmojiRid[OpenWnnJAJP.ENGINE_MODE_EISU_KANA] = R.drawable.imode_e6a5;
            mEmojiRid[110] = R.drawable.imode_e6ac;
            mEmojiRid[111] = R.drawable.imode_e6ad;
            mEmojiRid[112] = R.drawable.imode_e6ae;
            mEmojiRid[115] = R.drawable.imode_e6b1;
            mEmojiRid[116] = R.drawable.imode_e6b2;
            mEmojiRid[117] = R.drawable.imode_e6b3;
            mEmojiRid[121] = R.drawable.imode_e6b7;
            mEmojiRid[122] = R.drawable.imode_e6b8;
            mEmojiRid[123] = R.drawable.imode_e6b9;
            mEmojiRid[124] = R.drawable.imode_e6ba;
            mEmojiRid[144] = R.drawable.imode_e6ce;
            mEmojiRid[145] = R.drawable.imode_e6cf;
            mEmojiRid[146] = R.drawable.imode_e6d0;
            mEmojiRid[147] = R.drawable.imode_e6d1;
            mEmojiRid[148] = R.drawable.imode_e6d2;
            mEmojiRid[149] = R.drawable.imode_e6d3;
            mEmojiRid[150] = R.drawable.imode_e6d4;
            mEmojiRid[151] = R.drawable.imode_e6d5;
            mEmojiRid[152] = R.drawable.imode_e6d6;
            mEmojiRid[153] = R.drawable.imode_e6d7;
            mEmojiRid[154] = R.drawable.imode_e6d8;
            mEmojiRid[155] = R.drawable.imode_e6d9;
            mEmojiRid[156] = R.drawable.imode_e6da;
            mEmojiRid[157] = R.drawable.imode_e6db;
            mEmojiRid[158] = R.drawable.imode_e6dc;
            mEmojiRid[159] = R.drawable.imode_e6dd;
            mEmojiRid[160] = R.drawable.imode_e6de;
            mEmojiRid[161] = R.drawable.imode_e6df;
            mEmojiRid[162] = R.drawable.imode_e6e0;
            mEmojiRid[163] = R.drawable.imode_e6e1;
            mEmojiRid[164] = R.drawable.imode_e6e2;
            mEmojiRid[165] = R.drawable.imode_e6e3;
            mEmojiRid[166] = R.drawable.imode_e6e4;
            mEmojiRid[167] = R.drawable.imode_e6e5;
            mEmojiRid[168] = R.drawable.imode_e6e6;
            mEmojiRid[169] = R.drawable.imode_e6e7;
            mEmojiRid[170] = R.drawable.imode_e6e8;
            mEmojiRid[171] = R.drawable.imode_e6e9;
            mEmojiRid[172] = R.drawable.imode_e6ea;
            mEmojiRid[173] = R.drawable.imode_e6eb;
            mEmojiRid[174] = R.drawable.imode_e6ec;
            mEmojiRid[175] = R.drawable.imode_e6ed;
            mEmojiRid[176] = R.drawable.imode_e6ee;
            mEmojiRid[177] = R.drawable.imode_e6ef;
            mEmojiRid[178] = R.drawable.imode_e6f0;
            mEmojiRid[179] = R.drawable.imode_e6f1;
            mEmojiRid[180] = R.drawable.imode_e6f2;
            mEmojiRid[181] = R.drawable.imode_e6f3;
            mEmojiRid[182] = R.drawable.imode_e6f4;
            mEmojiRid[183] = R.drawable.imode_e6f5;
            mEmojiRid[184] = R.drawable.imode_e6f6;
            mEmojiRid[185] = R.drawable.imode_e6f7;
            mEmojiRid[186] = R.drawable.imode_e6f8;
            mEmojiRid[187] = R.drawable.imode_e6f9;
            mEmojiRid[188] = R.drawable.imode_e6fa;
            mEmojiRid[189] = R.drawable.imode_e6fb;
            mEmojiRid[190] = R.drawable.imode_e6fc;
            mEmojiRid[191] = R.drawable.imode_e6fd;
            mEmojiRid[192] = R.drawable.imode_e6fe;
            mEmojiRid[193] = R.drawable.imode_e6ff;
            mEmojiRid[194] = R.drawable.imode_e700;
            mEmojiRid[195] = R.drawable.imode_e701;
            mEmojiRid[196] = R.drawable.imode_e702;
            mEmojiRid[197] = R.drawable.imode_e703;
            mEmojiRid[198] = R.drawable.imode_e704;
            mEmojiRid[199] = R.drawable.imode_e705;
            mEmojiRid[200] = R.drawable.imode_e706;
            mEmojiRid[201] = R.drawable.imode_e707;
            mEmojiRid[202] = R.drawable.imode_e708;
            mEmojiRid[203] = R.drawable.imode_e709;
            mEmojiRid[204] = R.drawable.imode_e70a;
            mEmojiRid[205] = R.drawable.imode_e70b;
            mEmojiRid[206] = R.drawable.imode_e70c;
            mEmojiRid[207] = R.drawable.imode_e70d;
            mEmojiRid[208] = R.drawable.imode_e70e;
            mEmojiRid[209] = R.drawable.imode_e70f;
            mEmojiRid[210] = R.drawable.imode_e710;
            mEmojiRid[211] = R.drawable.imode_e711;
            mEmojiRid[212] = R.drawable.imode_e712;
            mEmojiRid[213] = R.drawable.imode_e713;
            mEmojiRid[214] = R.drawable.imode_e714;
            mEmojiRid[215] = R.drawable.imode_e715;
            mEmojiRid[216] = R.drawable.imode_e716;
            mEmojiRid[217] = R.drawable.imode_e717;
            mEmojiRid[218] = R.drawable.imode_e718;
            mEmojiRid[219] = R.drawable.imode_e719;
            mEmojiRid[220] = R.drawable.imode_e71a;
            mEmojiRid[221] = R.drawable.imode_e71b;
            mEmojiRid[222] = R.drawable.imode_e71c;
            mEmojiRid[223] = R.drawable.imode_e71d;
            mEmojiRid[224] = R.drawable.imode_e71e;
            mEmojiRid[225] = R.drawable.imode_e71f;
            mEmojiRid[226] = R.drawable.imode_e720;
            mEmojiRid[227] = R.drawable.imode_e721;
            mEmojiRid[228] = R.drawable.imode_e722;
            mEmojiRid[229] = R.drawable.imode_e723;
            mEmojiRid[230] = R.drawable.imode_e724;
            mEmojiRid[231] = R.drawable.imode_e725;
            mEmojiRid[232] = R.drawable.imode_e726;
            mEmojiRid[233] = R.drawable.imode_e727;
            mEmojiRid[234] = R.drawable.imode_e728;
            mEmojiRid[235] = R.drawable.imode_e729;
            mEmojiRid[236] = R.drawable.imode_e72a;
            mEmojiRid[237] = R.drawable.imode_e72b;
            mEmojiRid[238] = R.drawable.imode_e72c;
            mEmojiRid[239] = R.drawable.imode_e72d;
            mEmojiRid[240] = R.drawable.imode_e72e;
            mEmojiRid[241] = R.drawable.imode_e72f;
            mEmojiRid[242] = R.drawable.imode_e730;
            mEmojiRid[243] = R.drawable.imode_e731;
            mEmojiRid[244] = R.drawable.imode_e732;
            mEmojiRid[245] = R.drawable.imode_e733;
            mEmojiRid[246] = R.drawable.imode_e734;
            mEmojiRid[247] = R.drawable.imode_e735;
            mEmojiRid[248] = R.drawable.imode_e736;
            mEmojiRid[249] = R.drawable.imode_e737;
            mEmojiRid[250] = R.drawable.imode_e738;
            mEmojiRid[251] = R.drawable.imode_e739;
            mEmojiRid[252] = R.drawable.imode_e73a;
            mEmojiRid[253] = R.drawable.imode_e73b;
            mEmojiRid[254] = R.drawable.imode_e73c;
            mEmojiRid[255] = R.drawable.imode_e73d;
            mEmojiRid[256] = R.drawable.imode_e73e;
            mEmojiRid[257] = R.drawable.imode_e73f;
            mEmojiRid[258] = R.drawable.imode_e740;
            mEmojiRid[259] = R.drawable.imode_e741;
            mEmojiRid[260] = R.drawable.imode_e742;
            mEmojiRid[261] = R.drawable.imode_e743;
            mEmojiRid[262] = R.drawable.imode_e744;
            mEmojiRid[263] = R.drawable.imode_e745;
            mEmojiRid[264] = R.drawable.imode_e746;
            mEmojiRid[265] = R.drawable.imode_e747;
            mEmojiRid[266] = R.drawable.imode_e748;
            mEmojiRid[267] = R.drawable.imode_e749;
            mEmojiRid[268] = R.drawable.imode_e74a;
            mEmojiRid[269] = R.drawable.imode_e74b;
            mEmojiRid[270] = R.drawable.imode_e74c;
            mEmojiRid[271] = R.drawable.imode_e74d;
            mEmojiRid[272] = R.drawable.imode_e74e;
            mEmojiRid[273] = R.drawable.imode_e74f;
            mEmojiRid[274] = R.drawable.imode_e750;
            mEmojiRid[275] = R.drawable.imode_e751;
            mEmojiRid[276] = R.drawable.imode_e752;
            mEmojiRid[277] = R.drawable.imode_e753;
            mEmojiRid[278] = R.drawable.imode_e754;
            mEmojiRid[279] = R.drawable.imode_e755;
            mEmojiRid[280] = R.drawable.imode_e756;
            mEmojiRid[281] = R.drawable.imode_e757;
        }
    }

    public static ArrayList<String> getEmojiArrayList() {
        ArrayList<String> ret = new ArrayList(32);
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        ret.add("");
        return ret;
    }
}
