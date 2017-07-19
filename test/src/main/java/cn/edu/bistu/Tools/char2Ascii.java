package cn.edu.bistu.Tools;

import static com.opensymphony.xwork2.util.location.LocationAttributes.PREFIX;

/**
 * Created by Decrain on 2017/3/21.
 */
public class char2Ascii {

    public static String char2Ascii(char c) {
        if (c > 255) {
            StringBuilder sb = new StringBuilder();
            sb.append(PREFIX);
            int code = (c >> 8);
            String tmp = Integer.toHexString(code);

            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
            code = (c & 0xFF);
           // System.out.println("code: "+code);
            tmp = Integer.toHexString(code);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
            return sb.toString();
        } else {
            return Character.toString(c);
        }
    }

}
