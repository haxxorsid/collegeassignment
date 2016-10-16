import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class University {
	private static class Department {
		final String name;
		Set<Professor> professors;

		public Department(String name) {
			this.name = new String(name);
			this.professors = new HashSet<Professor>();
		}

		public void add(Professor professor) {
			professors.add(professor);
		}
	}

	private final String name;
	private Map<String, Department> departments;

	public University(String name) {
		this.name = new String(name);
		this.departments = new TreeMap<String, Department>();
	}

	public String getName() {
		return new String(name);
	}

	public void addDepartment(String name) {
		Department dept = new Department(name);
		departments.put(name, dept);
	}

	public void add() throws IOException{
		int choice = 0;
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String name, deptName;
		Professor prof = null;
		System.out.println("Enter name of professor: ");
		name = sc.readLine();
		System.out.println("Enter department for adding professor");
		deptName = sc.readLine();
		System.out.println("Select rank of professor: ");
		{
			System.out.println("1. Assitant");
			System.out.println("2. Associate ");
			System.out.println("3. Professor ");
			System.out.println("Enter choice: ");
			choice = Integer.parseInt(sc.readLine());
			switch (choice) {
			case 1:
				prof = new Professor(name, Professor.Rank.ASST);
				break;
			case 2:
				prof = new Professor(name, Professor.Rank.ASSOC);
				break;
			case 3:
				prof = new Professor(name, Professor.Rank.PROF);
				break;
			default:
				System.out.println("Invalid choice!");
			}
		}
		Department dept = departments.get(deptName);
		if (dept == null) {
			System.out.println("Department " + deptName + " does not exist");
		} else {
			dept.add(prof);
		}
	}

	public void removeDepartment(String deptName) {
		if (departments.get(deptName) == null) {
			System.out.println("Department " + deptName + " does not exist");
		} else {
			departments.remove(deptName);
		}
	}

	public void displayDepartments() {
		System.out.println("List of departments:");
		for (Map.Entry<String, Department> entry : departments.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	public void displayProfessors() {
		System.out.println("List of professors:");
		for (Map.Entry<String, Department> entry : departments.entrySet()) {
			Department dept = entry.getValue();
			for (Iterator<Professor> it = dept.professors.iterator(); it
					.hasNext();) {
				Professor prof = it.next();
				System.out.println(prof.name + ":" + prof.rank.toString() +":" + entry.getKey());
			}
		}
	}

	public void fireProfessor() throws IOException{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name of professor");
		String name = sc.readLine();
		for (Map.Entry<String, Department> entry : departments.entrySet()) {
			Department dept = entry.getValue();
			for (Iterator<Professor> it = dept.professors.iterator(); it
					.hasNext();) {
				Professor prof = it.next();
				if (prof.name.equalsIgnoreCase(name)) {
					it.remove();
					System.out.println(name + " has been removed ");
				} else {
					System.out.println(name + "not found in any department");
				}
			}
		}
	}
}