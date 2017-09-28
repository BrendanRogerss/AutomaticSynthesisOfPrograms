import Evolution.Genome;
import Evolution.Tree;
import Graph.Graph;
import Graph.Scanner;

import java.util.ArrayList;

/**
 * Created by Brendan on 8/09/2017.
 */
public class Main {

    private Scanner scanner = new Scanner("testData");

    public static void main(String[] args) {
        Main m = new Main();
        m.run();

    }

    private void run(){
        Tree.graphs = scanner.read();
        Genome g = new Genome();
        g.printTree();
    }

}
