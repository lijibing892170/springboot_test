package com.ljb.test.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonUtils {
    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static <T> boolean isListEmpty(List<T> list) {
        return null == list || list.isEmpty();
    }

    public static <T> boolean isArrayEmpty(T[] t) {
        return null == t || t.length == 0;
    }

    public static boolean isStringEmpty(String str) {
        return null == str || str.equals("") || str.equals(" ");
    }

    public static String getServerIp(HttpServletRequest request) {
        if (null == request) return "";
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }

    public static void saveFile(InputStream is, OutputStream os) {
        if (null == is || null == os) return;
        try {
            int len = 0;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
            }
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is) {
                    is.close();
                }
                if (null != os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getCurrentPormatDate() {
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(new Date());
    }

    public static void logI(String tag, String message) {
        System.out.println(getCurrentPormatDate() + "     INFO    [" + tag + "]    :     " + message);
    }
}
