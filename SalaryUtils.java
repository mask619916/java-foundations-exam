/**
 * SalaryUtils — static utility methods for salary calculations.
 *
 * YOUR TASK (Part A): Implement all 4 methods below.
 * Each method has a clear description of what it should do.
 * All methods are static — you call them as SalaryUtils.methodName().
 */
public class SalaryUtils {

    /**
     * Calculate annual salary from a monthly salary.
     * Formula: monthly * 12
     *
     * @param monthlySalary the monthly salary (must be positive)
     * @return the annual salary
     * @throws IllegalArgumentException if monthlySalary is negative
     */
    public static double calculateAnnualSalary(double monthlySalary) {
         // TODO: Implement this method
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("monthlySalary can't be negative");
        }
        return monthlySalary * 12;
    }

    /**
     * Calculate tax on an annual salary using tiered rates:
     *   - Annual salary under 10,000    → 0% tax
     *   - Annual salary 10,000 to 30,000 → 10% tax on the full amount
     *   - Annual salary above 30,000     → 20% tax on the full amount
     *
     * Example: calculateTax(25000) → 2500.0  (10% of 25000)
     * Example: calculateTax(50000) → 10000.0 (20% of 50000)
     * Example: calculateTax(8000)  → 0.0     (0%)
     *
     * @param annualSalary the annual salary (must not be negative)
     * @return the tax amount
     * @throws IllegalArgumentException if annualSalary is negative
     */
    public static double calculateTax(double annualSalary) {
         // TODO: Implement this method using if/else
        if (annualSalary < 0) {
            throw new IllegalArgumentException("annualSalary can't be negative");
        }
        if (annualSalary < 10000) {
            return 0;
        } else if (annualSalary <= 30000) {
            return annualSalary * (10/100);
        } else {
            return annualSalary * (20/100);
        }
    }

    /**
     * Calculate net salary (after tax) for a given annual salary.
     * Formula: annualSalary - calculateTax(annualSalary)
     *
     * @param annualSalary the annual salary
     * @return the net salary after tax
     * @throws IllegalArgumentException if annualSalary is negative
     */
    public static double calculateNetSalary(double annualSalary) {
        // TODO: Implement this method (hint: reuse calculateTax)
        if (annualSalary < 0) {
            throw new IllegalArgumentException("annualSalary can't be negative");
        }
        return annualSalary - calculateTax(annualSalary);
    }

    /**
     * Apply a percentage raise to a current salary.
     * Formula: currentSalary * (1 + percentRaise / 100)
     *
     * Example: applyRaise(3000, 10) → 3300.0  (10% raise on 3000)
     *
     * @param currentSalary the current salary (must be positive)
     * @param percentRaise  the raise percentage (must be between 0 and 100)
     * @return the new salary after the raise
     * @throws IllegalArgumentException if currentSalary is negative
     * @throws IllegalArgumentException if percentRaise is negative or above 100
     */
    public static double applyRaise(double currentSalary, double percentRaise) {
        // TODO: Implement this method
        if (currentSalary < 0) {
            throw new IllegalArgumentException("currentSalary can't be negative");
        }
        if (percentRaise < 0 || percentRaise > 100) {
            throw new IllegalArgumentException("percentRaise must be between 0 and 100");
        }
        return currentSalary * (1 + percentRaise / 100);
        
    }
}
