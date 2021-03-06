package q1_answer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverShould {
    /*
    Q1. Mars Rover Kata
    Develop an API that moves a rover around on a grid
    Rules:
    1. You are given the initial starting point (0, 0, N) of a rover.
    2. 0,0 are X, Y co-ordinates on a grid of (10, 10)
    3. N is the direction it is facing (i.e. N,S,E,W)
    4. L nad R allow the rover to rotate left and right.
    5. M allows the rover to move one point in the current direction.
    6. The rover receives a char array of commands e.g. RMMLM and returns the finishing point after the moves e.g. 2:1:N
    7. The rover wraps around if it reaches the end of the grid.
    8. The grid may have obstacles. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and reports the obstacle e.g. 0:2:2:N
    */

    private Rover rover;

    @BeforeEach
    void initialise() {
        Grid grid = new Grid();
        rover = new Rover(grid);
    }

    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N",
    })
    void rotate_right(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N",

    })
    void rotate_left(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "M, 0:1:N",
            "MMM, 0:3:N",
    })
    void move_up(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMMMMMM, 0:5:N"
    })
    void warp_from_top_to_bottom_when_moving_north(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "RM, 1:0:E",
            "RMMM, 3:0:E",
    })
    void move_right(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMMMMMM, 5:0:E",
    })
    void warp_from_left_to_right_when_moving_east(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "LM, 9:0:W",
            "LMMMMM, 5:0:W"
    })
    void move_left(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "LLM, 0:9:S",
            "LLMMMMM, 0:5:S",
    })
    void move_down(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @ParameterizedTest
    @CsvSource({
            "MMMM, O:0:3:N",
            "RMMMMMM, O:1:0:E",
    })
    void stop_at_obstacle(String commands, String position) {
        Coordinate obstacle_0x4 = new Coordinate(0, 4);
        Coordinate obstacle_2x0 = new Coordinate(2, 0);
        Grid grid = new Grid(Arrays.asList(obstacle_0x4, obstacle_2x0));
        Rover rover = new Rover(grid);

        assertThat(rover.execute(commands), is(position));
    }
}