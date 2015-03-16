import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by maruf on 16/03/15.
 */
public class GreedyBFSolver extends AbstractSolver {

    private PriorityQueue<State> queue = null;

    public GreedyBFSolver() {
        queue = new PriorityQueue<State>(100000, new Comparator<State>() {
            public int compare(State s1, State s2) {
                //f(x) = distance + heuristic
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
    }

    @Override
    protected void clearOpen() {
        queue.clear();

    }
}
