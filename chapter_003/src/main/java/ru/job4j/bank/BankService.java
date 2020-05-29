package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> findUser = findByPassport(passport);
        if (findUser.isPresent()) {
            List<Account> accounts = users.get(findUser.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl;
       User user =  users.keySet().stream()
               .filter(s -> s.getPassport().equals(passport))
               .findAny().orElse(null);
        rsl = Optional.ofNullable(user);
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> findUser = findByPassport(passport);
        if (findUser.isPresent()) {
            Account account = users.get(findUser.get()).stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findAny().orElse(null);
            rsl = Optional.ofNullable(account);
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}















