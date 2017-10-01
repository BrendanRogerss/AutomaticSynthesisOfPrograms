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
        Vertex returnV = null;
        int highestColored = 0;
        int currentColored;
        for(Vertex v : t.currentGraph.verticies){
            currentColored = coloredAdjacents(v);
            if(currentColored > highestColored){
                highestColored = currentColored;
                returnV = v;
            }
        }
        return returnV;
    }

    private int coloredAdjacents(Vertex input){
        int coloredAdjacents = 0;
        for(Vertex v : input.neighbours){
            if(t.graphColors[v.index]!=0){
                coloredAdjacents++;
            }
        }

        return coloredAdjacents;
    }
}
