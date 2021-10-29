package Konto;

public class KontoApp {
    public static void main(String[] args) {
        Konto k1 = new Konto(2, "privat", 300.0);
        k1.setIndsætbeløb(900);
        System.out.println(k1);
        System.out.println("Din Saldo er; " + k1.getIndsætbeløb());
        System.out.println(k1.getNr());
        System.out.println("Denne konto er af typen; " + k1.getKontotype());
    }
}
