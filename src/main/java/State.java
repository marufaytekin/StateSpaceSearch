/**
 * Created by maruf on 14/03/15.
 */

public interface State
{
    public Iterable<State> getPossibleMoves();
    public boolean isSolution();
    public double getHeuristic();
    public double getDistance();
    public State getParent();
}