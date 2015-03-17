import java.util.Stack;

/**
 * Created by maruf on 14/03/15.
 */
public class DepthFirstSearch extends AbstractSearch {

    private  int maxQueueSize = 0;

    private Stack<State> queue = new Stack();

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
        if(!queue.contains(s))
            queue.push(s);
        if (queue.size() > maxQueueSize)
            maxQueueSize = queue.size();
    }

    @Override
    protected void clearOpen() {
        queue.clear();
    }

    public int getQueueSize() {
        return maxQueueSize;
    }
}
