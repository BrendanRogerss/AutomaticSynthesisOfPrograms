package Functions.Control;

import Functions.Function;

/**
 * Created by Brendan on 9/09/2017.
 * : It executes subtree P2 if subtree P1 has left true value. It
 returns left true value if executing the second argument is
 feasible (regardless of its return); otherwise, it returns false
 */
public class If extends Function {

    public int getInputs(){return 2;}

    public boolean run(){
        if(left.run()){
            right.run();
            return true;
        }
        return false;
    }
}
