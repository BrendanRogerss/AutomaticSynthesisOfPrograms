package Graph;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Brendan on 8/09/2017.
 */
public class Scanner {

    private String directory;
    private ArrayList<Graph> graphs = new ArrayList<Graph>();

    public Scanner(String dName){
        directory = dName;
    }

    public ArrayList<Graph> read(){
        File dir = new File(directory);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                try (BufferedReader br = new BufferedReader(new FileReader(child))) {
                    String line;
                    String[] splited;
                    while ((line = br.readLine()) != null) {
                        splited = line.split("\\s+");
                        if(line.charAt(0)=='p'){
                            graphs.add(0,new Graph(Integer.parseInt(splited[2])));
                        }else if(line.charAt(0)=='e'){
                            graphs.get(0).add(Integer.parseInt(splited[1])-1, Integer.parseInt(splited[2])-1);
                        }else if(line.charAt(0)=='m'){
                            graphs.get(0).minimalColor = Integer.parseInt(splited[1]);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No directory exists");
        }

//        for (Graph g : graphs) {
//            g.removeLonelyVertex();
//        }
        
        return graphs;
    }

}
