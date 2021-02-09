import java.util.Stack;

public class DatabaseEngine {
    Command inc;
    Command dec;
    Stack<Command> history;

    DatabaseEngine(Database o){
        inc = new IncreaseCommand(o);
        dec = new DecreaseCommand(o);
        history = new Stack<>();
    }

    public void makeIncrease(String account, int amount){
        boolean result;
        result = inc.execute(account, amount);
        if(result)
            history.push(inc);
        else
            rollback();
    }
    public void makeDecrease(String account, int amount){
        boolean result;
        result = dec.execute(account, amount);
        if(result)
            history.push(dec);
        else
            rollback();
    }

    protected void rollback(){
        while (history.size() > 0) {
            history.pop().undo();
        }
    }

}
