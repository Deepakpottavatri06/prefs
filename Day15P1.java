
import java.util.*;
import java.util.stream.*;
// Employee class.
class Employee {
    String name;
    int age;
    String department;
    double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", department='" + department + "', salary=" + salary + "}";
    }
}


public class Day15P1{
    // Implement the Solution Class.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        sc.nextLine(); 

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] employeeData = sc.nextLine().split(" ");
            String name = employeeData[0];
            int age = Integer.parseInt(employeeData[1]);
            String department = employeeData[2];
            double salary = Double.parseDouble(employeeData[3]);
            employees.add(new Employee(name, age, department, salary));
        }

        List<Employee> filteredEmployees = employees.stream()
            .filter(emp -> emp.salary > 50000)
            .collect(Collectors.toList());

        List<String> employeeNames = filteredEmployees.stream()
            .map(emp -> emp.name)
            .collect(Collectors.toList());

        double totalSalaryExpenditure = filteredEmployees.stream()
            .mapToDouble(emp -> emp.salary)
            .sum();

        Map<Boolean, List<Employee>> partitionedByAge = employees.stream()
            .collect(Collectors.partitioningBy(emp -> emp.age > 30));

        System.out.println("Names of Employees with Salary > 50,000:");
        System.out.println(employeeNames);

        System.out.println("Total Salary Expenditure for Employees with Salary > 50,000:");
        System.out.println(totalSalaryExpenditure);

        System.out.println("Employees above 30 years of age:");
        System.out.println(partitionedByAge.get(true));

        System.out.println("Employees 30 years or younger:");
        System.out.println(partitionedByAge.get(false));
    }

}
