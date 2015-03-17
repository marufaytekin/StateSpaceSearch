import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by maruf on 16/03/15.
 */
public class GreedySearch extends AbstractSearch {

    private PriorityQueue<State> queue = null;

    private  int maxQueueSize = 0;

    public GreedySearch() {
        queue = new PriorityQueue<State>(1, new Comparator<State>() {
            public int compare(State s1, State s2) {
                return Double.compare(
                        s1.getHeuristic(),
                        s2.getHeuristic());
            }
        });
    }

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
        return maxQueueSize;
    }
}
