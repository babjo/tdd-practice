package q1_answer;

enum Direction {
    NORTH("N", "W", "E"),
    EAST("E", "N", "S"),
    SOUTH("S", "E", "W"),
    WEST("W", "S", "N");

    private final String value;
    private final String left;
    private final String right;

    Direction(String value, String left, String right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Direction right() {
        return directionMatching(right);
    }

    public Direction left() {
        return directionMatching(left);
    }

    private Direction directionMatching(String value) {
        for (Direction direction : values()) {
            if (direction.value == value) { return direction; }
        }
        return null;
    }

    public String value() {
        return value;
    }
}