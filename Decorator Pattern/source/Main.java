import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice;
        Suit suit;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a suit:");

        while(true) {
            System.out.println("1 = Dec");
            System.out.println("2 = Ora");
            System.out.println("3 = Tor");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                suit = new Dec();
                break;
            } else if (choice.equals("2")) {
                suit = new Ora();
                break;
            } else if (choice.equals("3")) {
                suit = new Tor();
                break;
            }
            System.out.println("Select suit:");
        }

        while (true) {
            System.out.println("Select accessories:");
            System.out.println("1 = Flamethrower");
            System.out.println("2 = AutoRifle");
            System.out.println("3 = RocketLauncher");
            System.out.println("4 = Laser");
            System.out.println("else = end");

            choice = scanner.nextLine();

            if (choice.equals("1")) {
                suit = new Flamethrower(suit);
            } else if (choice.equals("2")) {
                suit = new AutoRifle(suit);
            } else if (choice.equals("3")){
                suit = new RocketLauncher(suit);
            } else if (choice.equals("4")){
            suit = new Laser(suit);
            } else {
                break;
            }
        }
        System.out.println("Suit = " + suit.getDescription());
        System.out.println("weight = " + suit.getWeight() + "kg");
        System.out.println("cost = " + suit.getCost() + "k");

    }
}
