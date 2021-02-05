public class Payment implements ModernPayment{
    TurboPayment turbo;

    Payment(TurboPayment o){
        this.turbo = o;
    }
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        return turbo.payInTurbo(cardNo, amount, destination, installments);
    }
}
