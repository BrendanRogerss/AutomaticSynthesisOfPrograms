package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * It assigns left feasible color to the
 vertices adjacent to v using Greedy(v) and returns the value true
 if it assigns at least one color to an adjacent vertex; otherwise, it
 returns false.
 */
public class GreedyAdjacents extends Function{

    public int getInputs(){return 1;}

    public GreedyAdjacents(Tree t){
        super(t);
    }

    public boolean run(){
        Vertex v = left.search();
        Greedy colorer = new Greedy(t);
        boolean assigned = false;
        for (Vertex n : v.neighbours) {
            if(colorer.assignColor(n)){
                assigned = true;
            }
        }
        return assigned;
    }
}
