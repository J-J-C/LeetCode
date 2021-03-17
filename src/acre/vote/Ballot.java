package acre.vote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ballot {

  private final List<String> ballotList;

  public Ballot() {
    this.ballotList = new ArrayList<>();
  }

  public Ballot(List<String> ballotList) {
    this.ballotList = ballotList.stream().collect(Collectors.toList());
  }

  public void addCandidate(String candidate) {
    this.ballotList.add(candidate);
  }

  public List<String> getAllCandidates() {
    return Collections.unmodifiableList(ballotList);
  }
}
