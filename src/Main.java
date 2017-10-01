import Evolution.Genome;
import Evolution.Mutator;
import Evolution.Tree;
import Graph.Graph;
import Graph.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Brendan on 8/09/2017.
 */
public class Main {

    private Scanner scanner = new Scanner("testData");
    private int populationSize = 100;
    private Mutator mutator = new Mutator();

    public static void main(String[] args) {
        Main m = new Main();
        m.run();

    }

    private void run(){
        Tree.graphs = scanner.read();
//        Genome g = new Genome("11111000000001001111");
//        g.evaluate();
//        System.out.println(g.getFitness());
//        g.printTree();



        ArrayList<Genome> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Genome());
        }
        Genome highestFitness = new Genome();
        highestFitness.evaluate();
        population.forEach(Genome::evaluate);
        Collections.sort(population);
        int lastImprovement = 0;
        do {
            population = newPopulation(population.get(0));
            population.forEach(Genome::evaluate);
            Collections.sort(population);
            if (population.get(0).getFitness() > highestFitness.getFitness()) {
                highestFitness = population.get(0);
                lastImprovement = 0;
            } else {
                lastImprovement++;
            }
            System.out.println(population.get(0).getFitness());

        }while(lastImprovement!=100);
        //}while(population.get(0).getFitness()<=550);
        System.out.println(highestFitness.getGenes());
        System.out.println(highestFitness.getFitness());
        population.get(0).printTree();



    }

    private ArrayList<Genome> newPopulation(Genome champion){
        ArrayList<Genome> newPop = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            newPop.add(new Genome(mutator.mutate(champion.getGenes())));
        }
        return newPop;
    }

}
