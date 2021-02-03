public class Ora extends Suit{
    /**
     * Constructor set description
     */
    public Ora(){
        description = "Ora";
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
        return 1500;
    }

    /**
     *
     * @return weight of suit
     */
    public double getWeight(){
        return 30;
    }
}
