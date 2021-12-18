package com.directi.training.dip.solution;

import java.io.IOException;

public class DatabaseWriter implements Writer{
    @Override
    public void write(String inputString) throws IOException {
        new MyDatabase().write(inputString);

    }
}
