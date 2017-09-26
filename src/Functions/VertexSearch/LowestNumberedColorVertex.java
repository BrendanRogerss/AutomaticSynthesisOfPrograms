package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * Lowest-numbered-color-vertex: It identifies the highest
 numbered vertex with the lowest numbered color; if it does not
 exist, it returns false.
 */
public class LowestNumberedColorVertex extends Function {

    public boolean run(){return search() != null;}

    public LowestNumberedColorVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        return null;
    }
}
