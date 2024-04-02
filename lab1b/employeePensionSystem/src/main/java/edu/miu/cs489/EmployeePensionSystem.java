package edu.miu.cs489;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.miu.cs489.adapter.LocalDateTypeAdapter;
import edu.miu.cs489.model.Employee;
import edu.miu.cs489.model.PensionPlan;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeePensionSystem {
    public static void main(String[] args) {
        List<Employee> employees = getEmployees();

//        printSortedEmployeesInJson(employees);
        monthlyUpcomingEnrolleesReport(employees);
    }

    // Task B1
    public static void printSortedEmployeesInJson(List<Employee> employees) {
        // sort the data (ascending by lastName, then descending by salary)
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing((Employee e1, Employee e2) -> Double.compare(e2.getYearlySalary(), e1.getYearlySalary())))
                .collect(Collectors.toList());

        // print the data
        System.out.println("Employees");
        printEmployeesInJson(sortedEmployees);
    }

    // Task B2
    public static void monthlyUpcomingEnrolleesReport(List<Employee> employees) {
        // last day next month
        LocalDate lastDayNextMonth = LocalDate.now().plusMonths(1).plusDays(30 - LocalDate.now().getDayOfMonth());

        // get list of employees qualify for pension (have worked for 5y before last day of next month)
        List<Employee> upcomingEnrollees = employees.stream()
                .filter(employee -> employee.getPensionPlan() == null)
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isBefore(lastDayNextMonth))
                .collect(Collectors.toList());

        // print the data
        System.out.println("Monthly Upcoming Enrollees Report");
        printEmployeesInJson(upcomingEnrollees);
    }

    public static List<Employee> getEmployees() {
        return new ArrayList<Employee>(Arrays.asList(
                new Employee(1, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50,
                    new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100)),
                new Employee(2, "Benard", "Shaw", LocalDate.of(2018, 10, 3), 197750.00, null),
                new Employee(3, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75,
                    new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50)),
                new Employee(4, "Wesley", "Schneider", LocalDate.of(2018, 11, 2), 74500.00, null),

                // these data is added to check the monthly upcoming enrollees report
                new Employee(5, "John", "Zoe", LocalDate.of(2019, 5, 5), 150000.00, null),
                new Employee(6, "Mary", "Zoe", LocalDate.of(2019, 7, 5), 158000.00, null)
        ));
    }

    public static void printEmployeesInJson(List<Employee> employees) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .setPrettyPrinting()
                .create();

        System.out.println(gson.toJson(employees));
    }
}
