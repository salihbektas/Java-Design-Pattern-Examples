public class Tor extends Suit{
    /**
     * Constructor set description
     */
    public Tor(){
        description = "Tor";
    }

    /**
     *
     * @return description as a String
     */
    public String getDescription(){
        return description;
    }

    /**
     *
     * @return cost of suit
     */
    public int getCost(){
        return 5000;
    }

    /**
     *
     * @return weight of suit
     */
    public double getWeight(){
        return 50;
    }
}
