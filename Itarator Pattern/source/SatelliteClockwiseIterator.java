import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterator. Takes 2D Satellite data and print clockwise order
 */
public class SatelliteClockwiseIterator implements Iterator {
    private int[][]data;                    //Data received from satellite
    private final int row;                  //Number of rows
    private final int column;               //Number of column
    private final int LEFT = 0;             //Macros for direction
    private final int RIGHT = 1;
    private final int UP = 2;
    private final int DOWN = 3;
    private int direction = DOWN;           //Current direction
    private Pair posistion = new Pair(0,0); //Position value as two int fielded class
    private ArrayList<Pair> visited = new ArrayList<>();    //Visited indexes list

    /**
     * An auxiliary class that holds two integer values
     */
    private class Pair{
        private int first;
        private int second;

        public Pair(int f, int s){
            first = f;
            second = s;
        }
        public int getFirst() {
            return first;
        }
        public void setFirst(int first) {
            this.first = first;
        }
        public int getSecond() {
            return second;
        }
        public void setSecond(int second) {
            this.second = second;
        }
        public boolean equals(Pair o){
            return (first == o.first && second == o.second);
        }

    }
    /**
     * Constructor takes 2D int array
     * @param o Satellite data
     */
    public SatelliteClockwiseIterator(int[][] o){
        data = o;
        row = o.length;
        column = o[0].length;
    }

    /**
     * Setting next item direction and position
     * Return value of current position item and add the visited
     */
    @Override
    public Object next() {
        int f = posistion.getFirst();
        int s = posistion.getSecond();
        int result = data[f][s];
        visited.add(new Pair(f,s));
        if (direction == LEFT) {
            if (s - 1 == -1 || isVisited(new Pair(f, s-1))) {
                direction = DOWN;
                posistion.setFirst(f+1);
            }
            else{
                posistion.setSecond(s-1);
            }
        } else if (direction == RIGHT) {
            if (s + 1 == column || isVisited(new Pair(f, s+1))) {
                direction = UP;
                posistion.setFirst(f-1);
            }
            else{
                posistion.setSecond(s+1);
            }
        } else if (direction == UP) {
            if (f-1 == -1 || isVisited(new Pair(f-1, s))) {
                posistion.setSecond(s-1);
                direction = LEFT;
            }
            else{
                posistion.setFirst(f-1);
            }
        } else {
            if(f+1 == row || isVisited(new Pair(f+1, s))){
                direction = RIGHT;
                posistion.setSecond(s+1);
            }
            else{
                posistion.setFirst(f+1);
            }
        }
        return result;
    }

    /**
     * return if next position is not visited
     */
    @Override
    public boolean hasNext() {
        return !isVisited(posistion);
    }

    /**
     * Check if given coordinate is visited
     * @param coordinate
     * @return true if visited. Return false if not
     */
    private boolean isVisited(Pair coordinate){
        for(Pair pair : visited){
            if(pair.equals(coordinate))
                return true;
        }
        return false;
    }
}
