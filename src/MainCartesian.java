import Cartesian.CartesianNode;
import Cartesian.Genotype;
import Evolution.Tree;
import Graph.Scanner;

/**
 * Created by Brendan on 16/10/2017.
 */
public class MainCartesian {

    private Scanner scanner = new Scanner("testData");


    public static void main(String[] args) {
        MainCartesian m = new MainCartesian();
        m.run();
    }

    public void run(){
        Tree.graphs = scanner.read();

        Genotype genotype = new Genotype();
        genotype.evaluate();
        System.out.println(genotype.getFitness());
        //genotype.printGenes();
        //System.out.println(genotype.toString());
    }

}
