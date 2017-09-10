package Functions.Coloring;

import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * : It exchanges the color of vertex v1 with
 that of vertex v2. If no conflicts are generated, it returns true;
 otherwise, it returns false.
 */
public class SwapColor extends Function{

    public boolean run(){
        Vertex v1 = a.search();
        Vertex v2 = b.search();

        int tempColor = v1.color;
        v1.color = v2.color;
        v2.color = tempColor;

        if(checkClash(v1) || checkClash(v2)){
            return false;
        }
        return true;
    }

    public boolean checkClash(Vertex v){
        //return true if clash
        for (Vertex neighbour : v.neighbours) {
            if (v.color != 0 && v.color == neighbour.color) {
                return true;
            }
        }

        return false;
    }

}
