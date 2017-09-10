package Functions.Coloring;

import Functions.Function;
import Graph.Vertex;

import java.util.ArrayList;

/**
 * Created by Brendan on 9/09/2017.
 * It assigns the least feasible color to vertex v.
 When changing the vertex color, the function returns the value
 true, otherwise it returns false. It is based on the Iterated Greedy
 algorithm [9]
 */
public class Greedy extends Function{

    public boolean run(){
        return assignColor(a.search());
    }

    public boolean assignColor(Vertex v){
        int newColor = Integer.MAX_VALUE;
        //https://stackoverflow.com/questions/1586858/find-the-smallest-integer-not-in-a-list
        int[] neighbourColors = new int[v.neighbours.size()];
        for (Vertex neighbour: v.neighbours) {
            if(neighbour.color<neighbourColors.length){
                neighbourColors[neighbour.color]=1;
            }
        }
        for (int i = 0; i < neighbourColors.length; i++) {
            if(neighbourColors[i]!=i){
                newColor = i;
                break;
            }
        }
        if(newColor>neighbourColors.length){
            newColor = neighbourColors.length;
        }

        if(v.color == 0 || v.color>newColor){
            v.color = newColor;
            return true;
        }
        return false;
    }

}
