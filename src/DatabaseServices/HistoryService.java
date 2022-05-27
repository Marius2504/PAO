package DatabaseServices;

import client.history;

import java.sql.*;
import java.util.ArrayList;

public class HistoryService implements Generic {
    private static final HistoryService INSTANCE = new HistoryService();
    HistoryService(){}
    private static Connection connection;
    public static HistoryService getINSTANCE(Connection connection1) {
        connection = connection1;
        return INSTANCE;
    }
    @Override
    public void create(Object o) throws SQLException {
        history car1 = (history) o;
        String sql = "INSERT INTO history(ID,PRICE,STARTLOCATION,ENDLOCATION,TODAYDATE,REGID)"
                +" VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,car1.getId());
        statement.setDouble(2,car1.getId());
        statement.setString(3,car1.getStartLocation());
        statement.setString(4,car1.getEndLocation());
        statement.setDate(5,car1.getDate());
        statement.setInt(6,car1.getRegId());
        statement.executeUpdate();
    }

    @Override
    public ArrayList<Object> read() throws SQLException {
        ArrayList<Object> lista = new ArrayList<Object>();
        String sql = "SELECT * FROM history";
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next())
        {//double price, String startLocation, String endLocation, Date date, Integer regId
            lista.add((Object)new history(resultSet.getInt("ID"),resultSet.getDouble("PRICE"),resultSet.getString("STARTLOCATION"),resultSet.getString("ENDLOCATION"),resultSet.getDate("TODAYDATE"),resultSet.getInt("REGID")));
        }
        return lista;
    }

    @Override
    public void update(Object o) throws SQLException {
        history car1 = (history) o;
        String sql = "UPDATE history SET PRICE=?,STARTLOCATION=?,ENDLOCATION=?,TODAYDATE=?REGID=? WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setDouble(1,car1.getPrice());
        statement.setString(2,car1.getStartLocation());
        statement.setString(3,car1.getEndLocation());
        statement.setDate(4,car1.getDate());
        statement.setInt(5,car1.getRegId());
        statement.setInt(6,car1.getId());
        statement.executeUpdate();
    }
    @Override
    public void delete(int index) throws SQLException {
        String sql = "DELETE FROM history WHERE ID=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,index);
        statement.executeUpdate();
    }
}
