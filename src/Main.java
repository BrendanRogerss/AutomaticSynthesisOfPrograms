import Evolution.Genome;
import Graph.Graph;
import Graph.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Brendan on 8/09/2017.
 */
public class Main {

    Scanner scanner = new Scanner("Data");
    private ArrayList<Graph> graphs;

    public static void main(String[] args) {
        Main m = new Main();
        m.run();

    }

    private void run(){
        //graphs = scanner.read()
        Genome g = new Genome();
        g.printTree();
    }

}
