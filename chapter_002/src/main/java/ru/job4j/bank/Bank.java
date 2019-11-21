package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {
    private Map<User, List<Account>> map;

    public Bank() {
        map = new HashMap<>();
    }

    public void addUser(User user) {
        List<Account> list = new ArrayList<>();
        map.putIfAbsent(user, list);
    }

    public void deleteUser(User user) {
        map.remove(user);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        getUserAccounts(passport).remove(account);
    }

    public void addAccountToUser(String passport, Account account) {
        getUserAccounts(passport).add(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return map.entrySet().stream().filter(e -> e.getKey().getPassport().equals(passport)).map(e -> e.getValue()).collect(Collectors.toMap(e -> "account", e -> e)).get("account");
    }

    public Account getAccount(String passport, String requisite) {
        Account[] account = {null};
        List<Account> accounts = getUserAccounts(passport);
        accounts.stream().filter(a -> a.getRequisites().equals(requisite)).forEach(x -> account[0] = x);
        return account[0];
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        Account destAccount = getAccount(destPassport, destRequisite);
        boolean result = false;
        if (srcAccount != null && destAccount != null) {
            result = srcAccount.transfer(amount, destAccount);
        }
        return result;
    }
}
