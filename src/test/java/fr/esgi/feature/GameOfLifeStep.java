package fr.esgi.feature;

import fr.esgi.feature.Universe;
import fr.esgi.feature.State;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonnéque;
import io.cucumber.java.fr.Quand;
import org.junit.Assert;

import java.util.List;

public class GameOfLifeStep {
    Universe universe;

    public Cell[][] convertDataTableToGeneration(DataTable generationStr){
        List<List<String>> rows = generationStr.asLists(String.class);
        Cell[][] generation = new Cell[rows.size()][rows.get(0).size()];
        for(int x =0;x<rows.size();x++){
            for(int y=0;y<rows.get(x).size();y++){
                if("x".equals(rows.get(x).get(y)))
                    generation[x][y]=new Cell(State.ALIVE);
                else
                    generation[x][y]=new Cell(State.DIED);
            }
        }
        return  generation;
    }
    @Etantdonnéque("j'ai une génération contenant")
    public void jaiUneGenerationContenant(DataTable generationStr){

        this.universe = new Universe(this.convertDataTableToGeneration(generationStr));

    }

    @Quand("je passe à la génération suivante")
    public void jePasseALaGenerationSuivante(){
        universe.display();
        Universe.nextGeneration(this.universe);
        universe.display();
    }



    @Alors("la cellule au centre devrait mourir")
    public void laCelluleAuCentreDevraitMourir() {
        int middle= universe.getGeneration().length/2;
        State expected=State.DIED;
        Assert.assertEquals(expected, universe.getGeneration()[middle][middle].getState());

    }

    @Alors("la cellule au centre devrait (être vivante|naitre)")
    public void laCelluleAuCentreDevraitEtreVivante() {
        System.out.println("je sujis la ");
        int middle= universe.getGeneration().length/2;
        State expected=State.ALIVE;
        Assert.assertEquals(expected, universe.getGeneration()[middle][middle].getState());
    }


    @Alors("toutes les cellules devraient être mortes")
    public void toutesLesCellulesDevraiEtreMortes() {
        boolean alive=false;
        for(int row = 0; row< universe.getGeneration().length; row++){
            for(int col = 0; col< universe.getGeneration()[row].length; col++){
                if(universe.getGeneration()[row][col].isAlive()){
                    alive=true;
                }
            }
        }
        Assert.assertFalse(alive);
    }


    @Alors("la génération suivante devrait contenir")
    public void laGenerationSuivanteDevraitContenir(DataTable generationStr) {
        Cell[][] expectedGen= convertDataTableToGeneration(generationStr);
        boolean equals=true;
        for(int x =0;x<expectedGen.length;x++){
            for(int y=0;y<expectedGen[x].length;y++){
                if(!this.universe.getGeneration()[x][y].getState().equals(expectedGen[x][y].getState()))
                    equals=false;
            }
        }
        Assert.assertTrue(equals);
    }
}
