package Electricty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    public conn() throws SQLException {
       // step2 - here we are giving information of mysql and database
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","0000");
        s = c.createStatement();
    }
}
