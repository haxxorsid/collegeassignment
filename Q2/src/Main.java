import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int choice=0;
		while(choice!=6){
		System.out.println("1. Add an entry.");
		System.out.println("2. Remove an entry.");
		System.out.println("3. Look up an entry.");
		System.out.println("4. Change a entry.");
		System.out.println("5. Show all entries.");
		System.out.println("6. Exit");
		System.out.println("Enter choice: ");
		choice = sc.nextInt();
		switch(choice){
		case 1: Directory.add(); break;
		case 2: Directory.remove(); break;
		case 3: Directory.look(); break;
		case 4: Directory.change();break;
		case 5: Directory.display(); break;
		case 6: System.out.println("Bye!");break;
		default: System.out.println("Invalid choice!");
		}
	}
	}
}
