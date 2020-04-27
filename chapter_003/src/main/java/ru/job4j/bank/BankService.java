package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static jdk.internal.util.SystemProps.putIfAbsent;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user,  new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User findUser = findByPassport(passport);
        if (findUser.getPassport().equals(passport)) {
//            users.put(findUser, (List<Account>) account);
            users.put(findUser, (List<Account>) new Account(account.getRequisite(), account.getBalance()));
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            User key = entry.getKey();
            if (key.getPassport().equals(passport)) {
                rsl = key;
            }
            break;
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            List<Account> value = entry.getValue();
            if (findByPassport(passport).getPassport().equals(passport)) {
                if (value.contains(requisite)) {
                    int index = value.indexOf(new Account(requisite, -1));
                    rsl = value.get(index);
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (findByRequisite(srcPassport, srcRequisite).equals(new Account(srcRequisite, -1))
        && findByRequisite(destPassport, destRequisite).equals(new Account(destRequisite, -1))
        && (findByRequisite(srcPassport, srcRequisite).getBalance() > amount)) {
            findByRequisite(srcPassport, srcRequisite).setRequisite("200");
            findByRequisite(destPassport, destRequisite).setRequisite("100");
            rsl = true;
        }
        return rsl;
    }
}















