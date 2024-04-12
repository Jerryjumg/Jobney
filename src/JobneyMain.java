import java.io.IOException;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.user.AdminUser;


public class JobneyMain extends Application {

	@Override
	public void start(Stage primaryStage) {	
		
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginUI.fxml"));
	    loader.setController(new LoginController());
	    StackPane root = null;
	    
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    Scene scene = new Scene(root);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	

    public static void main(String[] args) {
        launch(args);
    }
	
}