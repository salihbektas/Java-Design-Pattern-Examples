import java.util.Stack;

public class IncreaseCommand implements Command {
    Database engine;
    Stack<String> accountHistory;
    Stack<Integer> amountHistory;
    IncreaseCommand(Database o){
        engine = o;
        accountHistory = new Stack<>();
        amountHistory = new Stack<>();
    }
    @Override
    public boolean execute(String account, int amount) {
        boolean result;
        result = engine.increase(account, amount);
        if(result){
            accountHistory.push(account);
            amountHistory.push(amount);
        }
        return result;
    }

    @Override
    public void undo() {
         engine.decrease(accountHistory.pop(), amountHistory.pop());
    }
}
