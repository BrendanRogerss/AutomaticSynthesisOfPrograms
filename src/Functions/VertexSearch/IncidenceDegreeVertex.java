package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * Incidence-degree-vertex: It identifies the lowest numbered
 vertex with the most colored adjacent vertices, based on the
 Incidence Degree Ordering [31] vertex selection criterion; if it
 does not find left vertex, it returns false
 */
public class IncidenceDegreeVertex extends Function {

    public boolean run(){return search() != null;}

    public IncidenceDegreeVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        return null;
    }
}
