package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * Minimum-degree-vertex: It identifies the lowest numbered
 vertex with the fewest adjacent vertices, based on the
 Minimum Degree Ordering [32] vertex selection criterion; if
 the vertex does not exist, it returns false.
 */
public class MinimumDegreeVertex extends Function {

    public boolean run(){return search() != null;}

    public MinimumDegreeVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        return null;
    }
}
