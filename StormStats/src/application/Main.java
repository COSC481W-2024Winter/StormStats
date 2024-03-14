package application;
	
import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("UIPrimary.fxml"));
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		testSqlite();
		launch(args);
	}

    public static void testSqlite() {
        // following the sample code: https://github.com/xerial/sqlite-jdbc?tab=readme-ov-file
        try
        (
            // create a database connection
            // the database file is downloaded from: https://edencoding.com/connect-javafx-with-sqlite/
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/resources/database.db");
            Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30); 
            //statement.executeUpdate("drop table if exists person");
            //statement.executeUpdate("create table person (id integer, name string)");
            //statement.executeUpdate("insert into person values(1, 'leo')");
            //statement.executeUpdate("insert into person values(2, 'yui')");
            //statement.executeUpdate("insert into person values(3, 'nick')");
            ResultSet rs = statement.executeQuery("select * from person");
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        }
        catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace(System.err);
        }
    }
	
	
	
	
	
	
}
