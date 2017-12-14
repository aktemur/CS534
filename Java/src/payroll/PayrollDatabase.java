package payroll;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
    static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    static Map<Integer, Integer> affiliation = new HashMap<Integer, Integer>();

    public static Employee findEmployeeWithId(int id) {
        return employees.get(id);
    }

    public static void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public static void deleteEmployeeWithId(int empId) {
        employees.remove(empId);
    }

    public static Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    public static Employee findEmployeeWithMemberId(int memberId) {
        int empId = affiliation.get(memberId);
        return findEmployeeWithId(empId);
    }

    public static void addMembership(int memberId, int empId) {
        affiliation.put(memberId, empId);
    }

    public static void removeMembership(int memberId) {
        affiliation.remove(memberId);
    }
}
