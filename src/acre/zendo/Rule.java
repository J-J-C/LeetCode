package acre.zendo;

import java.util.Set;

public class Rule {


    private final Set<Color> colorRequirements;
    private final Set<Size> sizeRequirements;

    boolean checkColorContains = true;
    boolean checkSizeContains = true;

    private final boolean isExact;
    private final boolean isAtLeast;
    private final boolean isAtMost;

    private final int expectedCount;

    public Rule(Set<Color> colorRequirements, Set<Size> sizeRequirements, boolean isExact, boolean isAtLeast, boolean isAtMost, int expectedCount) {
        this.colorRequirements = colorRequirements;
        this.sizeRequirements = sizeRequirements;
        this.isExact = isExact;
        this.isAtLeast = isAtLeast;
        this.isAtMost = isAtMost;
        this.expectedCount = expectedCount;
    }

    public boolean isCheckColorContains() {
        return checkColorContains;
    }

    public void setCheckColorContains(boolean checkColorContains) {
        this.checkColorContains = checkColorContains;
    }

    public boolean isCheckSizeContains() {
        return checkSizeContains;
    }

    public void setCheckSizeContains(boolean checkSizeContains) {
        this.checkSizeContains = checkSizeContains;
    }

    public Set<Color> getColorRequirements() {
        return colorRequirements;
    }

    public Set<Size> getSizeRequirements() {
        return sizeRequirements;
    }

    public boolean isExact() {
        return isExact;
    }

    public boolean isAtLeast() {
        return isAtLeast;
    }

    public boolean isAtMost() {
        return isAtMost;
    }

    public int getExpectedCount() {
        return expectedCount;
    }


}
