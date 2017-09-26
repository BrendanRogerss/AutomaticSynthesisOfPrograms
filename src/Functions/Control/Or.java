package Functions.Control;

import Functions.Function;

/**
 * Created by Brendan on 9/09/2017.
 */
public class Or extends Function {

    public int getInputs(){return 2;}

    public boolean run(){
        return(left.run() || right.run());
    }
}
