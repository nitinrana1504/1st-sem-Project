import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {
    Connection connection;
    Statement statement;

    public Connector() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelMS", "root", "1234");
            this.statement = this.connection.createStatement();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}
