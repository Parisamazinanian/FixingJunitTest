package incorrect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.*;

import main.java.Employee;
import main.java.EmployeeManager;

class TestEmpListSize {
	EmployeeManager EM = null;

	@BeforeEach
	void init() {
		EM = new EmployeeManager();
		EM.initialize();
	}

	
	@Test
	@DisplayName("Correct initial length of Employee List")
	void testEmpListLength() {
		assertEquals(3, EM.getEmployeeList().size());
	}

	@Test
	@DisplayName("Incorrect initial length of Employee List")
	void testEmpListWrongLength() {
		assertNotEquals(2, EM.getEmployeeList().size());
	}

	@Test
	@DisplayName("2 is the Correct Edited Length of Employee List")
	void testEmpListEditedLength2() {
		EM.getEmployeeList().remove(0);
		assertEquals(2, EM.getEmployeeList().size());
	}

	@Test
	@DisplayName("4 is the Correct Edited length of Employee List")
	void testEmpListEditedLength4() {
		EM.getEmployeeList().add(new Employee());
		assertEquals(4, EM.getEmployeeList().size());
	}

	@AfterEach
	void clear() {
		EM = null;
	}
}
