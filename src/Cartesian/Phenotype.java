package Cartesian;

import Evolution.Tree;
import Functions.Function;
import Functions.Boolean.*;
import Functions.Coloring.*;
import Functions.Control.*;
import Functions.VertexSearch.*;

import java.util.ArrayList;
import java.util.Collections;

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
            if(genes[i][0]<=i && genes[i][1] <=i || (genes[i][1]>i && nodes[genes[i][1]]==null) ){ //if both inputs are behind the node
                    nodes[i].setInupts(init(genes[i][0]),null);
            }else {
                //check if its upper input exists
                    nodes[i].setInupts(init(genes[i][0]), genes[i][1] == 0 ? null : init(genes[i][1]));
            }
        }
        return nodes[i];
    }

    public ArrayList<int[]> run(){
        ArrayList<int[]> finalGraphColors = new ArrayList<>();
        for (int i = 0; i < graphs.size(); i++) {
            currentGraph = graphs.get(i);
            graphColors = new int[currentGraph.verticies.size()];
            graphColorFreq = new int[currentGraph.verticies.size() + 1];
            executeSubNet(nodes[0],nodes[nodes.length-1]);
            finalGraphColors.add(graphColors);
        }
        return finalGraphColors;
    }

    public void runLoop(CartesianNode start, CartesianNode decider){
        int limit = 10;
        int[] colors = new int[graphColors.length];
        System.arraycopy(graphColors, 0, colors, 0, colors.length);
        int timesSame = 0;
        int timesRun = 0;
        while(decider.run() && timesSame!= limit && timesRun != currentGraph.verticies.size()){
            executeSubNet(start, decider);
            if(checkChange(colors)){
                System.arraycopy(graphColors, 0, colors, 0, colors.length);
                timesSame = 0;
            }else{
                timesSame+=1;
            }
            timesRun++;
        }
    }

    private boolean checkChange(int[] lastKnown){
        for (int i = 0; i < lastKnown.length; i++) {
            if(lastKnown[i]!=graphColors[i]){
                return true;
            }
        }
        return false;
    }


    public void executeSubNet(CartesianNode start, CartesianNode end){
        ArrayList<CartesianNode> nodesToExecute = new ArrayList<>();
        CartesianNode currentNode = start;
        while(currentNode.index!=end.index){
            nodesToExecute=currentNode.getOutputs(); //get the first lot of nodes to execute
            Collections.sort(nodesToExecute);
            if(nodesToExecute.get(0).index<currentNode.index){//loop
                //System.out.println("running loop from: "+nodesToExecute.get(0).index+" to: "+currentNode.index);
                runLoop(nodesToExecute.get(0),currentNode);
            }
            int i=0;
            while(nodesToExecute.get(i).index<=currentNode.index){
                i++;
            }
            //System.out.println(currentNode.index!=0?currentNode.index+") "+currentNode.getFunction().getClass().getSimpleName():"");
            currentNode.run();
            currentNode=nodesToExecute.get(i);
            //System.out.println("got next: "+i);

        }
    }

    private Function functionLookup(int i){
        switch(i){
            case 18: return new ExistUncoloredVertex(this);
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
            case 0: return new SaturationDegreeVertex(this);

        }
        System.out.println("function number wrong: "+i);
        return null;
    }

    public String toString(){
        String output = "";
        for (int i = 0; i < nodes.length; i++) {

            if(nodes[i]!=null){
                output+="\n"+i+") "+nodes[i].toString();
            }
        }
        return output;
    }
}
