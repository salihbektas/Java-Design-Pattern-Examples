public class Laser extends Accessories{
    Suit suit;

    /**
     * Constructor add suit
     */
    public Laser(Suit suit){
        this.suit = suit;
    }

    /**
     *
     * @return description as a String
     */
    public String getDescription(){
        return suit.getDescription() + ", Laser";
    }

    /**
     *
     * @return cost of suit + self cost
     */
    public int getCost(){
        return suit.getCost() + 200;
    }

    /**
     *
     * @return weight of suit + self weight
     */
    public double getWeight(){
        return suit.getWeight() + 5.5;
    }
}
