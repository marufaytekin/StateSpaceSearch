import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by maruf on 14/03/15.
 */
public class BreadthFirstSearch extends AbstractSearch {
    private Queue<State> queue = new LinkedList();

    private  int maxQueueSize = 0;

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
