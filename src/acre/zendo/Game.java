package acre.zendo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {

  // we can also evaluate list of rules if rules are getting complicated
  public static boolean playGame(List<Piece> pieces, Rule rule) {
    // step 1: check color satisfaction
    List<Piece> qualifiedPieces1 =
            getColorQualifiedPieces(pieces, rule.getColorRequirements(), rule.isCheckColorContains());
    qualifiedPieces1.forEach(p -> System.out.println(p));
    System.out.println(qualifiedPieces1.size());
    // step 2: check size satisfaction
    qualifiedPieces1 =
            getSizeQualifiedPieces(
                    qualifiedPieces1, rule.getSizeRequirements(), rule.isCheckSizeContains());
    qualifiedPieces1.forEach(p -> System.out.println(p));
    System.out.println(qualifiedPieces1.size());
    // step 3: check count satisfaction
    if (rule.isExact()) {
      return qualifiedPieces1.size() == rule.getExpectedCount();
    }

    if (rule.isAtLeast()) {
      return qualifiedPieces1.size() >= rule.getExpectedCount();
    }
    if (rule.isAtMost()) {
      return qualifiedPieces1.size() <= rule.getExpectedCount();
    }

    return false;
  }

  // this should also be tested
  private static List<Piece> getColorQualifiedPieces(
          List<Piece> pieces, Set<Color> expectedColors, boolean isCheckingContains) {
    if (isCheckingContains) {
      return pieces.stream()
              .filter(p -> expectedColors.contains(p.getColor()))
              .collect(Collectors.toList());
    } else {
      return pieces.stream()
              .filter(p -> !expectedColors.contains(p.getColor()))
              .collect(Collectors.toList());
    }

  }

  // this should also be tested
  private static List<Piece> getSizeQualifiedPieces(
          List<Piece> pieces, Set<Size> expectedSizes, boolean isCheckingContains) {

    if (isCheckingContains) {
      return pieces.stream()
              .filter(p -> expectedSizes.contains(p.getSize()) && isCheckingContains)
              .collect(Collectors.toList());
    } else {
      return pieces.stream()
              .filter(p ->
                      !expectedSizes.contains(p.getSize()) && isCheckingContains)
              .collect(Collectors.toList());
    }
  }
}
