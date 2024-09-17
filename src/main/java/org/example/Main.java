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
            String [] arr = line.split(",");
            System.out.println(Arrays.toString(arr));
            int len_of_line = line.split(",").length;
            long id = (long)(Float.parseFloat(arr[0]));
            String email = arr[1];
            String phone = arr[2];
            String address = arr[3];

            if(len_of_line==11) {
                String name = arr[4];
                String surname = arr [5];
                boolean hasChildren = Boolean.parseBoolean(arr[6]);
                int age = (int)(Float.parseFloat(arr[7]));
                BankAccount bankAccount = new BankAccount(arr[8], arr[9],arr[10]);
                individuals.add(new Individual(id,email,phone,address,bankAccount,name,surname,hasChildren,age));

            }
            if(len_of_line ==9)
            {
                String companyName = arr[4];
                CompanyType type= CompanyType.valueOf(arr[5]);
                BankAccount bankAccount = new BankAccount(arr[6], arr[7],arr[8]);
                companies.add(new Company(id,email,phone,address,bankAccount,companyName,type));

            }

        }

        System.out.println(EmployeeManager.individualsLessAge(individuals,20));
        System.out.println(Individual.getCountOfIndividuals());
        System.out.println(Company.getCountOfCompanies());



    }
}