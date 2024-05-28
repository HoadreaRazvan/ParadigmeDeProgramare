package org.example;

public class Credit {
private String data,descriere,debit,credit;

    public Credit(String data, String descriere, String debit,String credit) {
        this.data = data;
        this.descriere = descriere;
        this.debit = debit;
        this.credit=credit;
    }




    @Override
    public String toString() {
        return "data='" + data + '\'' +
                ", descriere='" + descriere + '\'' +
                ", debit='" + debit + '\'' +
                ", credit='" + credit + '\'';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
