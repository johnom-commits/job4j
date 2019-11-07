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
        for (Map.Entry<User, List<Account>> user : map.entrySet()) {
            if (user.getKey().getPassport().compareTo(passport) == 0) {
                return user.getValue();
            }
        }
        return null;
    }

    public Account getAccount(String passport, String requisite) {
        List<Account> accounts = getUserAccounts(passport);
        for (Account account : accounts) {
            if (account.getRequisites().compareTo(requisite) == 0) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        double srcValue = srcAccount.getValue();
        if (srcAccount == null || srcValue < amount) {
            return false;
        }
        Account destAccount = getAccount(destPassport, destRequisite);
        srcValue -= amount;
        srcAccount.setValue(srcValue);
        double destValue = destAccount.getValue();
        destValue += amount;
        destAccount.setValue(destValue);
        return true;
    }
}
