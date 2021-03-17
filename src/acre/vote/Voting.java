package acre.vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Voting {

    public static void main(String[] args) {
        //
    }

    Map<String, Integer> candidateVoteMap = new HashMap<>();
    final static Map<Integer, Integer> rankPointsMap = new HashMap<>();

    static {
        rankPointsMap.put(0, 3);
        rankPointsMap.put(1, 2);
        rankPointsMap.put(2, 1);
    }

    public void countBallot(Ballot ballot) {
        countBallot(ballot.getAllCandidates());
    }

    private void countBallot(List<String> candidates) {

        for (int i = 0; i < candidates.size(); i++) {
            String candidate = candidates.get(i);
            int points = rankPointsMap.getOrDefault(i, 0);
            if (points > 0) {
                if (candidateVoteMap.containsKey(candidate)) {
                    candidateVoteMap.put(candidate, candidateVoteMap.get(candidate) + points);
                } else {
                    candidateVoteMap.put(candidate, points);
                }
            }
        }
    }

    public void printFinalResult() {
    }

    public int getPoints(String candidate) {
        return candidateVoteMap.getOrDefault(candidate, 0);
    }

    public List<String> getTopCandidates() {
        int max = 0;
        List<String> topCandidates = new ArrayList<>();
        for (String candidate : candidateVoteMap.keySet()) {
            if (candidateVoteMap.get(candidate) > max) {
                topCandidates.clear();
                max = candidateVoteMap.get(candidate);
                topCandidates.add(candidate);
            } else if (candidateVoteMap.get(candidate) == max) {
                topCandidates.add(candidate);
            }
        }
        return topCandidates;
    }
}
