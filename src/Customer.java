public class Customer {

    private String email;
    private String namalengkap;
    private String jeniskelamin;

    public Customer(String email, String namalengkap, String jeniskelamin) {
        this.email = email;
        this.namalengkap = namalengkap;
        this.jeniskelamin = jeniskelamin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }
}
