package solver;

import java.util.List;

public class Day3a implements ProblemSolver{

    @Override
    public int solve(List<String> inputs) {
              var gamma = "";
        var epsilon = "";
        for (int i = 0; i < inputs.get(0).length(); i++) {
            var numberOfOnes=0;
            for (var line : inputs) {
                    if(line.charAt(i)=='1'){
                        numberOfOnes++;
                    }
            }
            if(numberOfOnes > inputs.size()/2){
                gamma+="1";
                epsilon+="0";
            }
            else{
                gamma+="0";
                epsilon+="1";
            }
        }

        return convertToDecimal(gamma)*convertToDecimal(epsilon);
    }

    private int convertToDecimal(String binary){
        int value =0;
        for (int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i)=='1'){
                value += Math.pow(2,binary.length()-i-1);
            }
        }
        return value;
    }


}
