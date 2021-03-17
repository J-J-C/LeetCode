package acre.vote;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestVoting {

    private Voting voting;

    @Before
    public void setUp() {
        voting = new Voting();
    }

    @Test
    public void testCountBallots_OneBallotOneCandidate() {
        Ballot ballot = new Ballot();
        ballot.addCandidate("A");

        voting.countBallot(ballot);
        assertEquals(3, voting.getPoints("A"));
    }

    @Test
    public void testCountBallots_OneBallotMultipleCandidate() {
        Ballot ballot = new Ballot();
        ballot.addCandidate("A");
        ballot.addCandidate("B");
        ballot.addCandidate("C");
        ballot.addCandidate("D");

        voting.countBallot(ballot);
        assertEquals(3, voting.getPoints("A"));
        assertEquals(2, voting.getPoints("B"));
        assertEquals(1, voting.getPoints("C"));
        assertEquals(0, voting.getPoints("D"));
    }

    @Test
    public void testCountBallots_MultipleBallotMultipleCandidate() {
        Ballot ballot1 = new Ballot();
        ballot1.addCandidate("A");
        ballot1.addCandidate("B");
        ballot1.addCandidate("C");
        ballot1.addCandidate("D");

        Ballot ballot2 = new Ballot();
        ballot2.addCandidate("B");
        ballot2.addCandidate("A");
        ballot2.addCandidate("D");
        ballot2.addCandidate("C");

        voting.countBallot(ballot1);
        voting.countBallot(ballot2);

        assertEquals(5, voting.getPoints("A"));
        assertEquals(5, voting.getPoints("B"));
        assertEquals(1, voting.getPoints("C"));
        assertEquals(1, voting.getPoints("D"));
    }

    @Test
    public void testGetTopCandidate_OneBallot_noTie() {
        Ballot ballot1 = new Ballot();
        ballot1.addCandidate("A");
        ballot1.addCandidate("B");
        ballot1.addCandidate("C");
        ballot1.addCandidate("D");

        voting.countBallot(ballot1);

        assertEquals(1, voting.getTopCandidates().size());
        assertEquals("A", voting.getTopCandidates().get(0));
    }

    @Test
    public void testGetTopCandidate_MultipleBallot_noTie() {
        Ballot ballot1 = new Ballot();
        ballot1.addCandidate("A");
        ballot1.addCandidate("B");
        ballot1.addCandidate("C");
        ballot1.addCandidate("D");

        Ballot ballot2 = new Ballot();
        ballot2.addCandidate("A");
        ballot2.addCandidate("C");
        ballot2.addCandidate("D");
        ballot2.addCandidate("B");

        voting.countBallot(ballot1);
        voting.countBallot(ballot2);

        assertEquals(1, voting.getTopCandidates().size());
        assertEquals("A", voting.getTopCandidates().get(0));
    }

    @Test
    public void testGetTopCandidate_MultipleBallot_tie() {
        Ballot ballot1 = new Ballot();
        ballot1.addCandidate("A");
        ballot1.addCandidate("B");
        ballot1.addCandidate("C");
        ballot1.addCandidate("D");

        Ballot ballot2 = new Ballot();
        ballot2.addCandidate("B");
        ballot2.addCandidate("A");
        ballot2.addCandidate("D");
        ballot2.addCandidate("C");

        voting.countBallot(ballot1);
        voting.countBallot(ballot2);

        assertEquals(2, voting.getTopCandidates().size());
        String[] expected = {"A", "B"};
        String[] actual = voting.getTopCandidates().toArray(new String[0]);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);

    }
}
