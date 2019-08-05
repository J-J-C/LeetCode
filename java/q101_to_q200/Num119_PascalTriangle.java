package q101_to_q200;

import java.util.ArrayList;
import java.util.List;

public class Num119_PascalTriangle {

    public List<Integer> generate(int rowIndex) {
        List<Integer> previousRow = new ArrayList<>();
        previousRow.add(1);

        if (rowIndex == 0) {
            return previousRow;
        }
        previousRow.add(1);

        if (rowIndex == 1) {
            return previousRow;
        }
        while (rowIndex >= 2) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 0; i < previousRow.size() - 1; i++) {
                row.add(previousRow.get(i) + previousRow.get(i + 1));
            }
            row.add(1);
            rowIndex--;
            previousRow = row;
        }
        return previousRow;
    }
}
