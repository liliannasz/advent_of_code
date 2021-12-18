import solver.*;

import java.util.HashMap;

public class Main {

    public static void main(String[] args){
        var inputLoader = new InputDownLoader();
        var solvers = new HashMap<String, ProblemSolver>();
        solvers.put("1a", new Day1a());
        solvers.put("1b", new Day1b());
        solvers.put("2a", new Day2a());
        solvers.put("2b", new Day2b());
        solvers.put("3a", new Day3a());
        solvers.put("3b", new Day3b());
        var menuManager = new MenuManager(solvers, inputLoader);
        menuManager.HandleMenu();
    }

}
