package Evolution;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Brendan on 27/09/2017.
 */
public class Mutator {
    public int mutateChance = 3;
    private Random r = new Random();

    public String mutate(String gene){
        for (int i = 0; i < gene.length(); i++) {
            if(r.nextInt(100)<mutateChance){
                gene = gene.substring(0,i) + (gene.substring(i,i+1).equals("1")?"0":"1")+gene.substring(i+1);
            }
        }
        return gene;
    }

    public String onePointCrossover(int n, String geneA, String geneB){
        return geneA.substring(0,n)+geneB.substring(n);
    }

    public String nPointCrossover(String geneA, String geneB){
        String output = geneA;
        boolean a = true;
        for (int i = 0; i < geneA.length(); i++) {
            if(r.nextInt(100)<50){//flip
                if(a){
                    a = false;
                    output = onePointCrossover(i,output,geneB);
                }else{
                    a = true;
                    output = onePointCrossover(i,output,geneA);
                }
            }
        }
        return output;
    }

    public String twoPointCrossover(String geneA, String geneB){
        String output;
        int n1 = r.nextInt(100);
        int n2 = r.nextInt(100);

        if(r.nextInt(100)<50){
            output = onePointCrossover(n1<n2?n1:n2, geneA, geneB);
            output = onePointCrossover(n1<n2?n2:n1, output, geneA);

        }else{
            output = onePointCrossover(n1<n2?n1:n2, geneB, geneA);
            output = onePointCrossover(n1<n2?n2:n1, output, geneB);
        }

        return mutate(output);
    }

    public ArrayList<Genome> newPopulation(ArrayList<Genome> pop){
        int size = pop.size();
        ArrayList<Genome> newPop = new ArrayList<>();
        ArrayList<Genome> oldPop = new ArrayList<>();
        oldPop.add(pop.remove(0));
        for (int i = 1; i < 10; i++) {
           int n = r.nextInt(100);
            if(n < 20){
                //get one from bottom 30
                n = r.nextInt(20-i);
                oldPop.add(pop.remove(n+80));
            }else if(n<40){
                //get one between 30 and 70
                n = r.nextInt(60-i);
                oldPop.add(pop.remove(n+40));
            }else{
                //get 70+
                n = r.nextInt(40-i);
                oldPop.add(pop.remove(n));
            }
        }

        Genome temp;// = oldPop.remove(0);
        //newPop.add(temp);
        //while(newPop.size()!=size) {
        for (int i = 0; i < 10; i++) {
            temp = oldPop.get(i);
            //System.out.println("old: "+oldPop.size());
            //System.out.println("new: "+newPop.size());
            for (int j = 0; (j < 10); j++) {
                newPop.add(new Genome(twoPointCrossover(temp.getGenes(),oldPop.get(j).getGenes())));
            }
            //newPop.add(temp);

        }
        //System.out.println(newPop.size());
        return newPop;
    }
}
