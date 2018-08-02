package q3_answer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void canCreate() {
        game = new Game();
    }

    @Test
    void canRoll() {
        game.roll(0);
    }

    private void rollMany(int pins, int frames) {
        for (int i = 0; i < frames; i++) {
            game.roll(pins);
        }
    }

    @Test
    void gutterGame() {
        rollMany(0, 20);
        assertThat(game.getScore(), is(0));
    }

    @Test
    void allOnes() {
        rollMany(1, 20);
        assertThat(game.getScore(), is(20));
    }

    @Test
    void oneSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(0, 17);
        assertThat(game.getScore(), is(13 + 3));
    }

    @Test
    void twoSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        game.roll(7);
        game.roll(5);
        rollMany(0, 15);
        assertThat(game.getScore(), is(13 + 15 + 5));
    }

    @Test
    void oneStrike() {
        game.roll(10);
        game.roll(5);
        game.roll(3);
        rollMany(0, 16);
        assertThat(game.getScore(), is(10 + 5 + 3 + 5 + 3));
    }

    @Test
    void twoStrike() {
        game.roll(10);
        game.roll(10);
        game.roll(3);
        game.roll(5);
        rollMany(0, 14);
        assertThat(game.getScore(), is(10 + 10 + 3 + 10 + 3 + 5 + 3 + 5));
    }

    @Test
    void oneSpareAndOneStrike() {
        game.roll(5);
        game.roll(5);
        game.roll(10);
        game.roll(3);
        game.roll(5);
        rollMany(0, 14);
        assertThat(game.getScore(), is(5 + 5 + 10 + 10 + 3 + 5 + 3 + 5));
    }

    @Test
    void perfectGame() {
        rollMany(10, 10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        assertThat(game.getScore(), is(300));
    }

}
