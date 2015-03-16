import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by maruf on 14/03/15.
 */
public class BreadthFirstSolver extends AbstractSolver{
    private Queue<State> queue = new LinkedList();

    @Override
    protected boolean hasElements() {
        return !queue.isEmpty();
    }

    @Override
    protected State nextState() {
        return queue.remove();
    }

    @Override
    protected void addState(State s) {
        if (!queue.contains(s))
            queue.add(s);
    }

    @Override
    protected void clearOpen() {
        queue.clear();
    }

    public int getQueueSize() {
        return queue.size();
    }
}
