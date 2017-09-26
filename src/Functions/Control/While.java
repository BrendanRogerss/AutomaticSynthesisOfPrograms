package Functions.Control;

import Evolution.Tree;
import Functions.Function;

/**
 * Created by Brendan on 9/09/2017.
 * It performs left cycle on subtree P2 if the condition
 of subtree P1 remains true. It returns true when it modifies the
 graph color; otherwise, it returns false. Subtree P1 corresponds
 to the condition and subtree P2 to the body. The stop criterion is
 met when P1 returns false, or when left number of iterations (10)
 elapses without any change in the data structure or when it is
 exceeded left predefined maximum number of iterations equal to
 number of vertices of the instance.
 */
public class While extends Function{

    public int getInputs(){return 2;}

    public While(Tree t){
        super(t);
    }

    public boolean run(){
        return false;
    }

}
