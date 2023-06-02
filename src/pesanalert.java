import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;

public class pesanalert {
    private Alert alert;

    public void errorMessage(String message){

        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Pesan Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setPrefSize(400, 100);

        alert.showAndWait();

    }

    public void successMessage(String message){

        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Pesan Informasi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setPrefSize(400, 100);
        alert.showAndWait();

    }
}
