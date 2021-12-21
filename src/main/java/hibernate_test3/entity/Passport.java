package hibernate_test3.entity;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "issue_year")
    private int issueYear;

    @Column(name = "valid_year")
    private int validYear;

    @OneToOne(mappedBy = "passportDetail"
            ,cascade = CascadeType.ALL)
    private Person person;

    public Passport(){
    }

    public Passport(int issueYear, int validYear) {
        this.issueYear = issueYear;
        this.validYear = validYear;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public int getValidYear() {
        return validYear;
    }

    public void setValidYear(int validYear) {
        this.validYear = validYear;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", issueYear=" + issueYear +
                ", validYear=" + validYear +
                '}';
    }
}
