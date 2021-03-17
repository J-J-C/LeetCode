package acre.zendo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestRule {

    private Set<Color> colorSet;
    private Set<Size> sizeSet;
    private List<Piece> pieceList;

    @Before
    public void setUp() {
        colorSet = new HashSet<>();
        sizeSet = new HashSet<>();
        pieceList = new ArrayList<>();
    }

    @Test
    public void testGame1() {
        pieceList.add(new Piece(Size.LARGE, Color.RED));
        colorSet.add(Color.RED);
        sizeSet.add(Size.LARGE);

        Rule rule = new Rule(colorSet, sizeSet, true, false, false, 1);

        boolean gameResult = Game.playGame(pieceList, rule);
        assertEquals(gameResult, true);
    }

    @Test
    public void testGame2() {
        pieceList.add(new Piece(Size.LARGE, Color.RED));
        pieceList.add(new Piece(Size.LARGE, Color.RED));
        colorSet.add(Color.RED);
        sizeSet.add(Size.LARGE);

        Rule rule = new Rule(colorSet, sizeSet, true, false, false, 1);

        boolean gameResult = Game.playGame(pieceList, rule);
        assertEquals(gameResult, false);
    }


    @Test
    public void testGame3() {
        pieceList.add(new Piece(Size.SMALL, Color.BLUE));
        pieceList.add(new Piece(Size.SMALL, Color.BLUE));
        pieceList.add(new Piece(Size.SMALL, Color.RED));

        colorSet.add(Color.BLUE);
        sizeSet.add(Size.SMALL);

        Rule rule = new Rule(colorSet, sizeSet, false, false, true, 3);

        boolean gameResult = Game.playGame(pieceList, rule);
        assertEquals(gameResult, true);
    }


    @Test
    public void testGame4() {
        pieceList.add(new Piece(Size.MEDIUM, Color.GREEN));
        pieceList.add(new Piece(Size.SMALL, Color.BLUE));

        colorSet.add(Color.BLUE);
        colorSet.add(Color.RED);
        colorSet.add(Color.GREEN);
        sizeSet.add(Size.MEDIUM);


        Rule rule = new Rule(colorSet, sizeSet, false, true, false, 1);

        boolean gameResult = Game.playGame(pieceList, rule);
        assertEquals(gameResult, true);
    }

    @Test
    public void testGame5() {
        pieceList.add(new Piece(Size.MEDIUM, Color.GREEN));
        pieceList.add(new Piece(Size.SMALL, Color.GREEN));
        pieceList.add(new Piece(Size.LARGE, Color.BLUE));

//    colorSet.add( Color.GREEN);
//    colorSet.add( Color.BLUE);
        colorSet.add(Color.RED);

        sizeSet.add(Size.MEDIUM);
        sizeSet.add(Size.LARGE);
        sizeSet.add(Size.SMALL);


        Rule rule = new Rule(colorSet, sizeSet, true, false, false, 2);

        rule.setCheckColorContains(false);

        boolean gameResult = Game.playGame(pieceList, rule);
        assertEquals(gameResult, false);
    }
}
