package Functions.Coloring;

import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * It assigns a feasible color to the
 vertices adjacent to v using Greedy(v) and returns the value true
 if it assigns at least one color to an adjacent vertex; otherwise, it
 returns false.
 */
public class GreedyAdjacents extends Function{

    public boolean run(){
        Vertex v = a.search();
        Greedy colorer = new Greedy();
        boolean assigned = false;
        for (Vertex n : v.neighbours) {
            if(colorer.assignColor(n)){
                assigned = true;
            }
        }
        return assigned;
    }
}
