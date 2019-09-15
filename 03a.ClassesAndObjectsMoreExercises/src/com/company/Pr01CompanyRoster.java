package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Pr01CompanyRoster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Department> departmentsList = new ArrayList<>();

        int lineIterations = Integer.parseInt(scanner.nextLine());

        while (lineIterations-- > 0) {
            String[] input = scanner.nextLine().split(" +");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String departmentName = input[3];
            String email = null;
            Integer age = null;

            switch (input.length) {
                case 5:
                    email = input[4].contains("@") ? input[4] : null;
                    age = !input[4].contains("@") ? Integer.parseInt(input[4]) : null;
                    break;
                case 6:
                    email = input[4];
                    age = Integer.parseInt(input[5]);
                    break;
            }


            if (departmentsList.stream().noneMatch(d -> d.departmentName.equals(departmentName))) {
                Department department = new Department(departmentName);
                departmentsList.add(department);
            }

            Employee employee = new Employee(name, salary, position, email, age);

            departmentsList.forEach(d -> {
                if (d.departmentName.equals(departmentName)) {
                    d.addEmployee(employee);
                }
            });

        }
        departmentsList.sort(Comparator.comparingDouble(a -> a.totalSalaries / a.employees.size()));

        Collections.reverse(departmentsList);

        Department bestDepartment = departmentsList.get(0);

        System.out.println("Highest Average Salary: " + bestDepartment.getDepartmentName());

        bestDepartment.employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        for (Employee employee : bestDepartment.employees) {
            System.out.println(String.format("%s %.2f %s %d",
                    employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));
        }
    }

    static class Department {
        String departmentName;
        double totalSalaries;
        List<Employee> employees = new ArrayList<>();

        public Department(String name) {
            this.departmentName = name;
        }

        public void addEmployee(Employee employee) {
            this.employees.add(employee);
            this.totalSalaries += employee.salary;
        }

        public String getDepartmentName() {
            return departmentName;
        }
    }

    static class Employee {
        String name;
        double salary;
        String position;
        String email;
        int age;

        public Employee(String name, double salary, String position, String email, Integer age) {
            setName(name);
            setSalary(salary);
            setPosition(position);
            setEmail(email);
            setAge(age);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            if (email == null) {
                this.email = "n/a";
                return;
            }
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(Integer age) {
            if (age == null) {
                this.age = -1;
                return;
            }
            this.age = age;
        }
    }
}
