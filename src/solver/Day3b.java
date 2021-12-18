package solver;

import java.util.ArrayList;
import java.util.List;

public class Day3b implements ProblemSolver{

    @Override
    public int solve(List<String> inputs) {
        var oxygenGenerator = inputs;
        var co2Scrubber = inputs;
        int index=0;
        while(oxygenGenerator.size()>1){
            var tempOxy = new ArrayList<String>();
            var mostCommonBit = getMostCommon(oxygenGenerator,index);
            for (var line:oxygenGenerator) {
                if(line.charAt(index)==mostCommonBit){
                    tempOxy.add(line);
                }
            }
            oxygenGenerator=tempOxy;
            index++;
        }
        index=0;
        while(co2Scrubber.size()>1){
            var tempCO2 = new ArrayList<String>();
            var mostCommonBit = getMostCommon(co2Scrubber,index);
            for (var line:co2Scrubber) {
                if(line.charAt(index)!=mostCommonBit){
                    tempCO2.add(line);
                }
            }
            co2Scrubber = tempCO2;
            index++;
        }

        return convertToDecimal(co2Scrubber.get(0))*convertToDecimal(oxygenGenerator.get(0));
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

    private char getMostCommon(List<String> strings, int index){
        var onesInIndex = strings.stream()
                .filter(s -> s.charAt(index) == '1')
                .count();
        if(onesInIndex>= strings.size()/2.0){
            return '1';
        }
        return '0';
    }


}
