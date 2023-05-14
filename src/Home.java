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
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Home implements Initializable {

    @FXML
    private TableColumn<Transfer, String> kolom_id_tf;
    @FXML
    private TableColumn<Transfer, String> kolom_jenistf;
    @FXML
    private TableColumn<Transfer, Integer> kolom_nominal_tf;
    @FXML
    private TableColumn<Transfer, Integer> kolom_norek_tf;
    @FXML
    private TableColumn<Transfer, String> kolom_tanggal_tf;
    @FXML
    private TableColumn<Transfer, Integer> kolom_norek_tf1;
    @FXML
    private TableView<Transfer> table_mutasi_tf;
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
    private Button btn_tfsama;
    @FXML
    private Button btn_tfantar;
    @FXML
    private TextField tf_nominalsamabank;

    @FXML
    private PasswordField tf_con_mpin_sama;

    @FXML
    private TextField tf_nominalantarbank;

    @FXML
    private PasswordField tf_con_mpin_antar;

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
    private AnchorPane manajemen_page;


    @FXML
    private AnchorPane setting_page;

    @FXML
    private AnchorPane transfer_page;

    @FXML
    private AnchorPane tf_sama_page;
    @FXML
    private AnchorPane tf_antar_page;
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

    @FXML
    private Button btn_buat_manajemen;
    @FXML
    private Button btn_kembali_manajemen;
    @FXML
    private Button btn_kembali_tranfer;

    @FXML
    private Button btn_antar_bank;

    @FXML
    private Button btn_sama_bank;

    @FXML
    private Button btn_kembali_samatf;
    @FXML
    private Button btn_kembali_bedatf;



    @FXML
    private TextField tf_norek_manajemen;


    @FXML
    private ComboBox<?> combo_jenisbox;
    @FXML
    private ComboBox<?> combo_reksama;

    @FXML
    private ComboBox<?> combo_rekantar;




    private Account account;
    private ObservableList<Payment> dataakun;
    private ObservableList<Transfer> dataakuntf;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCombo_jenisbox();
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
            label_norek.setText("No. Rekening Anda : "+this.getAccount().getNoRekening());
            label_limithelp.setText("Limit anda hari ini: "+formatRupiah(this.getAccount().getLimithelper()));
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
        } else if (event.getSource() == btn_mtransfer||event.getSource()==btn_kembali_manajemen||event.getSource()==btn_kembali_tranfer) {
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
        } else if (event.getSource() == btn_kembali_bpjs ||  event.getSource()== btn_kembali_pln||event.getSource() == btn_mpayment) {
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
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
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
            this.setTable_mutasi();
            this.setTable_mutasi_tf();
        } else if (event.getSource()==btn_manajemen) {
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
            mutasi_page.setVisible(false);
            manajemen_page.setVisible(true);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
        } else if (event.getSource()==btn_transfer || event.getSource() == btn_kembali_samatf || event.getSource() == btn_kembali_bedatf) {
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
            mutasi_page.setVisible(false);
            manajemen_page.setVisible(false);
            transfer_page.setVisible(true);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(false);
        } else if (event.getSource() == btn_sama_bank) {
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
            mutasi_page.setVisible(false);
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(true);
            tf_antar_page.setVisible(false);
            setCombo_reksama();

        }else if (event.getSource() == btn_antar_bank) {
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
            mutasi_page.setVisible(false);
            manajemen_page.setVisible(false);
            transfer_page.setVisible(false);
            tf_sama_page.setVisible(false);
            tf_antar_page.setVisible(true);
            setCombo_rekantar();
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
            transfer_page.setVisible(false);
            mutasi_page.setVisible(false);
            manajemen_page.setVisible(false);

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
                        alert.successMessage("Berhasil membayar Sebesar " + formatRupiah(Integer.parseInt(tf_bpjs_nominal.getText()))+" ke BPJS");
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
                        transfer_page.setVisible(false);
                        tf_antar_page.setVisible(false);
                        tf_sama_page.setVisible(false);
                    } else {
                        pesanalert alert = new pesanalert();
                        alert.errorMessage("Pembayaran anda melebihi limit\n sisa limit anda "+formatRupiah(this.getAccount().getLimit()));
                    }

                } else {
                    pesanalert alert = new pesanalert();
                    alert.errorMessage("Saldo anda tidak mencukupi\nSisa saldo anda : "+formatRupiah((int) this.getAccount().getSaldo()));
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
                        alert.successMessage("Berhasil membayar Sebesar " + formatRupiah(Integer.parseInt(tf_pln_nominal.getText()))+" ke PLN");
                        tf_pln_nominal.setText("");
                        tf_pln_mpin.setText("");
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
                        transfer_page.setVisible(false);
                        tf_antar_page.setVisible(false);
                        tf_sama_page.setVisible(false);
                    } else {
                        pesanalert alert = new pesanalert();
                        alert.errorMessage("Pembayaran anda melebihi limit\n sisa limit anda "+formatRupiah(this.getAccount().getLimit()));
                    }
                } else {
                    pesanalert alert = new pesanalert();
                    alert.errorMessage("Saldo anda tidak mencukupi\nSisa saldo anda : "+formatRupiah((int) this.getAccount().getSaldo()));
                }


            } else {
                pesanalert alert = new pesanalert();
                alert.errorMessage("MPIN anda salah");
            }
        }
    }

    public void transfer(ActionEvent event){
        if(tf_sama_page.isVisible()){

            if (tf_con_mpin_sama.getText().isEmpty() || combo_reksama.getSelectionModel().isEmpty()||tf_nominalsamabank.getText().isEmpty()) {
                pesanalert alert = new pesanalert();
                alert.errorMessage("Isi semua kolom atau pilihan yang tersedia");
            } else if (this.getAccount().getMpin().equals(tf_con_mpin_sama.getText())){
                if (this.getAccount().getSaldo() >= Double.parseDouble(tf_nominalsamabank.getText())) {
                    if (this.getAccount().getLimit() >= Double.parseDouble(tf_nominalsamabank.getText())) {
                        for (Account acc : Controller.getAccounts()) {
                            if (acc.getCust().getNamalengkap().equals(combo_reksama.getSelectionModel().getSelectedItem().toString())) {
                                acc.setSaldo(acc.getSaldo() + Double.parseDouble(tf_nominalsamabank.getText()));
                                this.getAccount().setSaldo(this.getAccount().getSaldo() - Double.parseDouble(tf_nominalsamabank.getText()));
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                                LocalDateTime now = LocalDateTime.now();
                                Transfer tf = new Transfer("sama", this.getAccount().getNoRekening(),acc.getNoRekening(), dtf.format(now), formatRupiah(Integer.parseInt(tf_nominalsamabank.getText())));
                                this.getAccount().getTf().add(tf);
                                acc.getTf().add(tf);
                                pesanalert alert = new pesanalert();
                                alert.successMessage("Berhasil mentransfer ke Akun atas nama " + acc.getCust().getNamalengkap() + " Sebesar " + formatRupiah(Integer.parseInt(tf_nominalsamabank.getText())));
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
                                transfer_page.setVisible(true);
                                tf_antar_page.setVisible(false);
                                tf_sama_page.setVisible(false);
                            }
                        }
                    }else {
                        pesanalert alert = new pesanalert();
                        alert.errorMessage("Transfer anda melebihi limit\n sisa limit anda "+formatRupiah(this.getAccount().getLimit()));
                    }
                }else {
                    pesanalert alert = new pesanalert();
                    alert.errorMessage("Saldo anda tidak mencukupi\nSisa saldo anda : "+formatRupiah((int) this.getAccount().getSaldo()));
                }

            } else{
                pesanalert alert = new pesanalert();
                alert.errorMessage("MPIN anda salah");
            }
        } else if (tf_antar_page.isVisible()){
            if (tf_con_mpin_antar.getText().isEmpty() && combo_rekantar.getSelectionModel().isEmpty()||tf_nominalantarbank.getText().isEmpty()) {
                pesanalert alert = new pesanalert();
                alert.errorMessage("Isi semua kolom atau pilihan yang tersedia");
            } else if (this.getAccount().getMpin().equals(tf_con_mpin_antar.getText())){
                if (this.getAccount().getSaldo()>= Double.parseDouble(tf_nominalantarbank.getText())) {
                    if (this.getAccount().getLimit() >= Double.parseDouble(tf_nominalantarbank.getText())) {
                        for (Account acc : Controller.getAccounts()) {
                            if (acc.getCust().getNamalengkap().equals(combo_rekantar.getSelectionModel().getSelectedItem().toString())) {
                                acc.setSaldo(acc.getSaldo() + Double.parseDouble(tf_nominalantarbank.getText()));
                                this.getAccount().setSaldo(this.getAccount().getSaldo() - Double.parseDouble(tf_nominalantarbank.getText()) - 6000);
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                                LocalDateTime now = LocalDateTime.now();
                                Transfer tf = new Transfer("antar",this.getAccount().getNoRekening(), acc.getNoRekening(), dtf.format(now), formatRupiah(Integer.parseInt(tf_nominalantarbank.getText())));
                                this.getAccount().getTf().add(tf);
                                acc.getTf().add(tf);
                                pesanalert alert = new pesanalert();
                                alert.successMessage("Berhasil mentransfer ke Akun atas nama " + acc.getCust().getNamalengkap() + " Sebesar " + formatRupiah(Integer.parseInt(tf_nominalantarbank.getText())));
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
                                transfer_page.setVisible(true);
                                tf_antar_page.setVisible(false);
                                tf_sama_page.setVisible(false);
                            }
                        }
                    }else {
                        pesanalert alert = new pesanalert();
                        alert.errorMessage("Tranfer anda melebihi limit\n sisa limit anda "+formatRupiah(this.getAccount().getLimit()));
                    }
                }else{
                    pesanalert alert = new pesanalert();
                    alert.errorMessage("Saldo anda tidak mencukupi\nSisa saldo anda : "+formatRupiah((int) this.getAccount().getSaldo()));
                }
            } else{
                pesanalert alert = new pesanalert();
                alert.errorMessage("MPIN anda salah");
            }
        }
    }

    private String[] jenislist ={"sama","antar"};
    private void setCombo_jenisbox(){
        List<String> listj = new ArrayList<>();

        for (String data : jenislist){
            listj.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listj);
        combo_jenisbox.setItems(listData);
    }
    private void setCombo_reksama(){
        List<String> listrs = new ArrayList<>();
        for(String data: this.getAccount().getManage()){
            for(Account acc: Controller.getAccounts()){
                if (acc.getJenis_bank().equals("sama") && acc.getCust().getNamalengkap().equals(data)){
                    listrs.add(data);
                }
            }
        }
        ObservableList listData = FXCollections.observableArrayList(listrs);
        combo_reksama.setItems(listData);
    }

    private void setCombo_rekantar(){
        List<String> listrs = new ArrayList<>();
        for(String data: this.getAccount().getManage()){
            for(Account acc: Controller.getAccounts()){
                if (acc.getJenis_bank().equals("antar") && acc.getCust().getNamalengkap().equals(data)){
                    listrs.add(data);
                }
            }
        }
        ObservableList listData = FXCollections.observableArrayList(listrs);
        combo_rekantar.setItems(listData);
    }
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
    public void setTable_mutasi_tf(){
        dataakuntf = FXCollections.observableArrayList(this.getAccount().getTf());
        table_mutasi_tf.setItems(dataakuntf);
        kolom_id_tf.setCellValueFactory(new PropertyValueFactory<>("no_transfer"));
        kolom_norek_tf1.setCellValueFactory(new PropertyValueFactory<>("no_rek_asal"));
        kolom_nominal_tf.setCellValueFactory(new PropertyValueFactory<>("nominal"));
        kolom_jenistf.setCellValueFactory(new PropertyValueFactory<>("jenis_rekening"));
        kolom_tanggal_tf.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        kolom_norek_tf.setCellValueFactory(new PropertyValueFactory<>("no_rek_tujuan"));
    }

    public void buatManajemen(ActionEvent event){
        if(tf_norek_manajemen.getText().isEmpty()||combo_jenisbox.getSelectionModel().isEmpty()){
            pesanalert alert = new pesanalert();
            alert.errorMessage("Isi semua kolom atau pilihan yang tersedia");
        } else if (Integer.parseInt(tf_norek_manajemen.getText()) == this.getAccount().getNoRekening()) {
            pesanalert alert = new pesanalert();
            alert.errorMessage("No Rekening yang anda masukan adalah no rekening anda sendiri");
        } else{
            for(Account acc : Controller.getAccounts()){
                if(Integer.parseInt(tf_norek_manajemen.getText()) == acc.getNoRekening()){
                    acc.setJenis_bank(combo_jenisbox.getSelectionModel().getSelectedItem().toString());
                    this.getAccount().getManage().add(acc.getCust().getNamalengkap());
                    pesanalert alert = new pesanalert();
                    alert.successMessage("Berhasil menambah");
                }else{
                    pesanalert alert = new pesanalert();
                    alert.errorMessage("Error tidak ada no rekening");
                }
            }
        }
        tf_norek_manajemen.setText("");
        combo_jenisbox.setPromptText("Jenis Bank");
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
}

