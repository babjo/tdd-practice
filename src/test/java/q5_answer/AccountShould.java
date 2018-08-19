package q5_answer;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountShould {

    private Account account;
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    StatementPrinter statementPrinter;

    @BeforeEach
    void setUp() {
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void store_a_deposit_transaction() {
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void store_a_withdrawal_transaction() {
        account.withdraw(100);
        verify(transactionRepository).addWithdrawal(100);
    }

    @Test
    public void print_a_statement() {
        List<Transaction> transactions = asList(new Transaction("12/05/2015", 100));
        given(transactionRepository.allTransactions()).willReturn(transactions);

        account.printStatement();
        verify(statementPrinter).print(transactions);
    }
}
