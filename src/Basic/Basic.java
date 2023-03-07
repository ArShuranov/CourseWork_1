package Basic;

public class Basic {
    static Employee[] employees = new Employee[3];
    public static void main(String[] args) {
        employees[0] = new Employee("Иван", "Иванович", "Иванов", 5, 150000);
        employees[1] = new Employee("Петр", "Петрович", "Петров", 3, 120000);
        employees[2] = new Employee("Сидор", "Сидорович", "Сидоров", 5, 100000);

        System.out.println("---------------------------------------------------------------");
        print();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Сумма затрат на зарплаты в месяц: " + sumSalary());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalary());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalary());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Среднее значение зарплат: " + averageSalary(employees));
        System.out.println("---------------------------------------------------------------");

    }

    public static void print() {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

    }

    public static double sumSalary() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public static String minSalary() {
        double salary = employees[0].getSalary();
        int employeeNum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary > employees[i].getSalary()) {
                salary = employees[i].getSalary();
                employeeNum = i;
            }
        }
        return employees[employeeNum].getFirstName() + " " + employees[employeeNum].getLastName() + " " + employees[employeeNum].getSalary();

    }

    public static String maxSalary() {
        double salary = employees[0].getSalary();
        int employeeNum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (salary < employees[i].getSalary()) {
                salary = employees[i].getSalary();
                employeeNum = i;
            }
        }
        return employees[employeeNum].getFirstName() + " " + employees[employeeNum].getLastName() + " " + employees[employeeNum].getSalary();
    }

    public static double averageSalary(Employee[] test) {
        return sumSalary() / employees.length;

    }
}

