package Seminar4.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DirEmpl {
//    Задание 1. Создать справочник сотрудников

//    Необходимо:
//    ● Создать класс справочник сотрудников, который
//    содержит внутри коллекцию сотрудников - каждый
//    сотрудник должен иметь следующие атрибуты:
//            ○ Табельный номер
//            ○ Номер телефона
//            ○ Имя
//            ○ Стаж
//  ● Добавить метод, который ищет сотрудника по стажу
//  (может быть список)
//  ● Добавить метод, который выводит номер телефона
//  сотрудника по имени (может быть список)
//  ● Добавить метод, который ищет сотрудника по
//   табельному номеру
//  ● Добавить метод добавление нового сотрудника в
//   справочник
    public static void main(String[] args) {
        for (Employee employee:employees) {
            System.out.println("Сотрудник "+employee.getName());
        }

        for (Employee employee:findByExperience(2) ) {
            System.out.println("Сотрудник с именем "+employee.getName()+" имеет стаж: "+employee.getExperience());
        }
        findNumberByName("Nina");
        Employee emp1 = findByPersonnalNum("67854");
        System.out.println(emp1.getName());
        addNewEmployee();

        for (Employee employee:employees) {
            System.out.println("Сотрудник "+employee.getName());
        }

    }
    public static  List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee("Kate","3456","456865",7),
        new Employee("Tanya","67854","67765456",2),new Employee("Nina","5674","56774332",2)));
    public static List<Employee> findByExperience(int exp){
        return employees.stream().filter(e -> e.Experience == exp).collect(Collectors.toList());
    }
    public static void findNumberByName( String name){
        List<Employee> newList = employees.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());

        for (Employee employee: newList) {
            System.out.println("Сотрудник с именем "+employee.getName()+" имеет номер: "+employee.getPhoneNumber());
        }
    }

    public static Employee findByPersonnalNum(String persNum){
        return employees.stream().filter(e -> e.getPersonnelNumber().equals(persNum)).findFirst().orElse(null);
    }
    public static void addNewEmployee(){
        System.out.println("Введите имя нового сотрудника");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Введите номер телефона нового сотрудника");
        String number = scanner.nextLine();
        System.out.println("Введите табельный номер нового сотрудника");
        String persNum = scanner.nextLine();
        System.out.println("Введите стаж работы нового сотрудника");
        int exp = scanner.nextInt();
        Employee newEmp = new Employee(name,persNum,number,exp);
        employees.add(newEmp);


    }

}
