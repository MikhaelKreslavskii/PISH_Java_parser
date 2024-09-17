package org.example;

import java.util.List;

public class EmployeeManager {
    public static int individualsLessAge(List<Individual> individualList, int age)
    {
        int count = 0;
        for(Individual person: individualList)
        {
            if(person.getAge()<=age)
            {
                count++;
            }
        }
        return count;
    }

}