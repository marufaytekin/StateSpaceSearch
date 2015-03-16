import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by maruf on 16/03/15.
 */
public class GreedySolver extends AbstractSolver {

    private PriorityQueue<State> queue = null;

    public GreedySolver() {
        queue = new PriorityQueue<State>(1, new Comparator<State>() {
            public int compare(State s1, State s2) {
                return Double.compare(
                        s1.getDistance() + s1.getHeuristic(),
                        s2.getDistance() + s2.getHeuristic());
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
    }

    @Override
    protected void clearOpen() {
        queue.clear();
    }

    public int getQueueSize() {
        return queue.size();
    }
}
