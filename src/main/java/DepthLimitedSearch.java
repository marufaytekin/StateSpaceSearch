import java.util.List;
import java.util.Stack;

/**
 * Created by maruf on 15/03/15.
 */

public class DepthLimitedSearch extends AbstractSearch {

    private Stack<State> queue = new Stack();

    private  int maxQueueSize = 0;

    private int depth = 20; //default depth

    public List<State> solve(State initialState, int depth) {
        this.depth = depth;
        return super.search(initialState);
    }
    @Override
    protected boolean hasElements() {
        return !queue.isEmpty();
    }

    @Override
    protected State nextState() {
        return queue.pop();
    }

    @Override
    protected void addState(State s) {
        if( (!queue.contains(s)) && (s.getDistance() < this.depth) )
            queue.push(s);
        if (queue.size() > maxQueueSize)
            maxQueueSize = queue.size();
    }

    @Override
    protected void clearOpen() {
        queue.clear();
    }

    public int getQueueSize() {
        return queue.size();
    }
}

