package menu;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.text.ParseException;

public class main {
    public static void main(String[] args) throws ParseException, ClassNotFoundException {

        Class.forName("oracle.jdbc.OracleDriver");

        String url = "jdbc:oracle:oci:admin/admin@localhost:1521:o11g";

        try {
            DriverManager.registerDriver(new OracleDriver());
            Connection connect =DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/o11g","admin","admin");
            main_menu mm = new main_menu();
            mm.start(connect);

        } catch (SQLException e) {
            System.out.println("Some problem in connection");
            e.printStackTrace();
        }

    }
}
