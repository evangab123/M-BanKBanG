import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class pesanalert {
    private Alert alert;

    public void errorMessage(String message){

        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Pesan Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    public void successMessage(String message){

        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Pesan Informasi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }
}
