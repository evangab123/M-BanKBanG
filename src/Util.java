import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Util {
    public static void gantiScene(ActionEvent event, String fxmlfile, Account acc){
        if(acc != null){
            try{
                FXMLLoader loader = new FXMLLoader(Util.class.getResource(fxmlfile));
                Parent root = loader.load();
                Home home = loader.getController();
                home.setupuser(acc);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            try{
                Parent root= FXMLLoader.load(Util.class.getResource(fxmlfile));
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
