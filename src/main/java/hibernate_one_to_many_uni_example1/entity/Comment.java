package hibernate_one_to_many_uni_example1.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "review")
    private String review;

    public Comment() {
    }

    public Comment(String review) {
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", review='" + review + '\'' +
                '}';
    }
}
