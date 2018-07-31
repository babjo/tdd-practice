package q2_answer;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class PrimeFactorsTest {

    @Test
    void get() {
        assertThat(PrimeFactors.of(1), is(asList()));
        assertThat(PrimeFactors.of(2), is(asList(2)));
        assertThat(PrimeFactors.of(3), is(asList(3)));
        assertThat(PrimeFactors.of(4), is(asList(2, 2)));
        assertThat(PrimeFactors.of(6), is(asList(2, 3)));
        assertThat(PrimeFactors.of(8), is(asList(2, 2, 2)));
        assertThat(PrimeFactors.of(9), is(asList(3, 3)));
        assertThat(PrimeFactors.of(2 * 2 * 2 * 3 * 3 * 5 * 7 * 11 * 13),
                   is(asList(2, 2, 2, 3, 3, 5, 7, 11, 13)));
    }
}
