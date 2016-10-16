import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		University univ;
		int choice = 0;
		System.out.println("Enter University name: ");
		univ = new University(sc.readLine());
		while (choice != 7) {
			System.out.println("1. Add Department");
			System.out.println("2. Remove Department");
			System.out.println("3. Add professor in a department");
			System.out.println("4. Fire professor from a department");
			System.out.println("5. Display Departments");
			System.out.println("6. Display Professors");
			System.out.println("7. Exit");
			choice = Integer.parseInt(sc.readLine());
			switch (choice) {
			case 1:
				System.out.println("Enter name for department");
				univ.addDepartment(sc.readLine());
				break;
			case 2:
				System.out.println("Enter name to remove department");
				univ.removeDepartment(sc.readLine());
				break;
			case 3:
				univ.add();
				break;
			case 4:
				univ.fireProfessor();
				break;
			case 5:
				univ.displayDepartments();
				break;
			case 6:
				univ.displayProfessors();
				break;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

}