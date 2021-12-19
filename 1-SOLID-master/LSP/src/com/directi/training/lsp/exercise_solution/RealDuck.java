package com.directi.training.lsp.exercise_solution;

public class RealDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack...");
    }

    @Override
    public void swim() {
        System.out.println("Swim...");
    }
}
