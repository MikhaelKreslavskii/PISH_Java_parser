package org.example;

public class Company extends Employee {
    private String companyName;
    private CompanyType type;

    private static int count = 0;
    Company(long id,
            String email,
            String phone,
            String address,
            BankAccount bankAccount,
            String companyName,
            CompanyType type ) {
        super(id, email, phone, address, bankAccount);
        this.companyName=companyName;
        this.type=type;
        count++;
    }

    public static int getCountOfCompanies()
    {
        return count;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }
}