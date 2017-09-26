package Evolution;

import java.util.Random;

/**
 * Created by Brendan on 26/09/2017.
 */
public class Genome {

    private int size = 160;
    private String genes = "";
    private Tree tree;
    private float fitness;

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
    }
    public void printTree(){
        tree.printTree(tree.root,0);
    }

}
