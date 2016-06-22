import java.util.*;

/**
 * Created by maruf on 15/03/15.
 */
public class PuzzleState extends AbstractState {

    private final int[][] blocks;
    private final int N;

    // construct a PuzzleState from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public PuzzleState(PuzzleState parent, int[][] blocks)  {
        super(parent);
        N = blocks.length;
        this.blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                this.blocks[i][j] = blocks[i][j];
    }

    @Override
    public Iterable<State> getPossibleMoves() {
        Set<State> moves = new HashSet();
        int blank_i = 0;
        int blank_j = 0;
        for (int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (this.blocks[i][j] == 0) {
                    blank_i = i;
                    blank_j = j;
                }
            }
        }
        if ((blank_i+1) < N) {
            int [][]temp = getCopy();
            temp[blank_i][blank_j] = temp[blank_i+1][blank_j];
            temp[blank_i+1][blank_j] = 0;
            moves.add(new PuzzleState(this, temp));
        }
        if ((blank_i-1) < N && (blank_i-1) >= 0) {
            int [][]temp = getCopy();
            temp[blank_i][blank_j] = temp[blank_i-1][blank_j];
            temp[blank_i-1][blank_j] = 0;
            moves.add(new PuzzleState(this, temp));
        }
        if ((blank_j+1) < N) {
            int [][]temp = getCopy();
            temp[blank_i][blank_j] = temp[blank_i][blank_j+1];
            temp[blank_i][blank_j+1] = 0;
            moves.add(new PuzzleState(this, temp));
        }
        if ((blank_j-1) < N && (blank_j-1) >= 0) {
            int [][]temp = getCopy();
            temp[blank_i][blank_j] = temp[blank_i][blank_j-1];
            temp[blank_i][blank_j-1] = 0;
            moves.add(new PuzzleState(this, temp));
        }
        return moves;
    }

    @Override
    public boolean isSolution() {
        int dist = this.manhattan();
        return dist == 0;
    }

    @Override
    public double getHeuristic() {
        return manhattan();
    }

    //Manhattan distances between this state and goal
    public int manhattan() {
        int dist_manhattan = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (blocks[i][j] != 0) {
                    int val = blocks[i][j];
                    int dist_vertical = Math.abs(((val-1) / N) - i);
                    int dist_horiz= Math.abs(((val-1) % N) - j);
                    dist_manhattan += dist_horiz + dist_vertical;
                }
        return dist_manhattan;
    }

    private int[][] getCopy(){
        int[][] result = new int[N][];
        for (int i=0; i<N; i++){
            result[i] = Arrays.copyOf(blocks[i], N);
        }
        return result;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(blocks[i][j]);
                s.append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public boolean equals(Object that) {
        if (that == this) return true;
        if (that == null) return false;
        if (that.getClass() != this.getClass()) return false;
        PuzzleState thatBoard = (PuzzleState)that;
        if (this.N != thatBoard.N) return false;
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (this.blocks[i][j] != thatBoard.blocks[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
