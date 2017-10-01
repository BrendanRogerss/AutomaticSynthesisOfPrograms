package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * : It removes the current color of v, returning
 the true value; if v has no color assigned, it returns false.

 */
public class Uncoloring extends Function{

    public int getInputs(){return 1;}

    public Uncoloring(Tree t){
        super(t);
    }

    public boolean run(){
        if(left==null){
            return false;
        }

        Vertex v = left.search();
        if(v==null){
            return false;
        }
        if(t.graphColors[v.index] == 0){
            return false;
        }
        t.graphColorFreq[t.graphColors[v.index]]--;
        t.graphColors[v.index] = 0;
        return true;
    }
}
