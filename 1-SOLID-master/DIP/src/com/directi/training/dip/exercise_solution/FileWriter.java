package com.directi.training.dip.exercise_solution;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter implements Writer {
    @Override
    public void write(String inputString) throws IOException {
        BufferedWriter writer = null;

        writer = new BufferedWriter(
                new java.io.FileWriter("DIP/src/com/directi/training/dip/exercise/afterEncryption.txt"));
        writer.append(inputString);
        writer.close();
    }
}
