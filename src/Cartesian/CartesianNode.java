package Cartesian;

import Functions.Function;

import java.util.ArrayList;

/**
 * Created by Brendan on 14/10/2017.
 */
public class CartesianNode implements Comparable{

    public int index;
    private CartesianNode inputA;
    private CartesianNode inputB;
    private ArrayList<CartesianNode> outputs = new ArrayList<>();
    private Function f;
    public boolean isActive = false;

    public CartesianNode(){

    }

    public CartesianNode(Function f, int i){
        this.f = f;index = i;
    }

    public CartesianNode(Function f, CartesianNode a, CartesianNode b){
        this.f = f;
        inputA = a;
        inputB = b;
    }

    public boolean run(){
        //System.out.println(index);
        if(f!=null){
            return f.run();
        }else{
            if(index!=0)System.out.println("null function");
            return false;
        }

        //need to order the nodes and not run them more than once outside a loop
//        for(CartesianNode node : outputs){
//            if(node.index<index){
//                runLoop(node);
//            }else{
//                node.run();
//            }
//        }

//        for (int i = 0; i < outputs.size(); i++) {
//            CartesianNode node = outputs.remove(0);
//            node.run();
//        }

    }

    public void setInupts(CartesianNode a, CartesianNode b){
        inputA = a;
        a.addOutput(this);
        inputB = b;
        if(b!=null){
            b.addOutput(this);
            f.setFuncrions(a.getFunction(), b.getFunction());
            return;
        }
        f.setFunctionLeft(a.getFunction());
    }

    public void addOutput(CartesianNode out){
        if(!outputs.contains(out)){
            outputs.add(out);
        }else{
            System.out.println("0utput already exists");
        }
    }

    public ArrayList<CartesianNode> getOutputs(){
        return outputs;
    }

    public Function getFunction(){
        return f;
    }

    public String toString(){
        //return "output size: "+outputs.size();//+" "+f.getClass().getSimpleName();
        String output =(f!=null?f.getClass().getSimpleName():" ")+" Inputs: ";
        output+=inputA!=null?inputA.index+" ":"null ";
        output+=inputB!=null?inputB.index+" ":"null ";
        output+="Outputs: ";
        for (CartesianNode node : outputs) {
            output+=node.index+" ";
        }
        return output;
    }

    @Override
    public int compareTo(Object o) {
        return outputs.size()-((CartesianNode)o).outputs.size();
    }


}
