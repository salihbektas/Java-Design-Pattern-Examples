public class Flamethrower extends Accessories{

    Suit suit;
    /**
     * Constructor add suit
     */
    public Flamethrower(Suit suit){
        this.suit = suit;
    }

    /**
     *
     * @return description as a String
     */
    public String getDescription(){
        return suit.getDescription() + ", Flamethrower";
    }

    /**
     *
     * @return cost of suit + self cost
     */
    public int getCost(){
        return suit.getCost() + 50;
    }

    /**
     *
     * @return weight of suit + self weight
     */
    public double getWeight(){
        return suit.getWeight() + 2;
    }
}
