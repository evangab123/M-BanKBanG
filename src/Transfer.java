public class Transfer {
    private int no_rek_tujuan;
    private int no_rek_asal;
    private String tanggal;
    private String jenis_rekening;
    private String no_transfer;
    private static int nextidtransfer = 1;
    private String nominal;

    public Transfer(String jenis_rekening,int no_rek_asal,int no_rek_tujuan, String tanggal,String nominal) {
        this.no_transfer = "t"+nextidtransfer;
        this.no_rek_tujuan = no_rek_tujuan;
        this.tanggal = tanggal;
        this.jenis_rekening = jenis_rekening;
        this.nominal = nominal;
        this.no_rek_asal = no_rek_asal;
        nextidtransfer++;
    }

    public int getNo_rek_asal() {
        return no_rek_asal;
    }

    public void setNo_rek_asal(int no_rek_asal) {
        this.no_rek_asal = no_rek_asal;
    }

    public String getNo_transfer() {
        return no_transfer;
    }

    public void setNo_transfer(String no_transfer) {
        this.no_transfer = no_transfer;
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

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
}
