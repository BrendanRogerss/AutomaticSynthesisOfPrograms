package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * It assigns left less frequent feasible
 color in the graph to vertex v. If this is not possible, it assigns left
 feasible color that does not generate conflicts using Greedy (v). If
 the function changes the color assigned to the vertex, it returns
 true; otherwise, it returns false
 */
public class LessFrequentColor extends Function{

    public int getInputs(){return 1;}

    public LessFrequentColor(Tree t){
        super(t);
    }

    public boolean run(){
        //todo
        Greedy greedy = new Greedy(t);
        return greedy.run();
    }
}
