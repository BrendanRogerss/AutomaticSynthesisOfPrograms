package Cartesian;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by Brendan on 15/10/2017.
 */
public class Genotype {

    public static final int size = 300;
    public static final int numOfFunctions = 19;
    public static final int maxLookBack = 80;

    private Random random = new Random();
    private Phenotype net;
    private int fitness;


    public int[][] genes = new int[size][3]; //inputA, inputB, function

    public Genotype(int[][] inputGenes){
        genes = inputGenes;
        net = new Phenotype(genes);
    }

    public Genotype(){
        for (int i = 0; i < size; i++) {
            //needs to be redone
            genes[i][0] = i==0?0:random.nextInt(i);
            genes[i][1] = (i+maxLookBack>size)?random.nextInt(size):random.nextInt(i+maxLookBack);
            genes[i][2] = random.nextInt(numOfFunctions);
        }
        net = new Phenotype(genes);
    }

    public Genotype(String stringGenes){
        String[] splited = stringGenes.split("\\s+");
        for (int i = 0; i < genes.length; i++) {
            genes[i][0] = Integer.parseInt(splited[i*3]);
            genes[i][1] = Integer.parseInt(splited[i*3+1]);
            genes[i][2] = Integer.parseInt(splited[i*3+2]);
        }
        net = new Phenotype(genes);
    }

    public void evaluate(){
        //sets the fitness
        //System.out.println(getGenes());
        int uncoloredVerticies = 0;
        fitness = 0;
        ArrayList<int[]> graphColors = net.run();
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
            fitness+=set.size();
        }
        //System.out.println("Uncolored Verticies: "+uncoloredVerticies);
    }

    public String toString(){
        return net.toString();
    }

    public int getFitness(){
        return fitness;
    }

    public void printGenes(){
        for (int i = 0; i < genes.length; i++) {
            System.out.println(i+") "+genes[i][0]+" "+genes[i][1]+" "+genes[i][2]);
        }
    }

    public void soutGenes(){
        String output = "";
        for (int i = 0; i < genes.length; i++) {
            output+=genes[i][0]+" "+genes[i][1]+" "+genes[i][2]+" ";
        }
        System.out.println(output);
    }

}
