public class ChessPiece {
    private final String name;
    private final String color;

    public ChessPiece(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " " + name;
    }
}
