package Basic;
import java.util.Arrays;

public class Basic {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Иван", "Иванович", "Иванов", 5, 150000, Employee.getI());
        employees[1] = new Employee("Петр", "Петрович", "Петров", 3, 120000, Employee.getI());
        employees[2] = new Employee("Сидор", "Сидорович", "Сидоров", 5, 100000, Employee.getI());

        System.out.println("---------------------------------------------------------------");
        print(employees);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Сумма затрат на зарплаты в месяц: " + sumSalary(employees));
        System.out.println("---------------------------------------------------------------");
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalary(employees));
        System.out.println("---------------------------------------------------------------");
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalary(employees));
        System.out.println("---------------------------------------------------------------");
        System.out.println("Среднее значение зарплат: " + averageSalary(employees));
        System.out.println("---------------------------------------------------------------");

    }

    public static void print(Employee[] test) {
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i].toString());
        }

    }

    public static double sumSalary(Employee[] test) {
        double sum = 0;
        for (int i = 0; i < test.length; i++) {
            sum += test[i].getSalary();
        }
        return sum;
    }

    public static String minSalary(Employee[] test) {
        double salary = test[0].getSalary();
        int employeeNum = 0;
        for (int i = 0; i < test.length; i++) {
            if (salary > test[i].getSalary()) {
                salary = test[i].getSalary();
                employeeNum = i;
            }
        }
        return test[employeeNum].getFirstName() + " " + test[employeeNum].getLastName() + " " + test[employeeNum].getSalary();

    }

    public static String maxSalary(Employee[] test) {
        double salary = test[0].getSalary();
        int employeeNum = 0;
        for (int i = 0; i < test.length; i++) {
            if (salary < test[i].getSalary()) {
                salary = test[i].getSalary();
                employeeNum = i;
            }
        }
        return test[employeeNum].getFirstName() + " " + test[employeeNum].getLastName() + " " + test[employeeNum].getSalary();
    }

    public static double averageSalary(Employee[] test) {
        return sumSalary(test) / test.length;

    }
}

