import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    private static ArrayList<Account> Accounts= new ArrayList<Account>();
    @FXML
    private Button btn_buat_buat;

    @FXML
    private Button btn_informasiAkun;

    @FXML
    private Button btn_keluar;

    @FXML
    private Button btn_log_ogin;

    @FXML
    private Button btn_payment;

    @FXML
    private Button btn_setting;

    @FXML
    private Button btn_transfer;

    @FXML
    private Button buat_login;

    @FXML
    private AnchorPane buatakun_form;



    @FXML
    private Label label_welcome;

    @FXML
    private Button login_buat;

    @FXML
    private AnchorPane login_form;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField tf_buat_email;

    @FXML
    private TextField tf_buat_kelamin;

    @FXML
    private PasswordField tf_buat_konfirmpin;

    @FXML
    private PasswordField tf_buat_mpin;

    @FXML
    private TextField tf_buat_namalengkap;

    @FXML
    private TextField tf_buat_username;

    @FXML
    private TextField tf_log_username;

    @FXML
    private PasswordField tf_log_konfirmasimpin;

    @FXML
    private PasswordField tf_log_mpin;

    public static ArrayList<Account> getAccounts() {
        return Accounts;
    }

    public void hilangkolom() {
        tf_buat_namalengkap.setText("");
        tf_buat_email.setText("");
        tf_buat_username.setText("");
        tf_buat_mpin.setText("");
        tf_buat_konfirmpin.setText("");
        tf_buat_kelamin.setText("");
        tf_log_username.setText("");
        tf_log_mpin.setText("");
        tf_log_konfirmasimpin.setText("");
        }
    public boolean register(ActionEvent event) {
        if (tf_buat_username.getText().isEmpty() || tf_buat_email.getText().isEmpty() || tf_buat_mpin.getText().isEmpty()
                || tf_buat_konfirmpin.getText().isEmpty()||tf_buat_namalengkap.getText().isEmpty()||tf_buat_kelamin.getText().isEmpty()) {
            pesanalert alert = new pesanalert();
            alert.errorMessage("Tolong isi semua kolom yang tersedia");
            return false;
        } else if (tf_buat_mpin.getText().equals(tf_buat_konfirmpin.getText())) {
            Customer Cust = new Customer(tf_buat_email.getText(),tf_buat_namalengkap.getText(),tf_buat_kelamin.getText());
            Account acc = new Account(tf_buat_username.getText(),Cust,tf_buat_mpin.getText());
            Accounts.add(acc);
            pesanalert alert = new pesanalert();
            alert.successMessage("Terima kasih,"+acc.getUsername()+"Kamu Berhasil membuat Akun\n No Rekening anda: "+acc.getNoRekening());
            buatakun_form.setVisible(false);
            login_form.setVisible(true);
            hilangkolom();
            return true;
        } else {
            pesanalert alert = new pesanalert();
            alert.errorMessage("PIN dengan konfirmasi pin tidak cocok");
            return false;
        }
    }
    public void login(ActionEvent event){
        if (tf_log_username.getText().isEmpty() || tf_log_mpin.getText().isEmpty() || tf_log_konfirmasimpin.getText().isEmpty()) {
            pesanalert alert = new pesanalert();
            alert.errorMessage("Tolong isi semua kolom yang tersedia");

        } else if (tf_log_mpin.getText().equals(tf_log_konfirmasimpin.getText())) {
            for(Account acc : Accounts){
                if(tf_log_username.getText().equals(acc.getUsername()) && tf_log_mpin.getText().equals(acc.getMpin())){
                    if(acc.isBlokir()==false){
                        pesanalert alert = new pesanalert();
                        alert.successMessage("Berhasil masuk");
                        buatakun_form.setVisible(false);
                        login_form.setVisible(false);
                        Util.gantiScene(event,"Home.fxml",acc);
                        break;
                    }else {
                        pesanalert alert = new pesanalert();
                        alert.errorMessage("Akun telah di blokir!");
                        break;
                    }
                }
            }
            hilangkolom();
        }else{
            pesanalert alert = new pesanalert();
            alert.errorMessage("PIN dengan konfirmasi pin tidak cocok");
        }
    }
        @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == buat_login || event.getSource() == btn_keluar) {
            buatakun_form.setVisible(false);
            login_form.setVisible(true);
            hilangkolom();
        } else if (event.getSource() == login_buat) {
            buatakun_form.setVisible(true);
            login_form.setVisible(false);
        }
    }


}
