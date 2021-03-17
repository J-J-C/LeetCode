package acre.station;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestStation {


    @Test
    public void testVisit() {

        String[] stationArray = {"A", "B", "C", "D"};
        Station station = new Station(Arrays.asList(stationArray));

        assertEquals("A", station.visitNext());
        assertEquals("B", station.visitNext());
        assertEquals("C", station.visitNext());
        assertEquals("D", station.visitNext());
        assertEquals("A", station.visitNext());
        assertEquals("B", station.visitNext());
    }

}
