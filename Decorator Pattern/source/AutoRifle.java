public class AutoRifle extends Accessories{

    Suit suit;

    /**
     * Constructor add suit
     */
    public AutoRifle(Suit suit){
        this.suit = suit;
    }

    /**
     *
     * @return description as a String
     */
    public String getDescription(){
        return suit.getDescription() + ", AutoRifle";
    }

    /**
     *
     * @return cost of suit + self cost
     */
    public int getCost(){
        return suit.getCost() + 30;
    }

    /**
     *
     * @return weight of suit + self weight
     */
    public double getWeight(){
        return suit.getWeight() + 1.5;
    }
}
