package DatabaseServices;

import company.employee;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements Generic {
    private static final EmployeeService INSTANCE = new EmployeeService();
    private EmployeeService(){}
    private static Connection connection;
    public static EmployeeService getINSTANCE(Connection connection1) {
        connection = connection1;
        return INSTANCE;
    }
    //String name, String surname, String phone, String email, String password, Date birthDate, Integer overall
    @Override
    public void create(Object o) throws SQLException {
        employee car1 = (employee) o;
        String sql = "INSERT INTO employee(ID,NAME,SURNAME,PHONE,EMAIL,PASSWORD,BIRTHDATE,OVERALL)"
                +" VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,car1.getId());
        statement.setString(2,car1.getName());
        statement.setString(3,car1.getSurname());
        statement.setString(4,car1.getPhone());
        statement.setString(5,car1.getEmail());
        statement.setString(6,car1.getPassword());
        statement.setDate(7, car1.getBirthDate());
        statement.setInt(8,car1.getOverall());
        statement.executeUpdate();
    }

    @Override
    public ArrayList<Object> read() throws SQLException {
        ArrayList<Object> lista = new ArrayList<Object>();
        String sql = "SELECT * FROM employee";
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {
            lista.add((Object)new employee(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getString("SURNAME"),resultSet.getString("PHONE"),resultSet.getString("EMAIL"),resultSet.getString("PASSWORD"),resultSet.getDate("BIRTHDATE"),resultSet.getInt("OVERALL")));
        }
        return lista;
    }

    @Override
    public void update(Object o) throws SQLException {
        employee car1 = (employee) o;
        String sql = "UPDATE employee SET NAME=?,SURNAME=?,PHONE=?,EMAIL=?,PASSWORD=?,BIRTHDATE=?,OVERALL=? WHERE ID =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,car1.getName());
        statement.setString(2,car1.getSurname());
        statement.setString(3,car1.getPhone());
        statement.setString(4,car1.getEmail());
        statement.setString(5,car1.getPassword());
        statement.setDate(6, car1.getBirthDate());
        statement.setInt(7,car1.getOverall());
        statement.setInt(8,car1.getId());
        statement.executeUpdate();
    }
    @Override
    public void delete(int index) throws SQLException {
        String sql = "DELETE FROM employee WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,index);
        statement.executeUpdate();
    }


    //String name, String surname, String phone, String email, String password, Date birthDate, List<Double> salaries, List<String> comments, Integer overall, Map<Integer, Boolean> workDays

}
