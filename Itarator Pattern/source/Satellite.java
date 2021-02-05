/**
 * Satellite class holds 2d int data
 *
 */
public class Satellite implements ISatellite{
    int[][] data;

    /**
     * Setting data
     */
    public Satellite(){
        data = new int[4][];
        for (int i = 0; i < 4; i++) {
            data[i] = new int[4];
        }
        int temp = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = temp;
                ++temp;
            }
        }

    }

    /**
     * Create and return clockwise iterator
     * @return created iterator
     */
    public SatelliteClockwiseIterator createIterator(){
        return new SatelliteClockwiseIterator(data);
    }
}
