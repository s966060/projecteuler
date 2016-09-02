package org.fde.util;

public class Logger {
    public static void log(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void log(String msg) {
        System.out.println(msg);
    }

    public static void log() {

    }
}
