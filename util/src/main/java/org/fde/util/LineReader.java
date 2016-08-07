package org.fde.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class LineReader {
    private final InputStream is;

    public LineReader(InputStream is) {
        this.is = is;
    }

    public void readAll() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        while ((line = br.readLine()) != null) {
            readLine(line);
        }

        br.close();
    }

    public abstract void readLine(String line) throws Exception;
}
