package acre.station;

import java.util.List;

/**
 * 第一轮coding：
 * 车站问题。给你一个list，list里面装的是车站的站名，然后让你写一个method，call一次到一个站，call一次到一个站，到终点站了就从头来过，每call一次把这个站名print出来。
 * 实在抱歉，后面还有2个follow up, 但我不太记得了，为了不误导大家，我就不写了。但大致的意思就是一个method要求你用独立的class，
 * 然后每一个follow up都是继承上一个class，然后调用上一个method。我感觉主要是考你code structure为主，个人感觉这一问不难。
 */
public class Station {

    List<String> stationNames;
    int currentIndex = -1;

    public Station(List<String> stationNames) {
        this.stationNames = stationNames;
    }

    public String visitNext() {
        // move to next
        currentIndex++;
        if (currentIndex == stationNames.size()) {
            currentIndex = 0;
        }
        String currentStation = stationNames.get(currentIndex);
        System.out.println(currentStation);

        return currentStation;
    }
}
