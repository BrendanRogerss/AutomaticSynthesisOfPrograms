package Evolution;

import java.util.Random;

/**
 * Created by Brendan on 27/09/2017.
 */
public class Mutator {
    private int mutateChance = 10;
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
}
