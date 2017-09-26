package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * Less-frequent-color-vertex: It identifies the lowest numbered
 colored vertex with left less frequent color; if it does not
 exist, it returns false.
 */
public class LessFrequentVertex extends Function {

    public boolean run(){return search() != null;}

    public LessFrequentVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        return null;
    }
}
