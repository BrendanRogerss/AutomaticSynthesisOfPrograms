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
        //find the highest numbered freq
        int lowestFreq = Integer.MAX_VALUE;
        int lowestFreqIndex = 0;
        for (int i = 0; i < t.graphColorFreq.length; i++) {
            if (t.graphColorFreq[i]<lowestFreq && t.graphColorFreq[i]!=0){
                lowestFreq = t.graphColorFreq[i];
                lowestFreqIndex = i;
            }
        }
        if(lowestFreq==Integer.MAX_VALUE){
            return null;
        }

        return t.currentGraph.verticies.get(lowestFreqIndex);
    }
}
