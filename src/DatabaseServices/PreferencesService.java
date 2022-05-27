package DatabaseServices;

import client.preferences;

import java.sql.*;
import java.util.ArrayList;

public class PreferencesService implements Generic {
    private static final PreferencesService INSTANCE = new PreferencesService();
    private static Connection connection;
    private PreferencesService() { }
    public static PreferencesService getINSTANCE(Connection connection1) {
        connection = connection1;
        return INSTANCE;
    }
    @Override
    public void create(Object o) throws SQLException {
        preferences car1 = (preferences) o;
        String sql = "INSERT INTO preference(ID,TYPEOFCAR,PAYMENTMETHOD,HOMELOCATION,REGID)"
                +" VALUES(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,car1.getId());
        statement.setString(2,car1.getTypeOfCar());
        statement.setString(3,car1.getPaymentMethod());
        statement.setString(4,car1.getHomeLocation());
        statement.setInt(5,car1.getRegId());
        statement.executeUpdate();
    }

    @Override
    public ArrayList<Object> read() throws SQLException {
        ArrayList<Object> lista = new ArrayList<Object>();
        String sql = "SELECT * FROM preference";
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {
            lista.add((Object)new preferences(resultSet.getInt("ID"),resultSet.getString("TYPEOFCAR"),resultSet.getString("PAYMENTMEYHOD"),resultSet.getString("HOMELOCATION"),resultSet.getInt("REGID")));
        }
        return lista;
    }

    @Override
    public void update(Object o) throws SQLException {
        preferences car1 = (preferences) o;
        String sql = "UPDATE car SET ID=?,TYPEOFCAR=?,PAYMENTMEYHOD=?,HOMELOCATION=?,REGID=? WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,car1.getTypeOfCar());
        statement.setString(2,car1.getPaymentMethod());
        statement.setString(3,car1.getHomeLocation());
        statement.setInt(4,car1.getRegId());
        statement.setInt(5,car1.getId());
        statement.executeUpdate();
    }
    @Override
    public void delete(int index) throws SQLException {
        String sql = "DELETE FROM preference WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,index);
        statement.executeUpdate();
    }



}
