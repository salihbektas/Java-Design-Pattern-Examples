public class Main {

    public static void main(String[] args) {
        TurboPayment turbo = new Turbo();
        ModernPayment payment = new Payment(turbo);

        payment.pay("123", (float) 250.50, "789", "10");
    }
}
