package cn.itcast.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterUtils {
    public static String dateToStr(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(date);
    }

    public static String dateToStrSS(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
