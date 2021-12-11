package aop;

public class Student {
    private String nameSurname;
    private int count;
    private double avgGrade;

    public Student(String nameSurname, int count, double avgGrade) {
        this.nameSurname = nameSurname;
        this.count = count;
        this.avgGrade = avgGrade;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "\n" + "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", count=" + count +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
