package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * : It exchanges the color of vertex v1 with
 that of vertex v2. If no conflicts are generated, it returns true;
 otherwise, it returns false.
 */
public class SwapColor extends Function{

    public int getInputs(){return 2;}

    public SwapColor(Tree t){
        super(t);
    }

    public boolean run(){
        Vertex v1 = left.search();
        Vertex v2 = right.search();

        if(v1 == null || v2==null){
            return false;
        }

        int tempColor = t.graphColors[v1.index];
        t.graphColors[v1.index] = t.graphColors[v2.index];
        t.graphColors[v2.index] = tempColor;

        if(checkClash(v1) || checkClash(v2)){
            return false;
        }
        return true;
    }

    public boolean checkClash(Vertex v){
        //return true if clash
        for (Vertex neighbour : v.neighbours) {
            if (t.graphColors[v.index] != 0 && t.graphColors[v.index] == t.graphColors[neighbour.index]) {
                return true;
            }
        }

        return false;
    }

}
