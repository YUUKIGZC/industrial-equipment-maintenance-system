import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/industrial_equipment";
        String user = "root";
        String password = "123456";

        try {
            //Connection
            //    ↓
            //Statement
            //    ↓
            //executeQuery()
            //    ↓
            //ResultSet
            //    ↓
            //读取每一行数据
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("数据库连接成功！");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from devices");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("device_name"));
                System.out.println(resultSet.getString("device_type"));
                System.out.println(resultSet.getString("status"));
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }
}
