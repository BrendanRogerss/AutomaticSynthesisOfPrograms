import Evolution.Genome;
import Evolution.Mutator;
import Evolution.Tree;
import Graph.Graph;
import Graph.Scanner;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Brendan on 8/09/2017.
 */
public class MainGeneral {
    //1167
    //0100100111010001000100111100110100100010010100001100010111110000100010101001010111001010011111111000011000001100111110000011001101110010111111111101101111010101


    private Scanner scanner = new Scanner("Data");
    private int populationSize = 100;
    private Mutator mutator = new Mutator();

    public static void main(String[] args) {
        MainGeneral m = new MainGeneral();
        m.run();

    }

    private void run(){
        Tree.graphs = scanner.read();
        printMinimalColor();


        //Genome g = new Genome("11111000000001001111");//greedy binary
        Genome g = new Genome("10000000000001101000");//greedy gray code
        //Genome g = new Genome("1000010001000110100011010000111010111011010010111111001100000101010101010110100110101000001000010011111110000100101000011100010100101011111001001100000000100010");
        g.evaluate();
        System.out.println(g.getFitness());
        g.printTree();

        evolve();

    }

    private ArrayList<Genome> newPopulation(Genome champion){
        ArrayList<Genome> newPop = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            newPop.add(new Genome(mutator.mutate(champion.getGenes())));
        }
        return newPop;
    }

    public void evolve(){
        ArrayList<Genome> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Genome());
        }
        Genome highestFitness;
        population.forEach(Genome::evaluate);
        Collections.sort(population);
        highestFitness=population.get(0);
        int lastImprovement = 0;
        do {
            //population = newPopulation(population.get(0));
            population = mutator.newPopulation(population);
            population.forEach(Genome::evaluate);
            Collections.sort(population);
            if (population.get(0).getFitness() < highestFitness.getFitness()) {
                highestFitness = population.get(0);
                lastImprovement = 0;
                System.out.println(population.get(0).getFitness());
                System.out.println(population.get(0).getGenes());
                population.get(0).printTree();
            } else {
                lastImprovement++;
            }


        }while(lastImprovement!=10000);
        //}while(population.get(0).getFitness()<=860);
        System.out.println(highestFitness.getGenes());
        System.out.println(highestFitness.getFitness());
        population.get(0).printTree();
    }


    public static void printMinimalColor(){
        int v = 0;
        for(Graph g : Tree.graphs){
            v+=g.minimalColor;
        }
        System.out.println("minimal: "+v);
    }
}
