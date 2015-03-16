import java.util.Stack;

/**
 * Created by maruf on 14/03/15.
 */
public class DepthFirstSolver extends AbstractSolver{
    private Stack<State> stack = new Stack();

    @Override
    protected boolean hasElements() {
        return !stack.isEmpty();
    }

    @Override
    protected State nextState() {
        return stack.pop();
    }

    @Override
    protected void addState(State s) {
        if(!stack.contains(s))
            stack.push(s);
    }

    @Override
    protected void clearOpen() {
        stack.clear();
    }
}
