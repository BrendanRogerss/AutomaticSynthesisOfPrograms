package Evolution;

import Functions.Boolean.*;
import Functions.Coloring.*;
import Functions.Control.*;
import Functions.Function;
import Functions.VertexSearch.*;
import Graph.*;


import java.util.ArrayList;

/**
 * Created by Brendan on 11/09/2017.
 */
public class Tree {

    public static ArrayList<Graph> graphs;
    public Graph currentGraph;
    public int[] graphColors;
    public int[] graphColorFreq;
    public Node root;
    private ArrayList<Function> genes = new ArrayList<>();

    public Tree(String sGenes){
        splitGenes(sGenes);
        //System.out.println("number of gene functions: "+genes.size());
        root = setNode();
        initFunctions(root);
    }

    public ArrayList<int[]> run(){
        ArrayList<int[]> finalGraphColors = new ArrayList<>();
        for (int i = 0; i < graphs.size(); i++) {
            currentGraph = graphs.get(i);
            graphColors = new int[currentGraph.verticies.size()];
            graphColorFreq = new int[currentGraph.verticies.size()+1];
            root.getFunction().run();
            finalGraphColors.add(graphColors);
        }
        return finalGraphColors;
    }

    public void initFunctions(Node node){
        if(node.getLeft()!=null){
            node.getFunction().setFunctionLeft(node.getLeft().getFunction());
            initFunctions(node.getLeft());
        }
        if(node.getRight()!=null){
            node.getFunction().setFunctionRight(node.getRight().getFunction());
            initFunctions(node.getRight());
        }
    }

    private Node setNode(){
        if(genes.isEmpty()){
            return null;
        }
        Node node = new Node(genes.remove(0));
        int inputs = node.getFunction().getInputs();
        switch (inputs){
            case 0:
                return node;
            case 1:
                node.setLeft(setNode());
                return node;
            case 2:
                node.setLeft(setNode());
                node.setRight(setNode());
                return node;
        }
        return node;
    }

    private Function transform(String gene){
        switch(gene){
//            case "00000": return new ExistUncoloredVertex(this);
//            case "00001": return new NotIncrease(this);
//            case "00010": return new Greedy(this);
//            case "00011": return new GreedyAdjacents(this);
//            case "00100": return new LessFrequentColor(this);
//            case "00101": return new MoreFrequentColor(this);
//            case "00110": return new SwapColor(this);
//            case "00111": return new Uncoloring(this);
//            case "01000": return new UncoloringAdjacents(this);
//            case "01001": return new And();
//            case "01010": return new Equal();
//            case "01011": return new If();
//            case "01100": return new Not();
//            case "01101": return new Or();
//            case "01110": return new While(this);
//            case "01111": return new FirstVertex(this);
//            case "10000": return new HighestNumberedColorVertex(this);
//            case "10001": return new IncidenceDegreeVertex(this);
//            case "10010": return new LargestDegreeVertex(this);
//            case "10011": return new LessFrequentVertex(this);
//            case "10100": return new LowestNumberedColorVertex(this);
//            case "10101": return new MinimumDegreeVertex(this);
//            case "10110": return new MoreFrequentColorVertex(this);
//            case "10111": return new MoreUncoloredAdjacentsVertex(this);
//            case "11000": return new SaturationDegreeVertex(this);
//
//            case "11001": return new ExistUncoloredVertex(this);
//            case "11010": return new And();
//            case "11011": return new Equal();
//            case "11100": return new If();
//            case "11101": return new Not();
//            case "11110": return new Or();
//            case "11111": return new While(this);

            //gray code
            case "00000": return new ExistUncoloredVertex(this);
            case "00001": return new NotIncrease(this);
            case "00011": return new Greedy(this);
            case "00010": return new GreedyAdjacents(this);
            case "00110": return new LessFrequentColor(this);
            case "00111": return new MoreFrequentColor(this);
            case "00101": return new SwapColor(this);
            case "00100": return new Uncoloring(this);
            case "01100": return new UncoloringAdjacents(this);
            case "01101": return new And();
            case "01111": return new Equal();
            case "01110": return new If();
            case "01010": return new Not();
            case "01011": return new Or();
            case "01001": return new While(this);
            case "01000": return new FirstVertex(this);
            case "11000": return new HighestNumberedColorVertex(this);
            case "11001": return new IncidenceDegreeVertex(this);
            case "11011": return new LargestDegreeVertex(this);
            case "11010": return new LessFrequentVertex(this);
            case "11110": return new LowestNumberedColorVertex(this);
            case "11111": return new MinimumDegreeVertex(this);
            case "11101": return new MoreFrequentColorVertex(this);
            case "11100": return new MoreUncoloredAdjacentsVertex(this);
            case "10100": return new SaturationDegreeVertex(this);

            case "10101": return new ExistUncoloredVertex(this);
            case "10111": return new And();
            case "10110": return new Equal();
            case "10010": return new If();
            case "10011": return new Not();
            case "10001": return new Or();
            case "10000": return new While(this);
        }
        System.out.println("need to fix this");
        return new Function();
    }

    private void splitGenes(String genes){
        for (int i = 5; i <= genes.length(); i+=5) {
            this.genes.add(transform(genes.substring(i-5, i)));
        }
    }

    public void printTree(Node root, int indent){
        if(root!=null) {
            String space = "";
            for (int i = 0; i < indent; i++) {
                space+=i%4==0?"|":" ";
            }
            //space+="\\";
            System.out.println(space+root);
            printTree(root.getLeft(), indent+4);
            printTree(root.getRight(), indent+4);
        }

    }
}
