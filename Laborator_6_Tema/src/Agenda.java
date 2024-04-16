public class Agenda {
    private String nume,prenume,nrTelefon,tipNrTelefon;

    public Agenda(String nume,String prenume,String nrTelefon,String tipNrTelefon)
    {
        this.nume=nume;
        this.prenume=prenume;
        this.nrTelefon=nrTelefon;
        this.tipNrTelefon=tipNrTelefon;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", nrTelefon='" + nrTelefon + '\'' +
                ", tipNrTelefon='" + tipNrTelefon + '\'' +
                '}';
    }

    

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getTipNrTelefon() {
        return tipNrTelefon;
    }

    public void setTipNrTelefon(String tipNrTelefon) {
        this.tipNrTelefon = tipNrTelefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
