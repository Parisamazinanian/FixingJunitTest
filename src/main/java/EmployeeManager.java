
package main.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class EmployeeManager {
	private List<Employee> empList = new ArrayList<Employee>();

	public static void main(String[] args) {
		EmployeeManager EM = new EmployeeManager();
		EM.initialize();
		EM.shuffle();
	}

	public void initialize() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("./data/employees.json"));
			JSONArray emps = (JSONArray) JSONValue.parse(reader);
			for (Object obj : emps) {
				if (obj instanceof JSONObject) {
					JSONObject empObj = (JSONObject) obj;
					Employee emp = new Employee();
					emp.setName(empObj.get("name").toString());
					emp.setEmail(empObj.get("email").toString());
					this.empList.add(emp);
				}
			}
			System.out.println(this.empList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// e.printStackTrace();
				}
			}
		}
	}

	public List<Employee> getEmployeeList() {
		return this.empList;
	}

	public void shuffle() {
		this.empList.sort(new EmployeeComparator());
		System.out.println(this.empList);
	}
}
