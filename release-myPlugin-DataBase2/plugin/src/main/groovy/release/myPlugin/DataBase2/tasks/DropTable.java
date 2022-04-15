package release.myPlugin.DataBase2.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import release.myPlugin.DataBase2.util.ReadSQLFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropTable extends DefaultTask{

    @TaskAction
    public void dropDataBase() throws ClassNotFoundException {
        String sqlDropTable = ReadSQLFile.readFile("schema.sql").get(1);

        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clevertec",
                "postgres", "postgres")) {
            try(PreparedStatement ps = connection.prepareStatement(sqlDropTable)){
                ps.executeUpdate();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
