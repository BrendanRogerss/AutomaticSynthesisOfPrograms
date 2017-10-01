package Functions.VertexSearch;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * More-frequent-color-vertex: It identifies the highest
 numbered vertex with the most frequently used color in the
 graph; if it does not exist, it returns false.
 *
 */
public class MoreFrequentColorVertex extends Function {

    public boolean run(){return search() != null;}

    public MoreFrequentColorVertex(Tree t){
        super(t);
    }

    public Vertex search(){
        //find the highest numbered freq
        int highestFreq = 0;
        int highestFreqIndex = 0;
        for (int i = 0; i < t.currentGraph.verticies.size(); i++) {
            if (t.graphColorFreq[i]>=highestFreq){
                highestFreq = t.graphColorFreq[i];
                highestFreqIndex = i;
            }
        }
        if(highestFreq==0){
            return null;
        }

        return t.currentGraph.verticies.get(highestFreqIndex);
    }
}
