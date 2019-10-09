package com.sayrunjah;

import com.sayrunjah.Model.User;
import com.sayrunjah.dao.user.UserServiceImpl;
import com.sayrunjah.lib.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new Application().testAdd();
        //SpringApplication.run(Application.class, args);
    }

    private  void testAdd() {
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
}
