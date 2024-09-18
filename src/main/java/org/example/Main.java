package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
///commentary
public class Main {
    public static void main(String[] args) throws Exception {
        String[] paths = new String[]{
                "src/main/resources/data.xlsx",

        };
        ExcelReader excelReader = new ExcelReader("src/main/resources/data.xlsx");
        List<String> resLines = new ArrayList<>(excelReader.extractLines().subList(2,12));

        List<Individual> individuals = new ArrayList<>();
        List<Company> companies = new ArrayList<>();

        for(String line: resLines)
        {
            System.out.println(line.split(",").length);
            String [] line_from_table = line.split(",");
            System.out.println(Arrays.toString(line_from_table));
            int len_of_line = line.split(",").length;
            ///хардкод - обращение к атрибутам по индексу
            long id = (long)(Float.parseFloat(line_from_table[0]));
            String email = line_from_table[1];
            String phone = line_from_table[2];
            String address = line_from_table[3];
            ///согласно таблице 11 значений у Individuals(хардкод)
            if(len_of_line==11) {
                String name = line_from_table[4];
                String surname = line_from_table [5];
                boolean hasChildren = Boolean.parseBoolean(line_from_table[6]);
                int age = (int)(Float.parseFloat(line_from_table[7]));
                BankAccount bankAccount = new BankAccount(line_from_table[8], line_from_table[9],line_from_table[10]);
                individuals.add(new Individual(id,email,phone,address,bankAccount,name,surname,hasChildren,age));

            }
            ///согласно таблице 9 значений у Company(хардкод)
            if(len_of_line ==9)
            {
                String companyName = line_from_table[4];
                CompanyType type= CompanyType.valueOf(line_from_table[5]);
                BankAccount bankAccount = new BankAccount(line_from_table[6], line_from_table[7],line_from_table[8]);
                companies.add(new Company(id,email,phone,address,bankAccount,companyName,type));

            }

        }

        System.out.println(EmployeeManager.individualsLessAge(individuals,20));
        System.out.println(Individual.getCountOfIndividuals());
        System.out.println(Company.getCountOfCompanies());



    }
}