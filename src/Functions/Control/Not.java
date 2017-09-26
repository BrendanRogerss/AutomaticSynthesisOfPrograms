package Functions.Control;

import Functions.Function;

/**
 * Created by Brendan on 9/09/2017.
 */
public class Not extends Function {

    public int getInputs(){return 1;}

    public boolean run(){
        return(!left.run());
    }
}
