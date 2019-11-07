package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankTest {
    @Test
    public void whenAddUserAndAccount() {
        Bank bank = new Bank();
        User user = new User("Zeka", "00555");
        bank.addUser(user);
        Account account = new Account(1000, "1234");
        Account account2 = new Account(5000, "1235");
        bank.addAccountToUser("00555", account);
        bank.addAccountToUser("00555", account2);
        bank.deleteAccountFromUser("00555", account2);
        List<Account> result = bank.getUserAccounts("00555");

        List<Account> expected = new ArrayList<>();
        expected.add(account);
        assertThat(result, is(expected));
    }

    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();
        User user = new User("Zeka", "00555");
        bank.addUser(user);
        Account account = new Account(1000, "1234");
        bank.addAccountToUser("00555", account);

        User user2 = new User("Vova", "00444");
        bank.addUser(user2);
        Account account2 = new Account(5000, "1235");
        bank.addAccountToUser("00444", account2);

        bank.transferMoney("00555", "1234", "00444", "1235", 300);
        double result = account.getValue();
        assertThat(result, is((double) 700));
    }
}
