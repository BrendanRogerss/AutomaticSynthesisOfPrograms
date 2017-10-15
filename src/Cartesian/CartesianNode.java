package Cartesian;

import Functions.Function;

import java.util.ArrayList;

/**
 * Created by Brendan on 14/10/2017.
 */
public class CartesianNode {

    private CartesianNode inputA;
    private CartesianNode inputB;
    private ArrayList<CartesianNode> outputs = new ArrayList<>();
    private Function f;
    public boolean isActive = false;

    public CartesianNode(){

    }

    public CartesianNode(Function f){
        this.f = f;
    }

    public CartesianNode(Function f, CartesianNode a, CartesianNode b){
        this.f = f;
        inputA = a;
        inputB = b;
    }

    public void setInupts(CartesianNode a, CartesianNode b){
        inputA = a;
        inputB = b;
    }

}
