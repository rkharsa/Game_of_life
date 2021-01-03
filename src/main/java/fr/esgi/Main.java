package fr.esgi;

import fr.esgi.feature.Cell;
import fr.esgi.feature.State;
import fr.esgi.feature.Universe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter number of iterations to run: ");
        Scanner in = new Scanner(System.in);
        int iterations = in.nextInt();
        in.close();

        Cell[][] grid= {
                {new Cell(State.DIED),new Cell(State.DIED),new Cell(State.DIED)},
                {new Cell(State.ALIVE),new Cell(State.ALIVE),new Cell(State.ALIVE)},
                {new Cell(State.DIED),new Cell(State.DIED),new Cell(State.DIED)}
        };
        Universe universe=new Universe(grid);

        for(int iter =0 ;iter<iterations;iter++ ){

            System.out.print("Génération n°"+iter);
            universe.display();
            System.out.println("\n\n\n");
            Universe.nextGeneration(universe);
        }
    }
}
