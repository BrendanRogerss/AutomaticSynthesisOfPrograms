package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * Saturation-degree-vertex: It identifies the vertex with the
 most adjacent vertices with different assigned colors, based on
 the Saturation Degree Ordering vertex selection criterion used
 by the DSATUR algorithm. If more than one vertex has this
 characteristic, it returns the lowest numbered vertex; otherwise,
 it returns false.
 */
public class SaturationDegreeVertex extends Function {

    public boolean run(){return search() != null;}

    public SaturationDegreeVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        return null;
    }

}
