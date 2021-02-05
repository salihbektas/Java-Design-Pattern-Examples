public interface ModernPayment {
    int pay(String cardNo, float amount, String destination, String installments);
}
