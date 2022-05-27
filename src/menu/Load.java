package menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Load {
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:o11g";

    static final String USERNAME = "admin";
    static final String PASSWORD = "admin";
    public void get()
    {
        Load jdbcOracleDemo = new Load();
        jdbcOracleDemo.getData();

    }
    private void getData()
    {
        Connection connection = null;
        Statement stmt = null;
        try
        {
            /*
             * STEP 1: Register JDBC driver
             */
            Class.forName(JDBC_DRIVER);

            /*
             * STEP 2: Open a connection
             */
            System.out.println("Connecting to database...");
            connection = DriverManager
                    .getConnection(DB_URL, USERNAME, PASSWORD);

            /*
             * STEP 3: Execute a query
             */
            System.out.println("Creating statement...");

            System.out
                    .println("-----------------------------------------------------");

            stmt = connection.createStatement();
            String sql = "select * from DRIVER";
            ResultSet rs = stmt.executeQuery(sql);

            /*
             * STEP 4: Extract data from result set
             */
            while (rs.next())
            {
                /*
                 * Retrieve by column name
                 */
                int id = rs.getInt("Id");
                String firstName = rs.getString("Ratings");
                int car = rs.getInt("Car");

                /*
                 * Display values
                 */
                System.out.print("ID: " + id);
                System.out.print(", Ratings: " + firstName);
                System.out.print(", Car: " + car);
            }
            /*
             * STEP 5: close resources
             */
            rs.close();

        }
        catch (SQLException se)
        {
            /*
             * Handle errors for JDBC
             */
            se.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            /*
             * Handle errors for Class.forName
             */
            e.printStackTrace();
        }
        finally
        {
            /*
             * finally block used to close resources
             */
            try
            {
                if (stmt != null)
                {
                    stmt.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            try
            {
                if (connection != null)
                {
                    connection.close();
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }

    }
}
