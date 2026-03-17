/**
 * Main — demonstrate your Employee Management System.
 *
 * YOUR TASKS:
 *   Part C — Create Manager and Intern objects, demonstrate polymorphism
 *   Part D — Add try/catch blocks for exception handling
 *
 * This file should compile and run, printing output that proves
 * all your code works correctly.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== PART A: Salary Utilities ===");
          // TODO: Test all 4 SalaryUtils methods and print results
        // Example:
        //   System.out.println("Annual salary: " + SalaryUtils.calculateAnnualSalary(3000));
        //   System.out.println("Tax on 25000: " + SalaryUtils.calculateTax(25000));
        //   System.out.println("Net salary: " + SalaryUtils.calculateNetSalary(25000));
        //   System.out.println("After 10% raise: " + SalaryUtils.applyRaise(3000, 10));
        
        System.out.println("Annual salary: " + SalaryUtils.calculateAnnualSalary(3000));
        System.out.println("Tax on 25000: " + SalaryUtils.calculateTax(25000));
        System.out.println("Net salary: " + SalaryUtils.calculateNetSalary(25000));
        System.out.println("After 10% raise: " + SalaryUtils.applyRaise(3000, 10));


        System.out.println("\n=== PART B: Employee Manager ===");
        // TODO: Create an EmployeeManager
        // TODO: Create and add at least 3 employees to it
        // TODO: Demonstrate findById (found + not found)
        // TODO: Demonstrate getEmployeesByDepartment

        EmployeeManager manager = new EmployeeManager();

        Employee emp1 = new Employee(1, "Mohamed", "Engineering", 3500);
        Employee emp2 = new Employee(2, "Ahmed", "Engineering", 4000);
        Employee emp3 = new Employee(3, "Abdulhameed", "HR", 3000);
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);

        System.out.println("findById(2): " + manager.findById(2)); // should work just fine
        System.out.println("findById(25): " + manager.findById(25)); // should return null

        System.out.println("Engineering dept: " + manager.getEmployeesByDepartment("engineering"));
        System.out.println("HR dept: " + manager.getEmployeesByDepartment("hr"));


        System.out.println("\n=== PART C: Inheritance & Polymorphism ===");
                // TODO: Create at least 1 Manager and 1 Intern
        // TODO: Add all employees (Employee, Manager, Intern) to the manager
        // TODO: Loop through getAllEmployees() and call getBonus() on each
        //       Print: "<name> bonus: <amount>" for each one
        //       This demonstrates polymorphism — same method call, different behavior

        Manager mgr = new Manager(4, "Mohamed", "Engineering", 5000, 8);
        Intern intern = new Intern(5, "Ahmed", "Marketing", 1200, "UOB");
        manager.addEmployee(mgr);
        manager.addEmployee(intern);

        for (Employee employee : manager.getAllEmployees()) {
          System.out.println(employee.getName() + " bonus: " + employee.getBonus());
        }


        System.out.println("\n=== PART D: Exception Handling ===");
        // TODO: Use try/catch to demonstrate:
        //   1. Trying to remove an employee that doesn't exist
        //   2. Trying to promote an employee that's already a Manager
        //   3. Trying to create an Employee with invalid data (negative salary)
        // Each try/catch should print the error message gracefully
        try {
            manager.removeEmployee(25); // ID that doesn't exist
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            manager.promoteToManager(4, 10); // ID that is already a Manager
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Employee invalidEmployee = new Employee(6, "Invalid", "finance", -5000);
            manager.addEmployee(invalidEmployee);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
