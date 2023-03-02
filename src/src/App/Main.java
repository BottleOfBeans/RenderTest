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
        window.setResizable(true);
        window.setTitle("Romir's Silly Goofy Little Game Thing :)");
        GameWindow gameWindow = new GameWindow();
        window.add(gameWindow);
        window.setUndecorated(true);
        window.pack();
        window.setVisible(true);
        gameWindow.startWindowThread();


        double A[][] = {
                {1,2,1},
                {0,1,0},
                {2,3,4},
        };
        double B[][] = {
                {2,5},
                {6,7},
                {1,8},
        };

        Matrix a = new Matrix(A);
        Matrix b = new Matrix(B);

        a = a.multiplyMatricies(b);
        a.printMatrix();

    }
}