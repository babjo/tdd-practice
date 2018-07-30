package q1_answer;

import com.google.common.base.Objects;

class Coordinate {
    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Coordinate that = (Coordinate) o;
        return x == that.x &&
               y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }
}