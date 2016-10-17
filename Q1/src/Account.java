public class Account {
public static Account account;
private static int credit = 1000;
private static Person per;

private Account() {
}

public static Account getAccount(Person p) {
    if (account == null) {
        account = new Account();
    }
    Account.per = p;
    return account;
}

public static int getBal() {
    return credit;
}

public synchronized void withdraw(int bal) {
    try {

        if (credit >= bal) {
            System.out.println(per.getName() + " " + "is trying to withdraw.");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            credit = credit - bal;
            System.out.println(per.getName() + " " + "is about to complete withdraw");
        } else {
            System.out.println(per.getName() + " " + "doesn't have enough money to withdraw.");
        }
        System.out.println(per.getName() + " " + "has withdrawn Rs." + bal);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public synchronized void deposit(int bal) {
    try {
        if (bal > 0) {
            System.out.println(per.getName() + " " + " is trying to deposit.");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            credit = credit + bal;
            System.out.println(per.getName() + " " + "is about to complete the deposit");
        } else {
            System.out.println(per.getName() + " " + "is trying to deposit invalid amount of money.");
        }
        System.out.println(per.getName() + " " + "has deposited Rs." + bal);
    } catch (Exception e) {
        e.printStackTrace();
    }
}}