public class RocketLauncher extends Accessories{
    Suit suit;

    /**
     * Constructor add suit
     */
    public RocketLauncher(Suit suit){
        this.suit = suit;
    }

    /**
     *
     * @return description as a String
     */
    public String getDescription(){
        return suit.getDescription() + ", RocketLauncher";
    }

    /**
     *
     * @return cost of suit + self cost
     */
    public int getCost(){
        return suit.getCost() + 150;
    }

    /**
     *
     * @return weight of suit + self weight
     */
    public double getWeight(){
        return suit.getWeight() + 7.5;
    }
}
