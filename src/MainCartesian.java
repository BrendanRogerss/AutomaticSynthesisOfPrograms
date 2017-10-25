import Cartesian.CartesianNode;
import Cartesian.Genotype;
import Evolution.Tree;
import Graph.Graph;
import Graph.Scanner;

import java.util.Random;

/**
 * Created by Brendan on 16/10/2017.
 */
public class MainCartesian {



    public int mutateChance = 10;
    Random r = new Random();

    private Scanner scanner = new Scanner("Data");


    public static void main(String[] args) {
        MainCartesian m = new MainCartesian();
        m.run();
    }

    public void run(){
        Tree.graphs = scanner.read();
        MainGeneral.printMinimalColor();
        Genotype champion = new Genotype();
        //champion.printGenes();
        //System.out.println(champion.toString());
        champion.evaluate();
        System.out.println(champion.getFitness());
        Genotype child = new Genotype(mutate(champion));
        child.evaluate();

        //for (int i = 0; i < 1000; i++) {
        while(true){
            if(child.getFitness()<=champion.getFitness()){

                if(child.getFitness()<champion.getFitness()){
                    System.out.println(child.getFitness());
                    child.soutGenes();
                }

                champion = child;
            }
            child = new Genotype(mutate(champion));
            child.evaluate();
            //System.out.println(child.getFitness());
        }
    }

    public int[][] mutate(Genotype parent){
        int[][] child = parent.genes.clone();
        for (int i = 0; i < child.length; i++) {
            if(r.nextInt(100)<mutateChance){ //mutate the gene
                switch (r.nextInt(3)){
                    case 0:
                        child[i][0] = i==0?0:r.nextInt(i);
                        break;
                    case 1:
                        child[i][1] = (i+Genotype.maxLookBack>Genotype.size)?r.nextInt(Genotype.size):r.nextInt(i+Genotype.maxLookBack);
                        break;
                    case 2:
                        child[i][2] = r.nextInt(Genotype.numOfFunctions);
                }
            }
        }
        return child;
    }

}
