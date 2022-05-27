package DatabaseServices;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Generic<T>  {
    public void create(T t) throws SQLException;
    public ArrayList<T> read() throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(int index) throws SQLException;

}
