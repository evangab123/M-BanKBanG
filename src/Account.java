import java.util.ArrayList;
import java.util.Random;

public class Account {
    private int NoRekening;
    private String username;
    private Customer Cust;
    private String mpin;
    private double saldo;
    private ArrayList<Payment> pay= new ArrayList<Payment>();
    private ArrayList<Transfer> tf= new ArrayList<Transfer>();
    private ArrayList<String> manage= new ArrayList<>();
    private String jenis_bank;

    private int limit = Integer.MAX_VALUE;
    private int limithelper = Integer.MAX_VALUE;
    private boolean blokir = false;

    public int getNoRekening() {
        return NoRekening;
    }

    public void setNoRekening(int noRekening) {
        NoRekening = noRekening;
    }

    public Customer getCust() {
        return Cust;
    }

    public void setCust(Customer cust) {
        Cust = cust;
    }

    public String getMpin() {
        return mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isBlokir() {
        return blokir;
    }

    public void setBlokir(boolean blokir) {
        this.blokir = blokir;
    }

    public  ArrayList<Payment> getPay() {
        return pay;
    }



    public  ArrayList<Transfer> getTf() {
        return tf;
    }





    public int getLimithelper() {
        return limithelper;
    }

    public void setLimithelper(int limithelper) {
        this.limithelper = limithelper;
    }

    public void setPay(ArrayList<Payment> pay) {
        this.pay = pay;
    }

    public void setTf(ArrayList<Transfer> tf) {
        this.tf = tf;
    }

    public ArrayList<String> getManage() {
        return manage;
    }

    public void setManage(ArrayList<String> manage) {
        this.manage = manage;
    }

    public String getJenis_bank() {
        return jenis_bank;
    }

    public void setJenis_bank(String jenis_bank) {
        this.jenis_bank = jenis_bank;
    }

    public Account(String username, Customer cust, String mpin) {
        Random rand = new Random();
        int int_random = rand.nextInt(9999);
        this.NoRekening = int_random;
        this.username=username;
        this.Cust = cust;
        this.mpin = mpin;
        this.saldo = 1000000;
        this.jenis_bank = "sama";
    }
}
