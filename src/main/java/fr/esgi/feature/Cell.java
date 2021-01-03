package fr.esgi.feature;

public class Cell {
    private final State state;

    public Cell(State state) {
        this.state = state;

    }

    public State getState() {
        return state;
    }

    public boolean isAlive(){
        return state.equals(State.ALIVE);
    }

    public State nextState(int nbNeighbours){
        if (this.getState().equals(State.ALIVE)) {
            if (nbNeighbours == 2 || nbNeighbours == 3) {
                return State.ALIVE;
            } else {
                return  State.DEAD;
            }
        }

        if (this.getState().equals(State.DEAD)) {
            if (nbNeighbours== 3) {
                return State.ALIVE;
            }
        }

        return this.getState();
    }

}
