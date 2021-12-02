package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{

    public void getBook(){
        System.out.println("Мы берем книгу из UniLibrary\n");
    }

    public void returnBook(){
        System.out.println("Мы возвращаем книгу в UniLibrary\n");
    }

    public void getMagazine(){
        System.out.println("Мы берем журнал из UniLibrary\n");
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в UniLibrary");
    }

    public void addBook(){
        System.out.println("Мы добавляем книгу в UniLibrary");
    }

    public void addMagazine(){
        System.out.println("Мы добавляем журнал в UniLibrary");
    }
}
