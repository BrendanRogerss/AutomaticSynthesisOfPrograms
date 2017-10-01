package Functions.Control;

import Functions.Function;

/**
 * Created by Brendan on 9/09/2017.
 */
public class And extends Function {

    public int getInputs() {
        return 2;
    }

    public boolean run() {
        if(left==null || right==null){
            return false;
        }

        return (left.run() && right.run());
    }

}
