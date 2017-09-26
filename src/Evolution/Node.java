package Evolution;

import Functions.Function;

/**
 * Created by Brendan on 26/09/2017.
 */
public class Node {

    private Function function;
    private Node left = null;
    private Node right = null;

    public Node(Function f){
        setFunction(f);
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String toString(){
        return function.getClass().getSimpleName();
    }


}
