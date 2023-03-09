package Basic;

public class Basic {
    static Employee[] employees = new Employee[9];

    public static void main(String[] args) {
        employees[0] = new Employee("Иван", "Иванович", "Иванов", 5, 150000);
        employees[1] = new Employee("Петр", "Петрович", "Петров", 3, 120000);
        employees[2] = new Employee("Сидор", "Сидорович", "Сидоров", 1, 100000);
        employees[3] = new Employee("АААА", "ААААА", "ААААА", 1, 110000);
        employees[4] = new Employee("БББ", "БББ", "БББ", 2, 130000);
        employees[5] = new Employee("ВВВ", "ВВВ", "ВВВ", 2, 140000);
        employees[6] = new Employee("ГГГ", "ГГГ", "ГГГ", 3, 140000);
        employees[7] = new Employee("ДДД", "ДДД", "ДДД", 4, 130000);
        employees[8] = new Employee("ЕЕЕ", "ЕЕЕ", "ЕЕЕ", 3, 120000);


        System.out.println("---------------------------------------------------------------");
        System.out.println("Методы базовой сложности");
        System.out.println("---------------------------------------------------------------");
        print();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Сумма затрат на зарплаты в месяц: " + sumSalary());
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalary());
        System.out.println("Среднее значение зарплат: " + averageSalary());
        System.out.println("---------------------------------------------------------------");

        /// Методы повышенной сложности
        System.out.println("Методы повышенной сложности");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Проиндексированная заработная плата");
        indexSalary(45); // В качестве параметра приходит индекс в % на который мы увеличиваем зп
        print();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Сотрудник с минимальной зп в отделе: " + minSalaryDepartment(3));
        System.out.println("Сотрудник с максимальной зп в отделе: " + maxSalaryDepartment(3));
        System.out.println("Сумма затрат на зарплаты в отделе: " + sumSalaryDepartment(3));
        System.out.println("Среднее значение зарплат в отделе: " + averageSalaryDepartment(3));
        indexSalaryDepartment(3, 5); // индексируем зп отдела
        System.out.println("---------------------------------------------------------------");
        System.out.println("Список сотрудников отдела:");
        printDepartment(3);
        System.out.println("---------------------------------------------------------------");
        salaryLessThenIndex(200000);
        System.out.println("---------------------------------------------------------------");
        salaryMoreThenIndex(200000);


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

    public static double averageSalary() {
        return sumSalary() / employees.length;

    }

    //////////////// Методы повышенной сложности

    public static void indexSalary(int percent) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary((employees[i].getSalary() * percent) / 100 + employees[i].getSalary());
        }
    }


    public static String minSalaryDepartment(int numberOfDepartment) {
        Employee min = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                if (min == null || employees[i].getSalary() < min.getSalary()) {
                    min = employees[i];
                }

            }
        }
        return min.getFirstName() + " " + min.getLastName() + " " + min.getSalary();
    }

    public static String maxSalaryDepartment(int numberOfDepartment) {
        Employee max = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                if (max == null || employees[i].getSalary() > max.getSalary()) {
                    max = employees[i];
                }
            }


        }
        return max.getFirstName() + " " + max.getLastName() + " " + max.getSalary();
    }

    public static int sumSalaryDepartment(int numberOfDepartment) {
        int sumSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                sumSalary += employees[i].getSalary();
            }
        }
        return sumSalary;
    }

    public static double averageSalaryDepartment(int numberOfDepartment) {
        int countEmployeesInDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                countEmployeesInDepartment++;
            }
        }
        return sumSalaryDepartment(numberOfDepartment) / countEmployeesInDepartment;

    }

    public static void indexSalaryDepartment(int numberOfDepartment, int percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                employees[i].setSalary((employees[i].getSalary() * percent) / 100 + employees[i].getSalary());
            }
        }
    }

    public static void printDepartment(int numberOfDepartment) {
        // можно было бы переопределить toString, но тогда он стал по другому работать и для базового уровня
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == numberOfDepartment) {
                System.out.println("id " + employees[i].getId() + " " + employees[i].getFirstName() + " " + employees[i].getPatronymic() + " "
                        + employees[i].getLastName() + " " + employees[i].getSalary());
            }
        }
    }

    public static void salaryLessThenIndex(int index) {
        System.out.println("Сотрудники чьи зарплаты ниже: " + index);
        for (int i = 0; i < employees.length; i++) {
            if (index > employees[i].getSalary()) {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getLastName() + " " + employees[i].getSalary());
            }
        }
    }

    public static void salaryMoreThenIndex(int index) {
        System.out.println("Сотрудники чьи зарплаты выше или равны: " + index);
        for (int i = 0; i < employees.length; i++) {
            if (index < employees[i].getSalary()) {
                System.out.println(employees[i].getFirstName() + " " + employees[i].getLastName() + " " + employees[i].getSalary());
            }
        }
    }
}

