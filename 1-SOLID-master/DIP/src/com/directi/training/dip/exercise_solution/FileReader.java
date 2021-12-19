package com.directi.training.dip.exercise_solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader implements Reader {
    @Override
    public String read() throws IOException {

        BufferedReader reader = null;
        String res = "";
        try {
            reader = new BufferedReader(
                    new java.io.FileReader("DIP/src/com/directi/training/dip/exercise/beforeEncryption.txt"));
              String aLine;
            while ((aLine = reader.readLine()) != null) {
                res += aLine;
            }
        } finally {

            if (reader != null) {
                reader.close();
            }

        }
        return res;
    }
}