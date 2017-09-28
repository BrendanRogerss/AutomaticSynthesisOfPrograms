package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * It removes the color of each
 vertex adjacent to v and returns left true value if removing at
 least one color is feasible; otherwise, it returns false.
 */
public class UncoloringAdjacents extends Function{

    public int getInputs(){return 1;}

    public UncoloringAdjacents(Tree t){
        super(t);
    }

    public boolean run(){
        boolean returnValue = false;

        Vertex input = left.search();
        if(input==null){
            return false;
        }
        for(Vertex v : input.neighbours){
            if(t.graphColors[v.index] != 0){
                returnValue = true;
                t.graphColors[v.index] = 0;
            }
        }

        return returnValue;
    }
}
