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

    public void register(ActionEvent event) {
        if (tf_buat_username.getText().isEmpty() || tf_buat_email.getText().isEmpty() || tf_buat_mpin.getText().isEmpty()
                || tf_buat_konfirmpin.getText().isEmpty() || tf_buat_namalengkap.getText().isEmpty() || tf_buat_kelamin.getText().isEmpty()) {
            pesanalert alert = new pesanalert();
            alert.errorMessage("Tolong isi semua kolom yang tersedia");

        } else if (tf_buat_email.getText().matches(".+@gmail.com")) {
            if (tf_buat_konfirmpin.getText().matches("^[0-9]{8}$")) {
                if (tf_buat_kelamin.getText().equals("L") || tf_buat_kelamin.getText().equals("P")) {
                    if (tf_buat_mpin.getText().equals(tf_buat_konfirmpin.getText())) {
                        if(Accounts.size()>0){
                            for(Account acc : Accounts){
                                if(tf_buat_username.getText().equals(acc.getUsername())){
                                    pesanalert alert = new pesanalert();
                                    alert.errorMessage("maaf username telah dipakai");
                                    break;

                                }else{
                                    Customer Cust = new Customer(tf_buat_email.getText(), tf_buat_namalengkap.getText(), tf_buat_kelamin.getText());
                                    Account newacc = new Account(tf_buat_username.getText(), Cust, tf_buat_mpin.getText());
                                    Accounts.add(newacc);
                                    pesanalert alert = new pesanalert();
                                    alert.successMessage("Terima kasih, " + newacc.getCust().getNamalengkap() + "! Kamu Berhasil membuat Akun\n No Rekening anda: " + newacc.getNoRekening());
                                    buatakun_form.setVisible(false);
                                    login_form.setVisible(true);
                                    hilangkolom();
                                    break;
                                }
                            }
                        }else{
                            Customer Cust = new Customer(tf_buat_email.getText(), tf_buat_namalengkap.getText(), tf_buat_kelamin.getText());
                            Account newacc = new Account(tf_buat_username.getText(), Cust, tf_buat_mpin.getText());
                            Accounts.add(newacc);
                            pesanalert alert = new pesanalert();
                            alert.successMessage("Terima kasih, " + newacc.getCust().getNamalengkap() + "! Kamu Berhasil membuat Akun\n No Rekening anda: " + newacc.getNoRekening());
                            buatakun_form.setVisible(false);
                            login_form.setVisible(true);
                            hilangkolom();

                        }


                    } else {
                        pesanalert alert = new pesanalert();
                        alert.errorMessage("PIN dengan konfirmasi pin tidak cocok");

                    }
                } else {
                    pesanalert alert = new pesanalert();
                    alert.errorMessage("Isi Jenis Kelamin hanya dengan L/P saja!");

                }
            } else {
                pesanalert alert = new pesanalert();
                alert.errorMessage("MPIN harus berisi 8 buah angka saja!");

            }
        } else {
            pesanalert alert = new pesanalert();
            alert.errorMessage("Email tidak valid! cth valid(ukdw@gmail.com)");

        }
    }
    public void login(ActionEvent event){
        boolean checker = false;
        if (tf_log_username.getText().isEmpty() || tf_log_mpin.getText().isEmpty() || tf_log_konfirmasimpin.getText().isEmpty()) {
            pesanalert alert = new pesanalert();
            alert.errorMessage("Tolong isi semua kolom yang tersedia");

        } else if (tf_log_mpin.getText().equals(tf_log_konfirmasimpin.getText())) {
            for(Account acc : Accounts){
                if(tf_log_username.getText().equals(acc.getUsername()) && tf_log_mpin.getText().equals(acc.getMpin())){
                    if(acc.isBlokir()==false){
                        checker = true;
                        buatakun_form.setVisible(false);
                        login_form.setVisible(false);
                        Util.gantiScene(event,"Home.fxml",acc);
                        break;
                    }
                }
            }
            if(checker){
                pesanalert alert = new pesanalert();
                alert.successMessage("Berhasil masuk");
            }else if(checker == false){
                pesanalert alert = new pesanalert();
                alert.errorMessage("Username atau password salah atau akun telah diblokir");
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
