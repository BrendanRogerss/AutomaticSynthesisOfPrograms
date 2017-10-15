package Cartesian;

import java.util.Random;

/**
 * Created by Brendan on 15/10/2017.
 */
public class Genotype {

    private final int size = 1000;
    private final int numOfFunctions = 18;
    private final int maxLookBack = 20;

    private Random random = new Random();
    private phenotype net;


    int[][] genes = new int[size][3]; //inputA, inputB, function

    public Genotype(int[][] inputGenes){
        genes = inputGenes;
    }

    public Genotype(){
        for (int i = 0; i < size; i++) {
            genes[i][0] = i<maxLookBack?random.nextInt(i):random.nextInt(i-20);
            genes[i][1] = i<maxLookBack?random.nextInt(i):random.nextInt(i-20);
            genes[i][2] = random.nextInt(numOfFunctions); //function cannot be 0
        }
    }

    public void initialise(){

    }

}
