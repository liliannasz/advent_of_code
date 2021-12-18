package solver;

import java.util.List;

public class Day1b implements ProblemSolver{
    @Override
    public int solve(List<String> inputs) {
        int increased = 0;
        for (int i = 3; i < inputs.size(); i++) {
            var before = Integer.parseInt(inputs.get(i - 3));
            var now = Integer.parseInt(inputs.get(i));
            if (before < now) {
                increased++;
            }
        }
        return increased;
    }
}
