package Cartesian;

import Evolution.Tree;
import Functions.Function;
import Functions.Boolean.*;
import Functions.Coloring.*;
import Functions.Control.*;
import Functions.VertexSearch.*;

import java.util.ArrayList;

/**
 * Created by Brendan on 15/10/2017.
 */
public class Phenotype extends Tree {


    private int[][] genes;
    private CartesianNode[] nodes;

    public Phenotype(String sGenes) {
        super(sGenes);
    }

    public Phenotype(int[][] genes){
        super(genes);
        this.genes = genes;
        nodes = new CartesianNode[genes.length];
        nodes[0] = new CartesianNode();//root
        init(genes.length-1);
    }

    private CartesianNode init(int i){
        if(nodes[i]==null){
            //init
            nodes[i] = new CartesianNode(functionLookup(genes[i][2]),i);
            if(genes[i][0]<=i && genes[i][1] <=i ){ //if both inputs are behind the node
                    nodes[i].setInupts(init(genes[i][0]),null);
            }else {
                nodes[i].setInupts(init(genes[i][0]), genes[i][1] == 0 ? null : init(genes[i][1]));
            }
        }
        return nodes[i];
    }

    public ArrayList<int[]> run(){
        ArrayList<int[]> finalGraphColors = new ArrayList<>();
        for (int i = 0; i < graphs.size(); i++) {
            currentGraph = graphs.get(i);
            evaluateGraph();
            finalGraphColors.add(graphColors);
            nodes[0].run();
        }
        return finalGraphColors;
    }

    public void evaluateGraph(){
        graphColors = new int[currentGraph.verticies.size()];
        graphColorFreq = new int[currentGraph.verticies.size() + 1];

    }

    private Function functionLookup(int i){
        switch(i){
            case 0: return new ExistUncoloredVertex(this);
            case 1: return new NotIncrease(this);
            case 2: return new Greedy(this);
            case 3: return new GreedyAdjacents(this);
            case 4: return new LessFrequentColor(this);
            case 5: return new MoreFrequentColor(this);
            case 6: return new SwapColor(this);
            case 7: return new Uncoloring(this);
            case 8: return new UncoloringAdjacents(this);

            case 9: return new FirstVertex(this);
            case 10: return new HighestNumberedColorVertex(this);
            case 11: return new IncidenceDegreeVertex(this);
            case 12: return new LargestDegreeVertex(this);
            case 13: return new LessFrequentVertex(this);
            case 14: return new LowestNumberedColorVertex(this);
            case 15: return new MinimumDegreeVertex(this);
            case 16: return new MoreFrequentColorVertex(this);
            case 17: return new MoreUncoloredAdjacentsVertex(this);
            case 18: return new SaturationDegreeVertex(this);

//            case 9: return new And();
//            case 10: return new Equal();
//            case 11: return new If();
//            case 12: return new Not();
//            case 13: return new Or();
//            case 14: return new While(this);

//            case 25 : return new ExistUncoloredVertex(this);
//            case 26: return new And();
//            case 27: return new Equal();
//            case 28: return new If();
//            case 29: return new Not();
//            case 30: return new Or();
//            case 31: return new While(this);
        }
        System.out.println("function number wrong: "+i);
        return null;
    }

    public String toString(){
        String output = "";
        for (int i = 0; i < nodes.length; i++) {
            output+="\n"+i+") ";
            if(nodes[i]==null){
                 output+="null";
            }else{
                output+=nodes[i].toString();
            }
        }
        return output;
    }
}
