// import java.util.Arrays;
// import java.util.SortedMap;

public class Main {
    public static int[] generateRandomArray(int arrLen, int maxValue) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[arrLen];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(maxValue);
        }
        return arr;
    } // генератор случайных чисел для "назначения" зарплаты и отдела

    public static void main(String[] args) {

        int numEmployee = 10;   // количество сотрудников

// Для решения задач "повышенной сложности"
// создали новый кдласс DepartmentService

        Employee[] employees = new Employee[numEmployee];
        int[] dep = generateRandomArray(numEmployee, 5); // department number
        int[] salaryInt = generateRandomArray(numEmployee, 100_000); // salary
        employees[0] = new Employee("Зайцев", "Николай", "Николаевич", 1 + dep[0], 80000.0 + salaryInt[0]);
        employees[1] = new Employee("Корниенко", "Илья", "Дмитриевич", 1 + dep[1], 80000.0 + salaryInt[1]);
        employees[2] = new Employee("Калистов", "Геннадий", "Антонович", 1 + dep[2], 80000.0 + salaryInt[2]);
//        employees[3] = new Employee("Колганова", "Алёна", "Евгеньевна", 1+dep[3], 80000.0+salaryInt[3]);
// забанили одного сотрудника, чтобы проверить устойчивость программы
        employees[4] = new Employee("Минин", "Константин", "Николаевич", 1 + dep[4], 80000.0 + salaryInt[4]);
        employees[5] = new Employee("Карпов", "Юрий", "Александрович", 1 + dep[5], 80000.0 + salaryInt[5]);
        employees[6] = new Employee("Адамович", "Евгений", "Юрьевич ", 1 + dep[6], 80000.0 + salaryInt[6]);
        employees[7] = new Employee("Моисеенко", "Михаил", "Иванович", 1 + dep[7], 80000.0 + salaryInt[7]);
        employees[8] = new Employee("Кухарев", "Андрей", "Николаевич", 1 + dep[8], 80000.0 + salaryInt[8]);
        employees[9] = new Employee("Гапонов", "Эдуард", "Евгеньевич", 1 + dep[9], 80000.0 + salaryInt[9]);

        // Выводим список сотрудников со всеми полями
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] != null)
                System.out.println("id: " + employees[j].getId() + "\t" + employees[j] + "\tоддел: " + employees[j].getDepartment() + "\tоклад: " + employees[j].getSalary());
        }

        // Индексирукем зарплату на заданный процент
        // допускаем как увеличение, так и уменьшение зарплаты
        int deltaSalary = 5; // изменение зарплаты [%]
        int numDepartment = 2;
        if (numDepartment == 0)
            System.out.println("Работаем со всеми отделами");
        else System.out.println("Работаем только с отделом № " + numDepartment);

        DepartmentService.indexOfSalary(employees, deltaSalary, numDepartment);
// Есди numDep == 0 индексируем зарплату всех отделов, если от 1 до 5, то указанного отдела

        // Выводим список сотрудников со всеми полями после индексации
        System.out.println("Проиндексировали зарплату на " + deltaSalary + " % \n теперь стало:");
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] != null) {
                int dept = employees[j].getDepartment();
                if (numDepartment == 0 | dept == numDepartment)
                    System.out.println("id: " + employees[j].getId() + "\t" + employees[j] + "\tотдел: " + employees[j].getDepartment() + "\tоклад: " + employees[j].getSalary());
            }
        }

        // Ищем минимальную зарплату в отделе
        int nId = DepartmentService.minSalaryId(employees, numDepartment); //индекс сотрудника с искомой зарплатой
        if (nId == 0) System.out.println("В этом отделе нет сотрудников !!!");
        else {
            System.out.println("Грустный обладатель минимальной зарплаты:");
            for (int n = 0; n < employees.length; n++) {
                if (employees[n] == null) continue;
                if (nId == employees[n].getId()) {
                    System.out.println(employees[n]);
                    System.out.println("id: " + employees[n].getId() + ",\tоклад: " + employees[n].getSalary());
                    break;
                }
            }
        }
// Ищем максимальную зарплату в отделе
        nId = DepartmentService.maxSalaryId(employees, numDepartment); // для сокращения длины записи индекса
        if (nId == 0) System.out.println("В этом отделе нет сотрудников !!!");
        else {
            System.out.println("Счастливый обладатель максимальной зарплаты:");
            for (int n = 0; n < employees.length; n++) {
                if (employees[n] == null) continue;
                if (nId == employees[n].getId()) {
                    System.out.println(employees[n]);
                    System.out.println("id: " + employees[n].getId() + ",\tоклад: " + employees[n].getSalary());
                    break;
                }
            }
        }
        System.out.println("\nСуммарная зарплата: " + DepartmentService.sumSalary(employees, numDepartment));
        System.out.println("Количество работников = " + DepartmentService.getNumPersons());
//        double middleSalary = DepartmentService.sumSalary(employees, numDepartment) / DepartmentService.getNumPersons();
        System.out.println("Средняя зарплата: " +  DepartmentService.calcAvgSalary(employees, numDepartment));

// Выводим полный список сотрудников (только ФИО)
        System.out.print("\nПолный список сотрудников ");
        if (numDepartment != 0) System.out.print(numDepartment + " отдела:");
        System.out.println();
        for (int j = 0; j < employees.length; j++) {
            if (employees[j] != null) {
                int dept = employees[j].getDepartment();
                if (numDepartment == 0 | dept == numDepartment)
                    System.out.println("id: " + employees[j].getId() + "\t" + employees[j] + "\tоклад: " + employees[j].getSalary());
            }
        }
        double foreignSalary = 130_000.;
        System.out.println("\nИщем сотрудников с зарплатой меньше "+foreignSalary);
        DepartmentService.salaryLessThen(employees,foreignSalary);
        System.out.println("\nИщем сотрудников с зарплатой больше (или равно) "+foreignSalary);
        DepartmentService.salaryGreatEq(employees,foreignSalary);
    }
}