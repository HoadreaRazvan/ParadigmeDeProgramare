import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Student
{
    private String nume;
    private Integer grupa;
    private List<Integer> note;

    public Student(String nume,Integer grupa,ArrayList<Integer> note)
    {
        this.nume=nume;
        this.grupa=grupa;
        this.note=note;
    }

    public Double media()
    {
        Integer s=0,n=0;
        for(Integer a : this.note) {
            a += s;
            n++;
        }
        return (double)s/n;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return this.toString().equals (obj.toString());
//    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nume, student.nume) && Objects.equals(grupa, student.grupa) && Objects.equals(note, student.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, grupa, note);
    }

    @Override
    public String toString() {
        return this.nume+"|"+this.grupa+"|"+this.note.get(0)+"|"+this.note.get(1)+"|"+this.note.get(2)+"|"+this.note.get(3)+"|"+this.note.get(4);
    }

    public Integer getGrupa() {
        return grupa;
    }

    public List<Integer> getNote() {
        return note;
    }

    public String getNume() {
        return nume;
    }

    public void setGrupa(Integer grupa) {
        this.grupa = grupa;
    }

    public void setNote(List<Integer> note) {
        this.note = note;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
