package Functions.Coloring;

import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * : It removes the current color of v, returning
 the true value; if v has no color assigned, it returns false.

 */
public class Uncoloring extends Function{

    public boolean run(){
        Vertex v = a.search();
        if(v.color == 0){
            return false;
        }
        v.color = 0;
        return true;
    }
}
