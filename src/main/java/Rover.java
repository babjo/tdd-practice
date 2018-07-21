import java.util.Optional;

public class Rover {

    private Grid grid;

    private Coordinate coordinate = new Coordinate(0, 0);
    private Direction direction = Direction.NORTH;

    Rover(Grid grid) {
        this.grid = grid;
    }

    String execute(String commands) {
        String obstacleString = "";
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                direction = direction.right();
            }
            if (c == 'L') {
                direction = direction.left();
            }
            if (c == 'M') {
                obstacleString = move();
            }
        }
        return obstacleString + coordinate.x() + ":" + coordinate.y() + ":" + direction.value();
    }

    private String move() {
        Optional<Coordinate> nextCoordinate = grid.nextCoordinate(coordinate, direction);
        nextCoordinate.ifPresent(nc -> this.coordinate = nc);
        return nextCoordinate.isPresent() ? "" : "O:";
    }

}
