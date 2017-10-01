package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

import java.util.HashMap;

/**
 * Created by Brendan on 9/09/2017.
 * It assigns the least feasible color to vertex v.
 When changing the vertex color, the function returns the value
 true, otherwise it returns false. It is based on the Iterated Greedy
 algorithm [9]
 */
public class Greedy extends Function{

    public int getInputs(){return 1;}

    public Greedy(Tree t){
        super(t);
    }

    public boolean run() {
        if(left == null){
            return false;
        }
        return assignColor(left.search());
    }

    public boolean assignColor(Vertex v){

        if(v==null){
            return false;
        }

        int newColor = Integer.MAX_VALUE;
        //https://stackoverflow.com/questions/1586858/find-the-smallest-integer-not-in-a-list
//        int[] neighbourColors = new int[t.currentGraph.verticies.size()];
//        for (Vertex neighbour: v.neighbours) {
//            if(t.graphColors[neighbour.index]<neighbourColors.length){
//                neighbourColors[t.graphColors[neighbour.index]]=1;
//            }
//        }
//        for (int i = 0; i < neighbourColors.length; i++) {
//            if(neighbourColors[i]!=i){
//                newColor = i;
//                break;
//            }
//        }
//        if(newColor>neighbourColors.length){
//            newColor = neighbourColors.length;
//        }
        HashMap<Integer, Integer> values = new HashMap<>();
        values.put(0,0);
        for (Vertex neighbour: v.neighbours) {
            values.put(t.graphColors[neighbour.index],t.graphColors[neighbour.index]);
        }
        for (int i = 0; i < t.currentGraph.verticies.size(); i++) {
            if(values.get(i)==null){
                newColor = i;
                break;
            }
        }

        if(t.graphColors[v.index] == 0 || t.graphColors[v.index]>newColor){
            if(newColor==2147483647){
                newColor=values.size();
            }
            t.graphColorFreq[t.graphColors[v.index]]--;
            t.graphColors[v.index] = newColor;
            t.graphColorFreq[newColor]++;
            return true;
        }
        return false;
    }

}
