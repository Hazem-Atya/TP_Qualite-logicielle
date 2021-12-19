package com.directi.training.lsp.exercise_solution;


public class Pool
{
    public void run()
    {
        Duck donaldDuck = new RealDuck();
        Duck electricDuck = new ElectronicDuck();
        quack(donaldDuck, electricDuck);
        swim(donaldDuck, electricDuck);

    }

    private void quack(Duck... ducks)
    {
        for (Duck duck : ducks) {
            duck.quack();
        }
    }

    private void swim(Duck... ducks)
    {
        for (Duck duck : ducks) {
            duck.swim();
        }
    }

    public static void main(String[] args)
    {
        Pool pool = new Pool();
        pool.run();
    }
}
