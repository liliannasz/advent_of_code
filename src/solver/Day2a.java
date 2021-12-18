package solver;

import java.util.List;

public class Day2a implements ProblemSolver{
    @Override
    public int solve(List<String> inputs) {
        var horizontal=0;
        var depth = 0;
        for (var movement: inputs) {
            var line = movement.split(" ");
            switch (line[0]){
                case "forward":
                    horizontal+= Integer.parseInt(line[1]);
                    break;
                case "down":
                    depth+= Integer.parseInt(line[1]);
                    break;
                case "up":
                    depth-= Integer.parseInt(line[1]);
                    break;
            }
        }
        return horizontal*depth;
    }
}
