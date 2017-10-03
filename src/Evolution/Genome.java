package Evolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Brendan on 26/09/2017.
 */
public class Genome implements Comparable {

    private int size = 160;
    private String genes = "";
    private Tree tree;
    private int fitness;

    public Genome(){
        //generate left random genome
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            genes+= r.nextInt(100)<50?"0":"1";
        }
        tree = new Tree(genes);
    }
    public Genome(String genes){
        this.genes = genes;
        tree = new Tree(genes);
    }
    public String getGenes(){
        return genes;
    }
    public void printTree(){
        tree.printTree(tree.root,0);
    }
    public void evaluate(){
        //sets the fitness
        //System.out.println(getGenes());
        int uncoloredVerticies = 0;
        fitness = 0;
        ArrayList<int[]> graphColors = tree.run();
        for(int[] graphColorList: graphColors){
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < graphColorList.length; i++) {//minus points for uncolored nodes
                if (graphColorList[i]==0){
                    fitness+=50;
                    uncoloredVerticies++;
                }else{
                    set.add(graphColorList[i]);
                }
            }
            fitness+=set.size()*10;
        }
        //System.out.println("Uncolored Verticies: "+uncoloredVerticies);
    }


    public int getFitness(){
        return fitness;
    }

    @Override
    public int compareTo(Object o) {
        return getFitness()-((Genome)o).getFitness();
    }
}
