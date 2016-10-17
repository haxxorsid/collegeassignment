import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise extends Thread implements Runnable {
	private static LinkedList<Person> users = new LinkedList<Person>();
	private Person holder;

	private static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	public Exercise(Person p) {
		this.holder = p;
	}

	public static void main(String[] args) throws IOException {
		createAccount();
	}

	public static void createAccount() throws IOException {
		String userName1, userName2, pass1, pass2;
		System.out.println("Joint account for 2 people\n Create Account1: ");
		System.out.println("Enter username for 1st account: ");
		userName1 = br.readLine();
		System.out.println("Enter password for 1st account: ");
		pass1 = br.readLine();
		users.add(new Person(userName1, pass1));
		System.out.println("Create Account2: ");
		System.out.println("Enter username for 2nd account: ");
		userName2 = br.readLine();
		System.out.println("Enter password for 2nd account: ");
		pass2 = br.readLine();
		users.add(new Person(userName2, pass2));
		login();
	}

	public static void login() throws IOException {
		String nameInput, passInput;
		int check=0;
		System.out.println("Login\n Enter Username:");
		nameInput = br.readLine();
		System.out.println("Enter password:");
		passInput = br.readLine();
		for (int i = 0; i < users.size(); i++) {
			Person p = users.get(i);
			if (p.getName().equals(nameInput)
					&& p.getPassword().equals(passInput)) {
				check++;
				Exercise t = new Exercise(p);
				t.start();
				break;
			}
		}
		if(check==0)
			System.out.println("Account not found!");
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		Account acc = Account.getAccount(holder);
		int choice = 0;
		while(choice!=4){
		System.out
				.println("1. Withdraw\n2. Deposit\n3. Show current balance\n4. Logout");
		System.out.println("Enter choice: ");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter value to withdraw: ");
			acc.withdraw(sc.nextInt());
			try {
				Thread.sleep(200);
			} catch (InterruptedException ex) {
				Logger.getLogger(Exercise.class.getName()).log(
						Level.SEVERE, null, ex);
			}
			if (acc.getBal() < 0) {
				System.out.println("Account has no credit left.");
			}
			break;
		case 2:
			System.out.println("Enter value to deposit: ");
			acc.deposit(sc.nextInt());
			break;
		case 3:
			System.out
					.println("Current account balance is:" + Account.getBal());
			break;
		case 4:
			System.out.println("Successfully logged out!");
			try {
				login();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			System.out.println("Invalid choice!");
			break;
		}
		}
	}
}