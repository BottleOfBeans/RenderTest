package src.App;

import javax.swing.*;


public class Main {
    public static void main(String args[]) {
        /*
            Setting up the JFrame Window
            Resizeable --> False
            Close Operation --> Exit On Close
            Window Name --> "Romir's Silly Goofy Little Game Thing :)"
            Window Visibility --> True
         */
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("Romir's Silly Goofy Little Game Thing :)");
        GameWindow gameWindow = new GameWindow();
        window.add(gameWindow);
        window.pack();
        window.setVisible(true);
        gameWindow.startWindowThread();


        double A[][] = {
                {10},
                {10},
                {20},
        };
        double B[][] = {
                {1,0,0},
                {0,0, 1},
        };

        Matrix a = new Matrix(A);
        Matrix b = new Matrix(B);

        b = b.multiplyMatricies(a);
        b.printMatrix();


    }
}