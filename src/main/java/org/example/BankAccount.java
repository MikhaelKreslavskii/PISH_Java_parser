package org.example;

public class BankAccount {
    private String iban;
    private String bic;
    private String accountHolder;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    BankAccount(String iban, String bic, String accountHolder)
    {
        this.iban=iban;
        this.bic = bic;
        this.accountHolder = accountHolder;
    }

}