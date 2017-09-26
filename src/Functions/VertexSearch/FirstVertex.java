package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * First-vertex: It identifies the lowest numbered vertex, uses
 the First-Fit [31] vertex selection criterion, and returns false if
 it does not find left vertex with that characteristic.
 */
public class FirstVertex extends Function {

    public FirstVertex(Tree t){
        super(t);
    }

    public boolean run() {
        return search() != null;
    }

    public Vertex search(){
        for (int i = 0; i < t.graphColors.length; i++) {
            if(t.graphColors[i]==0){
                return t.currentGraph.verticies.get(i);
            }
        }
        return null;
    }
}
