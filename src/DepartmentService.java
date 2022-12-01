public class DepartmentService {
    private static Employee[] employees;

    // ищем в массиве минимальное значение, возвращаем его индекс
    public static int minSalaryId(Employee[] employees, int numDep) {
        double minSal = 9.9e99;
        int minSalId = 0;
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] != null) {
                int dep = employees[j].getDepartment();
                if (numDep == 0 | dep == numDep) {
                    if (employees[j].getSalary() < minSal) {
                        minSal = employees[j].getSalary();
                        minSalId = employees[j].getId();
                    }
                }
            }
        }
        return minSalId;
    }

    // определяем количество сотрудников в отделе
    public static int numPersons(Employee[] employees, int numDep) {
        int num = 0;
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] != null) {
                int dep = employees[j].getDepartment();
                if (numDep == 0 | dep == numDep) {
                    num++;
                }
            }
        }
        return num;
    }

    // ищем в массиве максимальное значение, возвращаем его индекс
    public static int maxSalaryId(Employee[] employees, int numDep) {
        double maxSal = 0.;
        int maxSalId = 0;
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] != null) {
                int dep = employees[j].getDepartment();
                if (numDep == 0 | dep == numDep) {
                    if (employees[j].getSalary() > maxSal) {
                        maxSal = employees[j].getSalary();
                        maxSalId = employees[j].getId();
                    }
                }
            }
        }
        return maxSalId;
    }
    // ищем сумму зарплат в массиве

    public static double sumSalary(Employee[] employees, int numDep) {
        double sum = 0.0;
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] != null) {
                int dep = employees[j].getDepartment();
                if (numDep == 0 | dep == numDep) {
                    sum = sum + employees[j].getSalary();
                }
            }
        }
        return sum;
    }

    // индексируем зарплату на delta %
    public static void indexOfSalary(Employee[] employees, int delta, int numDep) {
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] != null) {
                int dep = employees[j].getDepartment();
                if (numDep == 0 | dep == numDep) {
                    double sal = employees[j].getSalary();
                    sal = sal * (1.0 + delta / 100.0);
                    employees[j].setSalary(sal);
                }
            }
        }
    }

    // печатаем зарплаты ниже порогового значения
    public static void salaryLessThen(Employee[] employees, double borderSalary) {
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] == null) continue;
            if (employees[j].getSalary() < borderSalary)
                System.out.println("id: " + employees[j].getId() + "\t" + employees[j] + "\tоклад: " + employees[j].getSalary());
        }
    }

    // печатаем зарплаты со значениями >= порогового
    public static void salaryGreatEq(Employee[] employees, double borderSalary) {
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] == null) continue;
            if (employees[j].getSalary() >= borderSalary)
                System.out.println("id: " + employees[j].getId() + "\t" + employees[j] + "\tоклад: " + employees[j].getSalary());
        }
    }
}
