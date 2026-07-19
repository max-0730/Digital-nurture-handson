class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId,
             String name,
             String position,
             double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {

        return "ID: " + employeeId +
               ", Name: " + name +
               ", Position: " + position +
               ", Salary: " + salary;
    }
}

public class EmployeeManagement {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    // Add Employee
    public static void addEmployee(Employee emp) {

        if (count < employees.length) {

            employees[count] = emp;
            count++;

            System.out.println("Employee Added");
        }
        else {

            System.out.println("Array Full");
        }
    }

    // Search Employee
    public static void searchEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                System.out.println("Employee Found:");
                System.out.println(employees[i]);
                return;
            }
        }

        System.out.println("Employee Not Found");
    }

    // Traverse Employees
    public static void displayEmployees() {

        for (int i = 0; i < count; i++) {

            System.out.println(employees[i]);
        }
    }

    // Delete Employee
    public static void deleteEmployee(int id) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                index = i;
                break;
            }
        }

        if (index == -1) {

            System.out.println("Employee Not Found");
            return;
        }

        for (int i = index; i < count - 1; i++) {

            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted");
    }

    public static void main(String[] args) {

        addEmployee(
                new Employee(
                        101,
                        "Rahul",
                        "Developer",
                        50000));

        addEmployee(
                new Employee(
                        102,
                        "Priya",
                        "Tester",
                        45000));

        addEmployee(
                new Employee(
                        103,
                        "Amit",
                        "Manager",
                        70000));

        System.out.println("\nAll Employees:");

        displayEmployees();

        System.out.println("\nSearching Employee ID 102:");

        searchEmployee(102);

        System.out.println("\nDeleting Employee ID 102:");

        deleteEmployee(102);

        System.out.println("\nEmployees After Deletion:");

        displayEmployees();
    }
}