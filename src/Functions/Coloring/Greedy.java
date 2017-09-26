package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

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

    public boolean run(){
        return assignColor(left.search());
    }

    public boolean assignColor(Vertex v){

        int newColor = Integer.MAX_VALUE;
        //https://stackoverflow.com/questions/1586858/find-the-smallest-integer-not-in-a-list
        int[] neighbourColors = new int[v.neighbours.size()];
        for (Vertex neighbour: v.neighbours) {
            if(t.graphColors[neighbour.index]<neighbourColors.length){
                neighbourColors[t.graphColors[neighbour.index]]=1;
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

        if(t.graphColors[v.index] == 0 || t.graphColors[v.index]>newColor){
            t.graphColors[v.index] = newColor;
            return true;
        }
        return false;
    }

}
