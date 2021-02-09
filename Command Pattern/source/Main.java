import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String ,Integer> table = new HashMap<>();
        table.put("A", 10);
        table.put("B", 50);
        table.put("C", 90);

        Database database = new Database(table);
        DatabaseEngine engine = new DatabaseEngine(database);

        System.out.println("Testing normal behaviour");
        System.out.println("Initial state:");
        System.out.println(table);

        System.out.println("Try increase A by 10");
        engine.makeIncrease("A", 10);
        System.out.println(table);
        System.out.println("Try decrease C by 30");
        engine.makeDecrease("C", 30);
        System.out.println(table);
        System.out.println("Result as expected\n");


        System.out.println("Testing excessive reduction");
        HashMap<String ,Integer> table2 = new HashMap<>();
        table2.put("A", 10);
        table2.put("B", 50);
        table2.put("C", 90);

        Database database2 = new Database(table2);
        DatabaseEngine engine2 = new DatabaseEngine(database2);

        System.out.println("Initial state:");
        System.out.println(table2);

        System.out.println("Try increase A by 10");
        engine2.makeIncrease("A", 10);
        System.out.println(table2);
        System.out.println("Try decrease B by 70");
        engine2.makeDecrease("B", 70);
        System.out.println(table2);
        System.out.println("Transactions were rolled back because \n" +
                            "excessive reduction could not be made\n");

        System.out.println("Testing reduce from missing account");
        HashMap<String ,Integer> table3 = new HashMap<>();
        table3.put("A", 10);
        table3.put("B", 50);
        table3.put("C", 90);

        Database database3 = new Database(table3);
        DatabaseEngine engine3 = new DatabaseEngine(database3);

        System.out.println("Initial state:");
        System.out.println(table3);

        System.out.println("Try increase A by 10");
        engine3.makeIncrease("A", 10);
        System.out.println(table3);
        System.out.println("Try decrease D by 70");
        engine3.makeDecrease("D", 70);
        System.out.println(table3);
        System.out.println("Transactions were rolled back because \n" +
                            "no reduction could be made from the missing account\n");



        System.out.println("Testing increase from missing account");
        HashMap<String ,Integer> table4 = new HashMap<>();
        table4.put("A", 10);
        table4.put("B", 50);
        table4.put("C", 90);

        Database database4 = new Database(table4);
        DatabaseEngine engine4 = new DatabaseEngine(database4);

        System.out.println("Initial state:");
        System.out.println(table4);

        System.out.println("Try increase B by 10");
        engine4.makeIncrease("B", 10);
        System.out.println(table4);
        System.out.println("Try increase X by 20");
        engine4.makeIncrease("X", 20);
        System.out.println(table4);
        System.out.println("Transactions were rolled back because\n" +
                            "no increment could be made from the missing account\n");
    }
}
