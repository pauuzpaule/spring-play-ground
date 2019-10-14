package com.sayrunjah;

import com.sayrunjah.Model.User;
import com.sayrunjah.dao.UserDao;
import com.sayrunjah.lib.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private TestAutoWire testAutoWire;

    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        //new Application().testAdd();
        SpringApplication.run(Application.class, args);

    }

    private  void testAdd() {
        //userDoA.createUser(new User("Pauuz", "1000"));
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(new User("Pauz", "100"));
        session.getTransaction().commit();
        session.close();
    }

    protected static void testDBConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb","root","");
          //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from users");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {
       // User user = userDao.find(1);
        userDao.updateUser(1, new User("Okayy", "95"));
       // System.out.println(user.getName());
        //userDao.createUser(new User("Sayrunjah", "1000"));
        /*userDao.details();
        for (User u:
             userDao.list()) {
            //userDao.updateUser(u);
            System.out.println(u.getName());
        }*/
        userDao.closeSession();
    }
}

@Component
class TestAutoWire {
    public void test() {
        System.out.println("Testing....");
    }
}
