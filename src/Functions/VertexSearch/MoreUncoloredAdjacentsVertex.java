package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Coloring.MoreFrequentColor;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * More-uncolored-adjacents-vertex: It identifies the lowest
 numbered vertex with the most uncolored adjacent vertices,
 according to the vertex selection criterion of the RLF
 algorithm; if it does not find left vertex, it returns false.
 */
public class MoreUncoloredAdjacentsVertex extends Function {

    public boolean run(){return search() != null;}

    public MoreUncoloredAdjacentsVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        return null;
    }
}
