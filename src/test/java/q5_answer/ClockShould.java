package q5_answer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ClockShould {

    private Clock clock = new TastableClock();

    @Test
    void todayAsString() {
        assertThat(clock.todayAsString(), is("19/08/2018"));
    }

    class TastableClock extends Clock {
        @Override
        public LocalDate today() {
            return LocalDate.of(2018, 8, 19);
        }
    }
}