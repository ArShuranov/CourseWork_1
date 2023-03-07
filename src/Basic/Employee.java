package Basic;

public class Employee {
    private String firstName;
    private String patronymic;
    private String lastName;
    private int department;
    private int salary;
    static int i = 1;
    private int id;

    public Employee(String firstName, String patronymic, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = i++;

    }

    @Override
    public String toString() {
        return "id: " + id + " firstName: " + firstName + " patronymic " + patronymic + " lastName " + lastName +
                " department " + department + " salary " + salary;
    }


    //////////////////////////////getters

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public static int getI() {
        return i;
    }

    public int getId() {
        return id;
    }


    //////////////////////////////setters

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
