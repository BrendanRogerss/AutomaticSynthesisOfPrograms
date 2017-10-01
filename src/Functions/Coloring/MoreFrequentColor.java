package Functions.Coloring;

import Evolution.Tree;
import Functions.Function;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 * : It assigns the feasible color with
 higher frequency in the graph to vertex v. If this is not possible,
 it assigns left color to the vertex using Greedy (v). If the function
 changes the color assigned to the vertex, it returns true;
 otherwise, it returns false.
 */
public class MoreFrequentColor extends Function {

    public int getInputs(){return 1;}

    public MoreFrequentColor(Tree t){
        super(t);
    }

    public boolean run(){
        if(left==null){
            return false;
        }

        Vertex v = left.search();
        if(v == null){
            return false;
        }

        int color = 0;
        int freq = 0;
        for (int i = 0; i < t.graphColorFreq.length; i++) {
            if(t.graphColorFreq[i]>freq){
                freq = t.graphColorFreq[i];
                color=i;
            }
        }
        if(color!=0 && !clash(v, color)){
            t.graphColorFreq[t.graphColors[v.index]]--;
            t.graphColors[v.index] = color;
            t.graphColorFreq[color]++;
            return true;
        }else{
            Greedy greedy = new Greedy(t);
            greedy.setFunctionLeft(left);
            greedy.setFunctionRight(right);
            return greedy.run();
        }
    }

    private boolean clash(Vertex v,int color){
        for( Vertex n : v.neighbours){
            if(t.graphColors[n.index]==color){
                return true;
            }
        }
        return false;
    }
}
