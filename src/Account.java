import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Random;

public class Account {
    private int NoRekening;
    private String username;
    private Customer Cust;
    private String mpin;
    private double saldo;
    private ArrayList<Payment> pay= new ArrayList<Payment>();
    private ArrayList<Transfer> tf= new ArrayList<Transfer>();
    private ArrayList<Manajemen> manage= new ArrayList<Manajemen>();

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


    public ArrayList<Manajemen> getManage() {
        return manage;
    }


    public int getLimithelper() {
        return limithelper;
    }

    public void setLimithelper(int limithelper) {
        this.limithelper = limithelper;
    }

    public Account(String username, Customer cust, String mpin) {
        Random rand = new Random();
        int int_random = rand.nextInt(9999);
        this.NoRekening = int_random;
        this.username=username;
        this.Cust = cust;
        this.mpin = mpin;
        this.saldo = 1000000;
    }
}
