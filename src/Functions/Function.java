package Functions;

import Evolution.Tree;
import Graph.Vertex;

/**
 * Created by Brendan on 9/09/2017.
 */
public class Function {

    public Function left;
    public Function right;
    public Tree t;

    public boolean run(){
        return false;
    }
    public Vertex search(){
        return null;
    }
    public Function(Tree t, Function left, Function right){
        this.left = left;
        this.right = right;
        this.t = t;
    }
    public Function(Tree t,Function left){
        this.left = left;
        this.t = t;
    }
    public Function(Tree t){this.t=t;}
    public Function(){}
    public void setFunctionLeft(Function a){this.left = a;}
    public void setFunctionRight(Function b){this.right = b;}
    public void setFuncrions(Function a, Function b){this.left = a;this.right = b;}
    public int getInputs(){
        return 0;
    }

}
