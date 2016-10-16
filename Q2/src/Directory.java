import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Directory {
	static Hashtable<String, Integer> phoneBook = new Hashtable<String, Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	static void add() throws IOException {
		String name;
		int contactNo = 0;
		System.out.println("Enter name of Organisation/Person: ");
		name = br.readLine();
		System.out.println("Enter contact number: ");
		try {
			contactNo = Integer.parseInt(br.readLine());
			if (contactNo <= 0) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Please enter valid number.");
		}
		phoneBook.put(new String(name), new Integer(contactNo));
	}

	static void remove() throws IOException {
		String input = null;
		System.out.println("Enter name/number to remove: ");
		try {
			input = br.readLine();
			Integer contactNo = new Integer(Integer.parseInt(input));
			if (phoneBook.containsValue(contactNo)) {
				Set<Entry<String, Integer>> entries = phoneBook.entrySet();
				for (Map.Entry entry : entries) {
					if (contactNo.equals(entry.getValue())) {
						phoneBook.remove(entry.getKey());
						break;
					}
				}
			} else {
				System.out.println("Number not found!");
			}
		} catch (NumberFormatException ex) {
			if (phoneBook.containsKey(input)) {
				phoneBook.remove(input);
			} else {
				System.out.println("Name not found!");
			}
		}
	}

	static void display() {
		ArrayList<Map.Entry<?, Integer>> l = new ArrayList(phoneBook.entrySet());
		Collections.sort(l, new Comparator<Map.Entry<?, Integer>>() {

			public int compare(Map.Entry<?, Integer> o1,
					Map.Entry<?, Integer> o2) {
				return ((String) o1.getKey()).compareTo((String) o2.getKey());
			}
		});
		System.out.println(l);
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i).getKey() + ":" + l.get(i).getValue());
		}

	}

	static void look() throws IOException {
		String input = null;
		System.out.println("Enter name/number to search: ");
		try {
			input = br.readLine();
			Integer contactNo = new Integer(Integer.parseInt(input));
			if (phoneBook.containsValue(contactNo)) {
				Set<Entry<String, Integer>> entries = phoneBook.entrySet();
				for (Map.Entry entry : entries) {
					if (contactNo.equals(entry.getValue())) {
						System.out.println(entry.getKey() + ":"
								+ phoneBook.get(entry.getKey()));
						break;
					}
				}
			} else {
				System.out.println("Number not found!");
			}
		} catch (NumberFormatException ex) {
			if (phoneBook.containsKey(input)) {
				System.out.println(input + ": " + phoneBook.get(input));
			} else {
				System.out.println("No such name found.");
			}
		}
	}

	static void change() throws IOException {
		String input = null;
		System.out.println("Enter name/number to search: ");
		try {
			input = br.readLine();
			Integer contactNo = new Integer(Integer.parseInt(input));
			if (phoneBook.containsValue(contactNo)) {
				Set<Entry<String, Integer>> entries = phoneBook.entrySet();
				for (Map.Entry entry : entries) {
					if (contactNo.equals(entry.getValue())) {
						System.out.println("Enter new name: ");
						String newName = br.readLine();
						Integer num = phoneBook.remove(entry.getKey());
						phoneBook.put(new String(newName), num);
						break;
					}
				}
			} else {
				System.out.println("Number not found!");
			}
		} catch (NumberFormatException ex) {
			if (phoneBook.containsKey(input)) {
				System.out.println("Enter new contact number");
				phoneBook.put(input, Integer.parseInt(br.readLine()));
			} else {
				System.out.println("No such name found.");
			}
		}
	}
}
