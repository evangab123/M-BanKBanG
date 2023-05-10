import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Home implements Initializable {

    @FXML
    private Label Label_saldo;

    @FXML
    private AnchorPane Main_page;

    @FXML
    private AnchorPane blokir_page;

    @FXML
    private AnchorPane bpjs_page;

    @FXML
    private Button btn_blokir;

    @FXML
    private Button btn_blokir_set;

    @FXML
    private Button btn_bpjs;

    @FXML
    private Button btn_bpjs_bayar;

    @FXML
    private Button btn_ceksaldo;

    @FXML
    private Button btn_informasiAkun;

    @FXML
    private Button btn_keluar;

    @FXML
    private Button btn_kembali;

    @FXML
    private Button btn_kembali_blokir;

    @FXML
    private Button btn_kembali_bpjs;

    @FXML
    private Button btn_kembali_limit;

    @FXML
    private Button btn_kembali_mpayment;

    @FXML
    private Button btn_kembali_mtransfer;

    @FXML
    private Button btn_kembali_mutasi;

    @FXML
    private Button btn_kembali_pln;

    @FXML
    private Button btn_kembali_saldo;

    @FXML
    private Button btn_kembali_setting;

    @FXML
    private Button btn_limit;

    @FXML
    private Button btn_limit_set;

    @FXML
    private Button btn_listrik;

    @FXML
    private Button btn_manajemen;

    @FXML
    private Button btn_mpayment;

    @FXML
    private Button btn_mtransfer;

    @FXML
    private Button btn_mutasi;

    @FXML
    private Button btn_pln_bayar;

    @FXML
    private Button btn_setting;

    @FXML
    private Button btn_transfer;

    @FXML
    private AnchorPane cekSaldo_page;

    @FXML
    private AnchorPane home_page;

    @FXML
    private AnchorPane inform_page;

    @FXML
    private TableColumn<Payment, String> kolom_jd;

    @FXML
    private TableColumn<Payment, String> kolom_jenis;

    @FXML
    private TableColumn<Payment, Integer> kolom_nominal;

    @FXML
    private TableColumn<Payment, String> kolom_tanggal;

    @FXML
    private Label label_limithelp;

    @FXML
    private Label label_norek;

    @FXML
    private Label label_welcome;

    @FXML
    private AnchorPane limit_page;

    @FXML
    private AnchorPane mtransfer_page;

    @FXML
    private AnchorPane mutasi_page;

    @FXML
    private AnchorPane payment_page;

    @FXML
    private AnchorPane pln_page;

    @FXML
    private AnchorPane setting_page;

    @FXML
    private TableView<Payment> table_mutasi;

    @FXML
    private PasswordField tf_blokir_mpin;

    @FXML
    private PasswordField tf_bpjs_mpin;

    @FXML
    private TextField tf_bpjs_nominal;

    @FXML
    private TextField tf_limit;

    @FXML
    private PasswordField tf_limit_mpin;

    @FXML
    private PasswordField tf_pln_mpin;

    @FXML
    private TextField tf_pln_nominal;




    private Account account;
    private ObservableList<Payment> dataakun;

    public void clearTabledata(){
        table_mutasi.getItems().clear();
    }
    public void setTable_mutasi(){
        dataakun = FXCollections.observableArrayList(this.getAccount().getPay());
        table_mutasi.setItems(dataakun);
        kolom_jd.setCellValueFactory(new PropertyValueFactory<>("no_payment"));
        kolom_nominal.setCellValueFactory(new PropertyValueFactory<>("nominal"));
        kolom_tanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        kolom_jenis.setCellValueFactory(new PropertyValueFactory<>("jenis_payment"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setupuser(Account acc){
        this.account = acc;
        label_welcome.setText("Selamat datang,"+this.getAccount().getCust().getNamalengkap()+"!!");
    }
    @FXML
    void keluar(ActionEvent event) {
        this.clearTabledata();
        Util.gantiScene(event,"Controller.fxml",null);
    }


    public void switchForm(ActionEvent event) {
        if (event.getSource() == btn_informasiAkun || event.getSource()==btn_kembali_mutasi) {
            home_page.setVisible(false);
            inform_page.setVisible(true);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
            label_norek.setText("No. Rekening Anda : "+this.getAccount().getNoRekening());
            label_limithelp.setText("Limit anda hari ini:"+this.getAccount().getLimithelper());
        } else if (event.getSource() == btn_kembali||event.getSource() == btn_kembali_setting|| event.getSource() == btn_kembali_mtransfer|| event.getSource()== btn_kembali_mpayment) {
            home_page.setVisible(true);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        } else if (event.getSource() == btn_kembali_saldo) {
            home_page.setVisible(false);
            inform_page.setVisible(true);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        } else if (event.getSource() == btn_setting) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(true);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        } else if(event.getSource() == btn_kembali_blokir || event.getSource() == btn_kembali_limit){
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(true);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        } else if (event.getSource() == btn_blokir) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(true);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        } else if (event.getSource() == btn_limit) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(true);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        } else if (event.getSource() == btn_mtransfer) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(true);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        } else if (event.getSource() == btn_kembali_bpjs ||  event.getSource()== btn_kembali_pln) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(true);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        }else if (event.getSource() == btn_mpayment) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(true);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        }else if (event.getSource() == btn_bpjs) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(true);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);
        }else if (event.getSource() == btn_listrik) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(true);
            mutasi_page.setVisible(false);
        } else if (event.getSource()==btn_mutasi) {
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(false);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(true);
            this.setTable_mutasi();
        }
    }

    public void cekSaldo(ActionEvent event){
        home_page.setVisible(false);
        inform_page.setVisible(false);
        cekSaldo_page.setVisible(true);
        Label_saldo.setText(formatRupiah((int) this.getAccount().getSaldo()));

    }
    public static String formatRupiah(int nominal) {
        String str = String.valueOf(nominal);
        Double rupiah = Double.parseDouble(str);
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(rupiah);
    }
    public void Limit(ActionEvent event){
        if (tf_limit.getText().isEmpty() || tf_limit_mpin.getText().isEmpty()) {
            pesanalert alert = new pesanalert();
            alert.errorMessage("Tolong isi semua kolom yang tersedia");
        } else if (tf_limit_mpin.getText().equals(this.getAccount().getMpin())) {
            this.getAccount().setLimit(Integer.parseInt(tf_limit.getText()));
            this.getAccount().setLimithelper(Integer.parseInt(tf_limit.getText()));
            pesanalert alert = new pesanalert();
            alert.successMessage("berhasil set limit");
            tf_limit_mpin.setText("");
            tf_limit.setText("");
            home_page.setVisible(false);
            inform_page.setVisible(false);
            cekSaldo_page.setVisible(false);
            setting_page.setVisible(true);
            blokir_page.setVisible(false);
            limit_page.setVisible(false);
            mtransfer_page.setVisible(false);
            payment_page.setVisible(false);
            bpjs_page.setVisible(false);
            pln_page.setVisible(false);
            mutasi_page.setVisible(false);

        }else{
            pesanalert alert = new pesanalert();
            alert.errorMessage("MPIN anda salah");
        }
    }
    public void Blokir(ActionEvent event) {
        if (tf_blokir_mpin.getText().isEmpty()) {
            pesanalert alert = new pesanalert();
            alert.errorMessage("Tolong isi M-PIN");
        }else if (tf_blokir_mpin.getText().equals(this.getAccount().getMpin())) {
            this.getAccount().setBlokir(true);
            tf_blokir_mpin.setText("");
            Util.gantiScene(event,"Controller.fxml",null);
        }else{
            pesanalert alert = new pesanalert();
            alert.errorMessage("MPIN anda salah");
        }
    }
    public void Bayar(ActionEvent event) {
        if (bpjs_page.isVisible() == true) {
            if (tf_bpjs_nominal.getText().isEmpty() || tf_bpjs_mpin.getText().isEmpty()) {
                pesanalert alert = new pesanalert();
                alert.errorMessage("Tolong isi semua kolom yang tersedia");
            } else if (tf_bpjs_mpin.getText().equals(this.getAccount().getMpin())) {
                if (this.getAccount().getSaldo() >= Double.parseDouble(tf_bpjs_nominal.getText())) {
                    if (this.getAccount().getLimit() >= Double.parseDouble(tf_bpjs_nominal.getText())) {
                        this.getAccount().setLimit((int) (this.getAccount().getLimit()-Double.parseDouble(tf_bpjs_nominal.getText())));
                        this.getAccount().setSaldo(this.getAccount().getSaldo() - Double.parseDouble(tf_bpjs_nominal.getText()));
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        LocalDateTime now = LocalDateTime.now();
                        Payment pay = new Payment("bpjs", Double.parseDouble(tf_bpjs_nominal.getText()), dtf.format(now));
                        this.getAccount().getPay().add(pay);
                        pesanalert alert = new pesanalert();
                        alert.successMessage("berhasil membayar\n sisa limit anda "+this.getAccount().getLimit()+"\nnomor pembayaran anda "+pay.getNo_payment());
                        tf_bpjs_nominal.setText("");
                        tf_bpjs_mpin.setText("");
                        home_page.setVisible(false);
                        inform_page.setVisible(false);
                        cekSaldo_page.setVisible(false);
                        setting_page.setVisible(false);
                        blokir_page.setVisible(false);
                        limit_page.setVisible(false);
                        mtransfer_page.setVisible(false);
                        payment_page.setVisible(true);
                        bpjs_page.setVisible(false);
                        pln_page.setVisible(false);
                        mutasi_page.setVisible(false);
                    } else {
                        pesanalert alert = new pesanalert();
                        alert.errorMessage("Pembayaran anda melebihi limit");
                    }

                } else {
                    pesanalert alert = new pesanalert();
                    alert.errorMessage("Saldo anda tidak cukup");
                }


            } else {
                pesanalert alert = new pesanalert();
                alert.errorMessage("MPIN anda salah");
            }
        } else if (pln_page.isVisible() == true) {
            if (tf_pln_nominal.getText().isEmpty() || tf_pln_mpin.getText().isEmpty()) {
                pesanalert alert = new pesanalert();
                alert.errorMessage("Tolong isi semua kolom yang tersedia");
            } else if (tf_pln_mpin.getText().equals(this.getAccount().getMpin())) {
                if (this.getAccount().getSaldo() >= Double.parseDouble(tf_pln_nominal.getText())) {
                    if (this.getAccount().getLimit() >= Double.parseDouble(tf_pln_nominal.getText())) {
                        this.getAccount().setLimit((int) (this.getAccount().getLimit()-Double.parseDouble(tf_pln_nominal.getText())));
                        this.getAccount().setSaldo(this.getAccount().getSaldo() - Double.parseDouble(tf_pln_nominal.getText()));
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        LocalDateTime now = LocalDateTime.now();
                        Payment pay = new Payment("pln", Double.parseDouble(tf_pln_nominal.getText()), dtf.format(now));
                        this.getAccount().getPay().add(pay);
                        pesanalert alert = new pesanalert();
                        alert.successMessage("berhasil membayar\n sisa limit anda "+this.getAccount().getLimit()+"\nnomor pembayaran anda "+pay.getNo_payment());
                        tf_pln_nominal.setText("");
                        tf_bpjs_mpin.setText("");
                        home_page.setVisible(false);
                        inform_page.setVisible(false);
                        cekSaldo_page.setVisible(false);
                        setting_page.setVisible(false);
                        blokir_page.setVisible(false);
                        limit_page.setVisible(false);
                        mtransfer_page.setVisible(false);
                        payment_page.setVisible(true);
                        bpjs_page.setVisible(false);
                        pln_page.setVisible(false);
                    } else {
                        pesanalert alert = new pesanalert();
                        alert.errorMessage("Pembayaran anda melebihi limit");
                    }
                } else {
                    pesanalert alert = new pesanalert();
                    alert.errorMessage("Saldo anda tidak cukup");
                }


            } else {
                pesanalert alert = new pesanalert();
                alert.errorMessage("MPIN anda salah");
            }
        }
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
}

