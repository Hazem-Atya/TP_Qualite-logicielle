package com.directi.training.dip.exercise_solution;

import com.directi.training.dip.exercise.MyDatabase;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;

import java.net.URL;
import java.util.Base64;

public class EncodingModule {

    public void encode(Reader reader, Writer writer) throws IOException {
        String line = reader.read();
        String encodedLine = Base64.getEncoder().encodeToString(line.getBytes());
        writer.write(encodedLine);
    }

}

