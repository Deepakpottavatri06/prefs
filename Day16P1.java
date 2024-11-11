import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

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
        return "Employee{name='" + name + "', age=" + age + 
               ", department='" + department + "', salary=" + salary + "}";
    }
}

public class Day16P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of employees
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline after integer input

        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] employeeData = sc.nextLine().split(" ");
            String name = employeeData[0];
            int age = Integer.parseInt(employeeData[1]);
            String department = employeeData[2];
            double salary = Double.parseDouble(employeeData[3]);
            employees.add(new Employee(name, age, department, salary));
        }

        // Create an ExecutorService to manage concurrent tasks
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        try {
            // Step 1: Filter employees with salary > 50,000
            Future<List<String>> namesFuture = executor.submit(() ->
                employees.parallelStream()
                    .filter(emp -> emp.getSalary() > 50000)
                    .map(Employee::getName)
                    .collect(Collectors.toList())
            );

            // Step 2: Calculate total salary expenditure
            Future<Double> totalSalaryFuture = executor.submit(() ->
                employees.parallelStream()
                    .filter(emp -> emp.getSalary() > 50000)
                    .mapToDouble(Employee::getSalary)
                    .sum()
            );

            // Step 3: Partition employees by age
            Future<Map<Boolean, List<Employee>>> partitionedFuture = executor.submit(() ->
                employees.parallelStream()
                    .collect(Collectors.partitioningBy(emp -> emp.getAge() > 30))
            );

            // Get results from futures
            List<String> employeeNames = namesFuture.get();
            double totalSalaryExpenditure = totalSalaryFuture.get();
            Map<Boolean, List<Employee>> partitionedEmployees = partitionedFuture.get();

            // Print the results
            System.out.println("Names of Employees with Salary > 50,000:");
            System.out.println(employeeNames);
            System.out.println("Total Salary Expenditure for Employees with Salary > 50,000:");
            System.out.println(totalSalaryExpenditure);
            System.out.println("Employees above 30 years of age:");
            System.out.println(partitionedEmployees.get(true));
            System.out.println("Employees 30 years or younger:");
            System.out.println(partitionedEmployees.get(false));

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); // Shutdown the executor service
        }
    }
}
