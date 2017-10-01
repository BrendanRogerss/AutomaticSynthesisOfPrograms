package Functions.Boolean;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * , indicates if uncolored vertices
 remain in the graph
 */
public class ExistUncoloredVertex extends Function {

    public ExistUncoloredVertex(Tree t){
        super(t);
    }

    public boolean run(){
        for(Vertex v : t.currentGraph.verticies){
            if (t.graphColors[v.index]==0){
                return true;
            }
        }
        return false;
    }

}
