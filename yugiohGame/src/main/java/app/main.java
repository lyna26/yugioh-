package app;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

	/**
	 *Beginning of the program (Main)
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		FXMLLoader fxmlLoader;
	
		fxmlLoader = new FXMLLoader(new File("src/main/java/interfaces/mainMenu.fxml").toURI().toURL());
		Parent root  = fxmlLoader.load(); 
		primaryStage.setTitle("yugioh!");
		primaryStage.setScene(new Scene(root, 800, 800));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
