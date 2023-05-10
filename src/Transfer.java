public class Transfer {
    private int no_rek_tujuan;
    private String tanggal;
    private String jenis_rekening;
    private String no_transfer;
    private static int nextidtransfer = 1;
    private double nominal;

    public Transfer(String jenis_rekening,int no_rek_tujuan, String tanggal,double nominal) {
        this.no_rek_tujuan = no_rek_tujuan;
        this.tanggal = tanggal;
        this.jenis_rekening = jenis_rekening;
        this.no_transfer = "t"+nextidtransfer;
        this.nominal = nominal;
        nextidtransfer++;
    }

    public int getNo_rek_tujuan() {
        return no_rek_tujuan;
    }

    public void setNo_rek_tujuan(int no_rek_tujuan) {
        this.no_rek_tujuan = no_rek_tujuan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJenis_rekening() {
        return jenis_rekening;
    }

    public void setJenis_rekening(String jenis_rekening) {
        this.jenis_rekening = jenis_rekening;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }
}
