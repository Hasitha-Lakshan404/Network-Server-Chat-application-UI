import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : Hasitha Lakshan
 * Project :chatApplication
 * Date :8/3/2022
 * Time :8:48 AM
 */

public class ServerApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/ServerForm.fxml"))));
        primaryStage.setResizable(false);
        //primaryStage.getIcons().add(new Image("location"));
        primaryStage.setTitle("Server");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
