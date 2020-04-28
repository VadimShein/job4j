package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
//        if (!users.containsKey(user)) {
//        users.put(user, new ArrayList<Account>());
//    }
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User findUser = findByPassport(passport);
        if (findUser != null) {
            List<Account> accounts = users.get(findUser);
              if (!accounts.contains(account)) {
                  accounts.add(account);
              }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            User key = entry.getKey();
            if (key.getPassport().equals(passport)) {
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User findUser = findByPassport(passport);
        if (findUser != null) {
            List<Account> findAccount = users.get(findUser);
            for (Account value : findAccount) {
                if (value.getRequisite().equals(requisite)) {
                    rsl = value;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}















