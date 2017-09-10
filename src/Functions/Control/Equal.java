package Functions.Control;

import Functions.Function;

/**
 * Created by Brendan on 9/09/2017.
 */
public class Equal extends Function {
    public boolean run(){
        return(a.run() == b.run());
    }

}
