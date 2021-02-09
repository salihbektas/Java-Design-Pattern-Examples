import java.util.HashMap;

public class Database {
    HashMap<String, Integer> table;
    Database(HashMap<String, Integer> o){
        table = o;
    }

    boolean increase(String account, int amount){
        Integer temp = table.get(account);
        if(temp == null)
            return false;

        table.put(account, temp + amount);
        return true;
    }

    boolean decrease(String account, int amount){
        Integer temp = table.get(account);
        if(temp == null || temp < amount)
            return false;

        table.put(account, temp - amount);
        return true;
    }
}
