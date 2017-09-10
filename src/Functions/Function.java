package Functions;

import Evolution.Tree;
import Graph.Graph;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 */
public class Function {

    public Function a;
    public Function b;
    public Graph g;

    public boolean run(){
        return false;
    }
    public Vertex search(){
        return null;
    }
    public Function(Tree t, Function a, Function b){
        this.a = a;
        this.b = b;
    }
    public Function(Tree t,Function a){
        this.a = a;
    }
    public Function(Tree t){}
    public Function(){}
    public int requiredInputs(){return 0;}
    public void setFunctionA(Function a){this.a = a;}
    public void setFunctionB(Function b){this.b = b;}

}
