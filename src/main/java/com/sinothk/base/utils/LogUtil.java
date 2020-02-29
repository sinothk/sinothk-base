package com.sinothk.base.utils;

import org.apache.log4j.Logger;

public class LogUtil {

    private static Logger logger;
    private static LogUtil instance;

    public static LogUtil getInstance(Class cls) {

        synchronized (LogUtil.class) {
            if (instance == null) {
                instance = new LogUtil();
                logger = Logger.getLogger(cls);
            }
        }
        return instance;
    }

    public void info(String str) {
        logger.info(str);
    }

    public void debug(String str) {
        logger.debug(str);
    }

    public void error(String str) {
        logger.error(str);
    }
}
