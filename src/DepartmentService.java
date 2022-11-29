public class DepartmentService {
private static Employee[] employees;
static int j;
    // ищем в массиве минимальное значение, возвращаем его индекс
    public static int minSalaryId(Employee[] employees, int numDep) {
        double minSal = 9.9e99;
        int minSalId = 0;
        for ( j = 0; j < employees.length; j++) {
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

    // ищем в массиве максимальное значение, возвращаем его индекс
    public static int maxSalaryId(Employee[] employees, int numDep) {
        double maxSal = 0.;
        int maxSalId = 0;
        for ( j = 0; j < employees.length; j++) {
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
// и среднее значение
    static int numPersons;
    public static int getNumPersons() {
        return numPersons;
    }

    public static double calcAvgSalary(Employee[] employees, int numDep) {
        return sumSalary(employees, numDep) / getNumPersons();
    }
    public static double sumSalary(Employee[] employees, int numDep) {
        double sum = 0.0;
            numPersons = 0;
            for ( j = 0; j < employees.length; j++) {
                    if (employees[j] != null) {
                        int dep = employees[j].getDepartment();
                        if (numDep == 0 | dep == numDep) {
                            sum = sum + employees[j].getSalary();
                            numPersons++;
                        }
                    }
                }
            return sum;
        }

    public static void indexOfSalary( Employee[] employees, int delta, int numDep)    {
/*
        int delta;
        static int numDep;
*/
        for ( j = 0; j < employees.length; j++) {
            if (employees[j] != null){
                int dep = employees[j].getDepartment();
//                System.out.println("dept = "+dep);        отладочные принты
                if (numDep == 0 | dep == numDep) {
                     double sal = employees[j].getSalary();
//                    System.out.println("sal 1 = "+sal);   отладочные принты
                            sal = sal * (1.0 + delta/100.0);
//                    System.out.println("sal 2 = "+sal);   отладочные принты
                    employees[j].setSalary(sal);
                }
            }
        }
    }
    public static void salaryLessThen( Employee[] employees, double foreignSalary){
        for ( j = 0; j < employees.length; j++){
        if (employees[j] == null) continue;
        if (employees[j].getSalary() < foreignSalary)
            System.out.println("id: " + employees[j].getId() + "\t" + employees[j] + "\tоклад: " + employees[j].getSalary());
        }
    }
    public static void salaryGreatEq( Employee[] employees, double foreignSalary){
        for ( j = 0; j < employees.length; j++){
            if (employees[j] == null) continue;
            if (employees[j].getSalary() >= foreignSalary)
                System.out.println("id: " + employees[j].getId() + "\t" + employees[j] + "\tоклад: " + employees[j].getSalary());
        }
    }
}
