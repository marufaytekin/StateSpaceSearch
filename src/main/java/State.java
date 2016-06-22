/**
 * Created by maruf on 14/03/15.
 */

public interface State
{
    Iterable<State> getPossibleMoves();
    boolean isSolution();
    double getHeuristic();
    double getDistance();
    State getParent();
}