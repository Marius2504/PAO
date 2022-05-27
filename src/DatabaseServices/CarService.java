package DatabaseServices;

import employee.car;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarService implements Generic {
    private static final CarService INSTANCE = new CarService();
    private CarService(){}
    private static Connection connection;
    public static CarService getInstance(Connection connection1)
    {
        connection = connection1;
        return INSTANCE;
    }
    @Override
    public void create(Object o) throws SQLException {
        car car1 = (car)o;
        String sql = "INSERT INTO car(ID,BRAND,AVGCONSUM,TOTALKM,ISELECTRIC,HASCHILDSEAT)"
                    +" VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,car1.getId());
        statement.setString(2,car1.getBrand());
        statement.setFloat(3,car1.getAvgConsum());
        statement.setInt(4,car1.getTotalKm());
        if(car1.isElectric())
            statement.setInt(5,1);
        else
            statement.setInt(5,0);
        if(car1.isHasChildSeat())
            statement.setInt(6,1);
        else
            statement.setInt(6,0);
        statement.executeUpdate();
    }

    @Override
    public ArrayList<Object> read() throws SQLException {
        ArrayList<Object> lista = new ArrayList<Object>();
        String sql = "SELECT * FROM car";
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {
            boolean isE,hasC;
            if(resultSet.getInt("ISELECTRIC") == 1)
                isE = true;
            else
                isE = false;
            if(resultSet.getInt("HASCHILDSEAT") == 1)
                hasC = true;
            else
                hasC = false;
            lista.add((Object)new car(resultSet.getInt("ID"),resultSet.getString("BRAND"),resultSet.getFloat("AVGCONSUM"),resultSet.getInt("TOTALKM"),isE,hasC));
        }
        return lista;
    }

    @Override
    public void update(Object o) throws SQLException {
        car car1 = (car)o;
        String sql = "UPDATE car SET BRAND=?,AVGCONSUM=?,TOTALKM=?,ISELECTRIC=?,HASCHILDSEAT=? WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,car1.getBrand());
        statement.setFloat(2,car1.getAvgConsum());
        statement.setInt(3,car1.getTotalKm());
        statement.setInt(4,car1.getId());
        if(car1.isElectric())
            statement.setInt(5,1);
        else
            statement.setInt(5,0);
        if(car1.isHasChildSeat())
            statement.setInt(6,1);
        else
            statement.setInt(6,0);
        statement.executeUpdate();
    }
    @Override
    public void delete(int index) throws SQLException {
        String sql = "DELETE FROM car WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,index);
        statement.executeUpdate();
    }
}

