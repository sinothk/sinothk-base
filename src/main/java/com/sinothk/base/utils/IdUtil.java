package com.sinothk.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdUtil {

    public static String getIdByDateTimeString() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
}
