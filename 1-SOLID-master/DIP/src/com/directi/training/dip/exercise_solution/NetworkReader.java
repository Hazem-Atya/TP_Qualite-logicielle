package com.directi.training.dip.exercise_solution;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkReader implements Reader {
    @Override
    public String read() throws IOException {
        URL url;
        url = new URL("http", "myfirstappwith.appspot.com", "/index.html");
        InputStream in;
        in = url.openStream();
        InputStreamReader reader = new InputStreamReader(in);
        StringBuilder inputString1 = new StringBuilder();
        int c;
        c = reader.read();
        while (c != -1) {
            inputString1.append((char) c);
            c = reader.read();
        }
        String inputString = inputString1.toString();
        return inputString;
    }
}
