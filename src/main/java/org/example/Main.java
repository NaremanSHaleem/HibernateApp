package org.example;
import org.example.Model.Alien;
import org.example.Model.Laptop;
import org.example.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main(String[] args) {
        System.out.println("HELLO!");
        Student student = new Student();
        student.setName("Enju");
        student.setAge(20);
        student.setRollNo(105);

        Student student2 = null;

        Configuration config = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();



//        **Save data in DB**
//        Transaction transaction = session.beginTransaction(); // needed when update in DB
//        session.persist(student);
//        transaction.commit();

//        **Fetch data from DB**
//        student2 = session.find(Student.class, 101);

//        **Update data in DB**
//        Student student3 = new Student();
//        student3.setName("Enjy");
//        student3.setAge(20);
//        student3.setRollNo(105);
        Transaction transaction = session.beginTransaction(); // needed when update in DB
//        session.merge(student3);
//        transaction.commit();

//        **Delete data from DB**
//        Student student4 = new Student();
//        student4.setName("Mona");
//        student4.setAge(30);
//        student4.setRollNo(109);
//        student4 = session.find(Student.class, 109);
//        session.remove(student4);

//      **Change table and column names and exclude columns from saving in DB(Alien class)**
//        Alien alien = new Alien();
//        alien.setName("Alien");
//        alien.setAge(20);
//        alien.setGender("Male");
//        alien.setTech("Java");
//        alien = (Alien) session.merge(alien);

//       **OneToOne Relationship**
        Laptop laptop = new Laptop();
        laptop.setId(1);
        laptop.setBrand("HP");
        laptop.setModel("Pavilion");
        laptop.setRam(8);
        Alien alien = new Alien();
        alien.setId(101);
        alien.setName("Karin");
        alien.setAge(20);
        alien.setGender("Female");
        alien.setTech("C++");
        alien.setLaptop(laptop);

        session.persist(laptop);
        session.persist(alien);



        transaction.commit();
        System.out.println(alien);
        session.close();
        sessionFactory.close();
    }
}
