package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Account> accounts = null;
        for (Map.Entry<User, List<Account>> user : map.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                accounts = user.getValue();
            }
        }
        return accounts;
    }

    public Account getAccount(String passport, String requisite) {
        Account account = null;
        List<Account> accounts = getUserAccounts(passport);
        for (Account acc : accounts) {
            if (acc.getRequisites().equals(requisite)) {
                account = acc;
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        Account destAccount = getAccount(destPassport, destRequisite);
        double srcValue = srcAccount.getValue();
        if (srcAccount == null || destAccount == null || srcValue < amount) {
            return false;
        }
        srcValue -= amount;
        srcAccount.setValue(srcValue);
        double destValue = destAccount.getValue();
        destValue += amount;
        destAccount.setValue(destValue);
        return true;
    }
}
