package q5_answer;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.common.collect.ImmutableList;

@ExtendWith(MockitoExtension.class)
public class StatementPrinterShould {

    public static final List<Transaction> NO_TRANSACTIONS = asList();
    @Mock
    Console console;
    private StatementPrinter printer;

    @BeforeEach
    void setUp() {
        printer = new StatementPrinter(console);
    }

    @Test
    public void always_print_the_header() {
        printer.print(NO_TRANSACTIONS);

        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void print_transactions_in_reverse_chronological_order() {
        List<Transaction> transactions = ImmutableList.of(new Transaction("01/04/2014", 1000),
                                                          new Transaction("02/04/2014", -100),
                                                          new Transaction("10/04/2014", 500));
        printer.print(transactions);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}