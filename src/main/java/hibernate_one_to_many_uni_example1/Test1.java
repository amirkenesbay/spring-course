package hibernate_one_to_many_uni_example1;

import hibernate_one_to_many_uni_example1.entity.Comment;
import hibernate_one_to_many_uni_example1.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Test1 {
    static Session session = null;
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure(new File("hibernate.cfg.xml"))
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Comment.class)
                .buildSessionFactory()){

//            addCommentToPostInfo(factory);
//            getCommentInfo(factory, 9);
//            deleteComment(factory, 9);

            System.out.println("Done!");
        } finally {
            session.close();
        }
    }

    public static void addCommentToPostInfo(SessionFactory factory){
        session = factory.getCurrentSession();
        Post post = new Post("Release of GTA VI");
        Comment comment = new Comment("I will play this game");
        Comment comment1 = new Comment("New engine?");
        post.addCommentToPost(comment);
        post.addCommentToPost(comment1);
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
    }

    public static void getCommentInfo(SessionFactory factory, int id){
        session = factory.getCurrentSession();
        session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        System.out.println(comment);
        session.getTransaction().commit();
    }

    public static void deleteComment(SessionFactory factory, int id){
        session = factory.getCurrentSession();
        session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        session.delete(comment);
        session.getTransaction().commit();
    }
}
