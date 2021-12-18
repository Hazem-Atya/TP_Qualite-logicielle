package com.directi.training.dip.solution;

import com.directi.training.dip.exercise.MyDatabase;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.Base64;

public class EncodingModule {
    public void encodeWithFiles() throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String res = "";
        try {
            reader = new BufferedReader(
                    new FileReader("DIP/src/com/directi/training/dip/exercise/beforeEncryption.txt"));
            writer = new BufferedWriter(
                    new FileWriter("DIP/src/com/directi/training/dip/exercise/afterEncryption.txt"));
            String aLine;
            while ((aLine = reader.readLine()) != null) {
                res += aLine.getBytes();
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
    }

    public void encodeBasedOnNetworkAndDatabase() throws IOException {
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
        String encodedString = Base64.getEncoder().encodeToString(inputString.getBytes());
        com.directi.training.dip.exercise.MyDatabase database = new MyDatabase();
        database.write(encodedString);
    }

    void encode(Reader reader, Writer writer) {

    }

}

