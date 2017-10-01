package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * Highest-numbered-color-vertex: It identifies the highest
 numbered vertex with the highest numbered color; if it does
 not exist, it returns false
 */
public class HighestNumberedColorVertex extends Function {

    public boolean run(){return search() != null;}

    public HighestNumberedColorVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        Vertex returnV = null;
        int highestColor = 0;
        for(Vertex v : t.currentGraph.verticies){
            if(t.graphColors[v.index]>= highestColor){
                highestColor = t.graphColors[v.index];
                returnV = v;
            }
        }
        return returnV;
    }
}
