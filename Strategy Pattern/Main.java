import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String choice;
        String fileName;
        Scanner scanner = new Scanner(System.in);
        SolveMethod solver;

        System.out.println("Enter Linear system file name:");
        fileName = scanner.nextLine();
        while(true) {
            System.out.println("\nChoose method:");
            System.out.println("1 = Gaussian Elimination");
            System.out.println("2 = Matrix Inversion");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                solver = new GaussianElimination(fileName);
                break;
            } else if (choice.equals("2")) {
                solver = new MatrixInversion(fileName);
                break;
            }
        }
	    solver.solve();
    }
}
