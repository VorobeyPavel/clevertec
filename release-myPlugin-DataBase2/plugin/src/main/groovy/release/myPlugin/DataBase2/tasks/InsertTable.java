package release.myPlugin.DataBase2.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import release.myPlugin.DataBase2.util.ReadSQLFile;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class InsertTable extends DefaultTask {

    @TaskAction
    public void insertDataBase() throws ClassNotFoundException {

        List<String> data = ReadSQLFile.readFile("data.sql");

        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clevertec",
                "postgres", "postgres")) {

            //String sql ="INSERT INTO cryptodb (name, symbol ) VALUES(?,?)";
            try(Statement statement = connection.createStatement()){
                for (String sql : data) {
                    statement.execute(sql);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
