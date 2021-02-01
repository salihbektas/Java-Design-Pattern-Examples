import java.util.ArrayList;

public interface SolveMethod {
    ArrayList<Character> variables = new ArrayList<Character>();
    ArrayList<ArrayList<Double>> coefficient = new ArrayList<ArrayList<Double>>();

    void readFile();
    void solve();
}
