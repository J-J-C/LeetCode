package acre.zendo;

public class Piece {

    private final Size size;
    private final Color color;

    public Piece(Size size, Color color) {
        this.size = size;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Piece{" + "size=" + size + ", color=" + color + '}';
    }
}
