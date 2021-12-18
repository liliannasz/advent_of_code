import solver.ProblemSolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class MenuManager {

    private final Map<String, ProblemSolver> solvers;
    private final InputLoader inputLoader;

    public MenuManager(Map<String, ProblemSolver> solvers, InputLoader inputLoader) {
        this.solvers = solvers;
        this.inputLoader = inputLoader;
    }

    public void HandleMenu(){
        var quit = false;
        while(!quit) {
            displayMenu();
            var input = handleInput();
            quit = input.equals("q");
            var solver = solvers.get(input);
            if (solver != null) {
                var problemInput = inputLoader.loadInputFromSource(input.substring(0, input.length() -1));
                var solution = solver.solve(problemInput);
                System.out.println(solution);
            }
        }
    }

    private String handleInput() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch ( IOException e) {
            System.out.println("Input was not a number!");
        }
        System.out.println("Solutions is not yet implemented, please enter a valid number!");
        return "";
    }

    private void displayMenu() {
        solvers.forEach((key, value) -> System.out.println(key));
        System.out.println("Quit: q");
    }

}
