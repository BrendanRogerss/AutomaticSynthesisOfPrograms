package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

import java.util.ArrayList;

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
        Vertex currentTop = null;
        int currentMost = 0;
        int tempAdjacent;
        for(Vertex v : t.currentGraph.verticies){
            tempAdjacent = differentAdjacent(v);
            if(tempAdjacent > currentMost){
                currentMost = tempAdjacent;
                currentTop = v;
            }
        }
        return currentTop;
    }

    private int differentAdjacent(Vertex input){
        ArrayList<Integer> colors = new ArrayList<>();
        for(Vertex v : input.neighbours){
            if(!colors.contains(t.graphColors[v.index])){
                colors.add(t.graphColors[v.index]);
            }
        }
        return colors.size();
    }

}
