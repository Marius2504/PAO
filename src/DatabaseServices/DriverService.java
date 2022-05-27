package DatabaseServices;

import employee.driver;

import java.io.*;
import java.security.DigestInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverService implements Generic {
    //String name, String surname, String phone, String email, String password, Date birthDate, Integer overall, String ratings,Integer cr
    private static final DriverService INSTANCE = new DriverService();
    private DriverService(){}
    private static Connection connection;
    public static DriverService getInstance(Connection connection1)
    {
        connection = connection1;
        return INSTANCE;
    }
    @Override
    public void create(Object o) throws SQLException {
        driver car1 = (driver) o;
        String sql = "INSERT INTO driver(ID,NAME,SURNAME,PHONE,EMAIL,PASSWORD,BIRTHDATE,OVERALL,RATINGS,CAR)"
                +" VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,car1.getId());
        statement.setString(2,car1.getName());
        statement.setString(3,car1.getSurname());
        statement.setString(4,car1.getPhone());
        statement.setString(5,car1.getEmail());
        statement.setString(6,car1.getPassword());
        statement.setDate(7, car1.getBirthDate());
        statement.setInt(8,car1.getOverall());
        statement.setString(9,car1.getRatings());
        statement.setInt(10,car1.getCr());
        statement.executeUpdate();
    }

    @Override
    public ArrayList<Object> read() throws SQLException {
        ArrayList<Object> lista = new ArrayList<Object>();
        String sql = "SELECT * FROM driver";
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {
            lista.add((Object)new driver(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getString("SURNAME"),resultSet.getString("PHONE"),resultSet.getString("EMAIL"),resultSet.getString("PASSWORD"),resultSet.getDate("BIRTHDATE"),resultSet.getInt("OVERALL"),resultSet.getString("RATINGS"),resultSet.getInt("CAR")));
        }
        return lista;
    }

    @Override
    public void update(Object o) throws SQLException {
        driver car1 = (driver)o;
        String sql = "UPDATE driver SET NAME=?,SURNAME=?,PHONE=?,EMAIL=?,PASSWORD=?,BIRTHDATE=?,OVERALL=?,RATINGS=?,CAR=? WHERE ID =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,car1.getName());
        statement.setString(2,car1.getSurname());
        statement.setString(3,car1.getPhone());
        statement.setString(4,car1.getEmail());
        statement.setString(5,car1.getPassword());
        statement.setDate(6, car1.getBirthDate());
        statement.setInt(7,car1.getOverall());
        statement.setString(8,car1.getRatings());
        statement.setInt(9,car1.getCr());
        statement.setInt(10,car1.getId());
        statement.executeUpdate();
    }
    @Override
    public void delete(int index) throws SQLException {
        String sql = "DELETE FROM driver WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,index);
        statement.executeUpdate();
    }
}
