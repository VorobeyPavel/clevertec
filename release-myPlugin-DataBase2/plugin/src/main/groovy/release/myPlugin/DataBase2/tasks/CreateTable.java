package release.myPlugin.DataBase2.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import release.myPlugin.DataBase2.util.ReadSQLFile;

import java.sql.*;
import java.util.Date;

public class CreateTable extends DefaultTask {

    @TaskAction
    public void createTable() throws ClassNotFoundException {
        String sqlCreateTable = ReadSQLFile.readFile("schema.sql").get(0);

        System.out.println(sqlCreateTable);

        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clevertec",
                "postgres", "postgres")) {

            try(Statement statement = connection.createStatement()){
                statement.execute(sqlCreateTable);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
