
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Controller.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume(); // consume the event to prevent the window from closing immediately

            // create the alert dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Keluar");
            alert.setHeaderText("Anda yakin ingin keluar?");
            alert.setContentText("Klik OK untuk keluar.");

            // show the alert and wait for the user response
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    // close the window
                    stage.close();
                }
            });
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

}