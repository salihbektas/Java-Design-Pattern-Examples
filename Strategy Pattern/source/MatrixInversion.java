import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixInversion implements SolveMethod{
    private final String fileName;
    private boolean err = false;

    /**
     * Constructor take file name and set it
     * @param fileName of linear system
     */
    public MatrixInversion(String fileName) {
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
     * Calculates result to use inverse matrix
     * If system is solvable print results
     */
    public void solve(){
        readFile();
        ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> augmented = new ArrayList<>();

        for (int i = 0; i < coefficient.size(); i++) {
            ArrayList<Double> temp = new ArrayList<>();
            for (int j = 0; j < coefficient.get(0).size()-1; j++) {
                temp.add(coefficient.get(i).get(j));
            }
            matrix.add(temp);
        }

        for (int i = 0; i < coefficient.size(); i++) {
            augmented.add(coefficient.get(i).get(coefficient.get(0).size()-1));
        }

        ArrayList<Double> t = new ArrayList<Double>(){{
            add(0.0);
            add(0.0);
            add(0.0);
        }};
        ArrayList<ArrayList<Double>>adj = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < matrix.size(); i++) {
            adj.add(new ArrayList<Double>(t));
        }
        ArrayList<ArrayList<Double>>inv = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < matrix.size(); i++) {
            inv.add(new ArrayList<Double>(t));
        }

        adjoint(matrix, adj);

        getInverse(matrix, inv);

        //calculate results
        if(!err)
            System.out.println("\nResult is:");
            for (int i = 0; i < matrix.size(); i++) {
                double result = 0;
                for (int j = 0; j < matrix.size(); j++) {
                    result += augmented.get(j) * inv.get(i).get(j);
                }
                //for rounding
                result = BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
                System.out.println(variables.get(i) + " = " + result);
            }
    }

    /**
     * Calculate cofactor of matrix on [p][q]
     * @param matrix
     * @param cofactor is cofactor of matrix[p][q]
     * @param p is row index
     * @param q is column index
     * @param n is size of matrix
     */
    protected void getCofactor(ArrayList<ArrayList<Double>> matrix,
                            ArrayList<ArrayList<Double>> cofactor,
                            int p, int q, int n){

        int i = 0, j = 0;
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){
                if (row != p && col != q){
                    cofactor.get(i).set(j++, matrix.get(row).get(col));

                    if (j == n - 1){
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /**
     * Calculate determinant of matrix
     * @param matrix
     * @param n is size of matrix
     * @return determinant of matrix
     */
    protected double determinant(ArrayList<ArrayList<Double>> matrix, int n)
    {
        double result = 0; // Initialize result

        // Base case : if matrix contains single element
        if (n == 1)
            return matrix.get(0).get(0);

        ArrayList<Double> t = new ArrayList<>();
        t.add(0.0);
        t.add(0.0);
        t.add(0.0);

        ArrayList<ArrayList<Double>> temp = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < matrix.size(); i++) {
            temp.add(new ArrayList<Double>(t));
        }
        int sign = 1;

        // Iterate for each element of first row
        for (int f = 0; f < n; f++){
            getCofactor(matrix, temp, 0, f, n);
            result += sign * matrix.get(0).get(f) * determinant(temp, n - 1);

            sign = -sign;
        }
        return result;
    }

    /**
     * Creates signs of elements in matrix for determinant operation
     * @param matrix
     * @param adj matrix row with signs attached
     */
    protected void adjoint(ArrayList<ArrayList<Double>> matrix,ArrayList<ArrayList<Double>> adj){

        if (matrix.size() == 1){
            adj.get(0).set(0, 1.0);
            return;
        }

        ArrayList<Double> t = new ArrayList<>();
        t.add(0.0);
        t.add(0.0);
        t.add(0.0);

        int sign = 1;
        ArrayList<ArrayList<Double>> temp = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < matrix.size(); i++) {
            temp.add(new ArrayList<Double>(t));
        }
        for (int i = 0; i < matrix.size(); i++){
            for (int j = 0; j < matrix.size(); j++){
                getCofactor(matrix, temp, i, j, matrix.size());

                sign = ((i + j) % 2 == 0)? 1: -1;

                adj.get(j).set(i, (sign)*(determinant(temp, matrix.size()-1)));
            }
        }
    }

    /**
     * Calculate and store inverse of matrix
     * @param matrix
     * @param inverse is inverse of matrix
     * @return false if determinant is zero, else true
     */
    protected boolean getInverse(ArrayList<ArrayList<Double>> matrix, ArrayList<ArrayList<Double>> inverse){

        double det = determinant(matrix, matrix.size());
        if (det == 0){
            System.out.print("Impossible to solve");
            err = true;
            return false;
        }

        ArrayList<Double> t = new ArrayList<>();
        t.add(0.0);
        t.add(0.0);
        t.add(0.0);
        ArrayList<ArrayList<Double>>adj = new ArrayList<ArrayList<Double>>();
        for (int i = 0; i < matrix.size(); i++) {
            adj.add(new ArrayList<Double>(t));
        }
        adjoint(matrix, adj);

        for (int i = 0; i < matrix.size(); i++)
            for (int j = 0; j < matrix.size(); j++)
                inverse.get(i).set(j, adj.get(i).get(j)/det);

        return true;
    }
}
