public class Dec extends Suit{
    /**
     * Constructor set description
     */
    public Dec(){
        description = "Dec";
    }

    /**
     *
     * @return description as a String
     */
    @Override
    public String getDescription(){
        return description;
    }

    /**
     *
     * @return cost of suit
     */
    @Override
    public int getCost(){
        return 500;
    }

    /**
     *
     * @return weight of suit
     */
    @Override
    public double getWeight(){
        return 25;
    }
}
