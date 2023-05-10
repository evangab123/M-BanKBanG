public class Payment {
    private String tanggal;
    private String no_payment;
    private String jenis_payment;
    private double nominal;
    private int nextidpayment = 1;

    public Payment( String jenis_payment, double nominal,String tanggal) {
        this.tanggal = tanggal;
        this.no_payment = "p"+nextidpayment;
        this.jenis_payment = jenis_payment;
        this.nominal = nominal;
        nextidpayment ++;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNo_payment() {
        return no_payment;
    }

    public void setNo_payment(String no_payment) {
        this.no_payment = no_payment;
    }

    public String getJenis_payment() {
        return jenis_payment;
    }

    public void setJenis_payment(String jenis_payment) {
        this.jenis_payment = jenis_payment;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }
}
