package fr.esgi.feature;

public class Universe {
    private Cell[][]  generation ;

    public Universe(Cell[][] generation){
        this.generation=generation;

    }

    public static void nextGeneration(Universe universe){
        Cell[][] nextGeneration=new Cell[universe.generation.length][universe.generation[0].length];
        for(int row=0;row<universe.generation.length;row++){
            for(int col=0;col<universe.generation[row].length;col++){
                int nbNeighbours=universe.neighborCount(row,col);
                nextGeneration[row][col]=new Cell(universe.generation[row][col].nextState(nbNeighbours));
            }
        }
        universe.generation= nextGeneration;
    }

    public int neighborCount(int row, int col) {
        int count = 0;
        for(int i = row - 1; i <= row + 1; i++) {
            if (i >= 0 && i < generation.length)
                for(int j = col - 1; j <= col + 1; j++)
                    if (j >= 0 && j < generation[i].length)
                        if (i != row || j != col)
                            if (generation[i][j].isAlive())
                                count++;
        }

        return count;
    }
    public Cell[][] getGeneration(){
        return this.generation;
    }


    public int countAliveCell(){
        int nbAlive=0;
        for (Cell[] cells : generation) {
            for (Cell cell : cells) {
                if (cell.getState().equals(State.ALIVE)) {
                    nbAlive++;
                }
            }
        }
        return nbAlive;
    }

    public void display(){
        for (Cell[] cells : generation) {
            System.out.print("\n|");
            for (Cell cell : cells) {
                if(cell.getState().equals(State.ALIVE))
                    System.out.print("x");
                else
                    System.out.print(" ");

                System.out.print("|");
            }
        }
        System.out.print("\nNumber of alive cell : "+ countAliveCell());
    }

}
