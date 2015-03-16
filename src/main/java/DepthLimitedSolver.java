import java.util.List;
import java.util.Stack;

/**
 * Created by maruf on 15/03/15.
 */

public class DepthLimitedSolver extends AbstractSolver{
    private Stack<State> stack = new Stack();
    private int depth;

    public List<State> solve(State initialState, int depth) {
        this.depth = depth;
        return super.solve(initialState);
    }
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
        if( (!stack.contains(s)) && (s.getDistance() < this.depth) )
            stack.push(s);
    }

    @Override
    protected void clearOpen() {
        stack.clear();
    }
}

