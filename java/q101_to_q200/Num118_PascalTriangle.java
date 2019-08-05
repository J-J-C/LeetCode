package q101_to_q200;

import java.util.ArrayList;
import java.util.List;

public class Num118_PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0) {
            return list;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        list.add(firstRow);
        if(numRows == 1) {
            return list;
        }
        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1); secondRow.add(1);
        list.add(secondRow);

        int index = 1;
        List<Integer> previousRow = new ArrayList<>();
        previousRow.add(1);
        previousRow.add(1);
        if(numRows == 2) {
            return list;
        }
        while(numRows >= 3) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int i = 0; i < previousRow.size() - 1; i++) {
                row.add(previousRow.get(i) + previousRow.get(i+1));
            }
            row.add(1);
            list.add(row);
            numRows--;
            previousRow = row;
        }
        return list;
    }
}
