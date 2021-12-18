package solver;

import java.util.List;

public class Day1a implements ProblemSolver{
    @Override
    public int solve(List<String> inputs) {
        int increased=0;
        for (int i = 1; i < inputs.size(); i++) {
            if (Integer.parseInt(inputs.get(i - 1)) < Integer.parseInt(inputs.get(i))) {
                increased++;
            }
        }
        return increased;
    }
}
