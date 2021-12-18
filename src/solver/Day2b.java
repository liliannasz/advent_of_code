package solver;

import java.util.List;

public class Day2b implements ProblemSolver{
    @Override
    public int solve(List<String> inputs) {
        var horizontal=0;
        var depth = 0;
        var aim=0;
        for (var movement: inputs) {
            var line = movement.split(" ");
            switch (line[0]){
                case "forward":
                    horizontal+= Integer.parseInt(line[1]);
                    depth += Integer.parseInt(line[1])*aim;
                    break;
                case "down":
                    aim += Integer.parseInt(line[1]);
                    break;
                case "up":
                    aim -= Integer.parseInt(line[1]);
                    break;
            }
        }
        return horizontal*depth;
    }
}
