package com.directi.training.dip.exercise_solution;


import java.io.IOException;

public class EncodingModuleClient {
    public static void main(String[] args) throws IOException {
        EncodingModule encodingModule = new EncodingModule();
        Reader fileReader = new FileReader();
        Writer fileWriter = new FileWriter();
        encodingModule.encode(fileReader, fileWriter);
        Reader networkReader = new NetworkReader();
        Writer databaseWriter = new DatabaseWriter();
        encodingModule.encode(networkReader, databaseWriter);

    }
}
