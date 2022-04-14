package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MySql {
static Connection conn;

static String user="root";
static String pass="Parola123!";

     static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/network",user,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insert(Person person) throws SQLException {
         PreparedStatement st=conn.prepareStatement("insert into contracts (first_name,last_name,adress,speed,bandwidth,duration) values(?,?,?,?,?,?)");
         st.setString(1,person.getFirstName());
         st.setString(2,person.getLastName());
         st.setString(3,person.getAddress());
         st.setInt(4,person.getSpeed());
         st.setString(5,person.getBandwidth());
         st.setString(6,person.getDuration());
         return st.execute();
    }
    public  ArrayList<Person> select() throws  SQLException{
        Statement st= conn.createStatement();
        st.executeQuery("Select * from contracts");
        ResultSet rs=st.getResultSet();
        ArrayList<Person> people=new ArrayList<>();
        while (rs.next()){
            Person person=new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
            people.add(person);
        }
        return people;

    }

    public boolean delete(Person person) throws SQLException {
         PreparedStatement st=conn.prepareStatement("delete from contracts where idcontracts=?");
         st.setInt(1,person.getId());
         return st.execute();
    }

    public boolean clearAll() throws SQLException{
         Statement st= conn.createStatement();
         return st.execute("truncate table contracts");

    }




}




