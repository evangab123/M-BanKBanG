public class Manajemen {
    private int id_manage;
    private static int nextidManage = 1;
    private Account acc;

    public int getId_manage() {
        return id_manage;
    }


    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public Manajemen(Account acc) {
        this.id_manage = Integer.parseInt("m"+nextidManage);
        this.acc = acc;
        nextidManage ++;
    }
}
