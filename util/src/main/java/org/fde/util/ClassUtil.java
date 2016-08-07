package org.fde.util;

import java.io.InputStream;

public class ClassUtil {
    public static InputStream getInputStream(Object location, String fileName) {
        Class<?> aClass = location.getClass();
        ClassLoader loader = aClass.getClassLoader();

        String dir = aClass.getPackage().getName().replace('.', '/');
        String fullFileName = dir + "/" + fileName;
        InputStream is = loader.getResourceAsStream(fullFileName);
        return is;
    }
}
