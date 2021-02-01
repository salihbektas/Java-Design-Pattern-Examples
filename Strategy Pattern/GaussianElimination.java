import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GaussianElimination implements SolveMethod{
    private final String fileName;

    /**
     * Constructor take file name and set it
     * @param fileName of linear system
     */
    public GaussianElimination(String fileName){
        this.fileName = fileName;
    }

    /**
     * Read linear system file
     * Set variables and coefficients
     * Print input linear system
     */
    public void readFile(){
        try {
            boolean flag = true;
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            System.out.println("\nInput is:");
            while (scanner.hasNextLine()) {
                ArrayList<Double> tempo = new ArrayList<Double>();
                String data = scanner.nextLine();
                System.out.println(data);
                String cof = "[+-]?[0-9]+\\.?[0-9]*";
                String var = "[a-zA-Z]";

                Pattern p = Pattern.compile(cof);
                Matcher m = p.matcher(data);
                Pattern c = Pattern.compile(var);
                Matcher b = c.matcher(data);
                StringBuilder temp = new StringBuilder();
                double duble;
                char ccc;
                while(m.find()) {
                    for(int i = m.start(); i < m.end(); ++i){
                        temp.append(data.charAt(i));
                    }
                    duble = Double.parseDouble(temp.toString());
                    temp = new StringBuilder();
                    tempo.add(duble);
                }
                coefficient.add(tempo);
                while (b.find() && flag){
                    ccc = data.charAt(b.start());
                    variables.add(ccc);
                }
                flag = false;
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Make row reduced echelon form of matrix
     * If system is solvable print results
     */
    public void solve(){
        readFile();
        int lead = 0;
        int rowCount = coefficient.size();
        int colCount = coefficient.get(0).size();
        int i;
        boolean quit = false;

        for(int row = 0; row < rowCount && !quit; row++){
            if(colCount <= lead){
                quit = true;
                break;
            }
            i=row;

            while(!quit && coefficient.get(i).get(lead) == 0){
                i++;
                if(rowCount == i){
                    i=row;
                    lead++;

                    if(colCount == lead){
                        quit = true;
                        break;
                    }
                }
            }

            if(!quit){
                swapRows(coefficient, i, row);

                if(coefficient.get(row).get(lead) != 0)
                    divideRow(coefficient, row, coefficient.get(row).get(lead));

                for(i = 0; i < rowCount; i++){
                    if(i != row)
                        subtractRows(coefficient, coefficient.get(i).get(lead), row, i);
                }
            }
        }
        //for rounding
        for(int m = 0; m < coefficient.size(); ++m){
            for(int j = 0; j < coefficient.get(0).size(); ++j){
                coefficient.get(m).set(j, BigDecimal.valueOf(coefficient.get(m).get(j))
                        .setScale(2, RoundingMode.HALF_UP).doubleValue());
            }
        }

        if(quit)
            System.out.println("Impossible to solve");
        else
            displayResult();
    }

    /**
     * swap two rows
     * @param m matrix
     * @param row1 the desired row1 to be replaced in the matrix
     * @param row2 the desired row2 to be replaced in the matrix
     */
    protected void swapRows(ArrayList<ArrayList<Double>> m, int row1, int row2){
        ArrayList<Double> swap = new ArrayList<>(m.get(row1));


        for (int i = 0; i < m.get(row1).size(); i++) {
            m.get(row1).set(i, m.get(row2).get(i));
        }

        for (int i = 0; i < m.get(row2).size(); i++) {
            m.get(row2).set(i, swap.get(i));
        }

    }

    /**
     * Divides the desired row by a number
     * @param m is matrix
     * @param row is line to be divided
     * @param scalar is diveder
     */
    protected void divideRow(ArrayList<ArrayList<Double>> m, int row, double scalar){
        for(int i = 0; i < m.get(0).size(); i++)
            m.get(row).set(i, m.get(row).get(i)/scalar);
    }

    /**
     * Multiplies a row by the desired number and subtracts it from another row
     * @param m is matrix
     * @param scalar is multiplication coefficient
     * @param subtrahendRow name is descriptive
     * @param minuendRow name is descriptive
     */
    protected void subtractRows(ArrayList<ArrayList<Double>> m,double scalar,int subtrahendRow,int minuendRow){
        for(int i = 0; i < m.get(0).size(); i++)
            m.get(minuendRow).set(i, m.get(minuendRow).get(i) - scalar * m.get(subtrahendRow).get(i));
    }

    /**
     * Display reslts with variables
     */
    protected void displayResult(){
        System.out.println("\nResult is:");
        for (int i = 0; i < coefficient.size(); i++) {
            System.out.println(variables.get(i) + " = " + coefficient.get(i).get(coefficient.size()));
        }
    }

}
