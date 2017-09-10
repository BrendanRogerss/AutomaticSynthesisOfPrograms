package Functions.Control;

import Functions.Function;

/**
 * Created by Brendan on 9/09/2017.
 * : It executes subtree P2 if subtree P1 has a true value. It
 returns a true value if executing the second argument is
 feasible (regardless of its return); otherwise, it returns false
 */
public class If extends Function {
    public boolean run(){
        if(a.run()){
            b.run();
            return true;
        }
        return false;
    }
}
