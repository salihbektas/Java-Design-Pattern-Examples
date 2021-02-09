import java.util.Stack;

public class DecreaseCommand implements Command{
    Database engine;
    Stack<String> accountHistory;
    Stack<Integer> amountHistory;
    DecreaseCommand(Database o){
        engine = o;
        accountHistory = new Stack<>();
        amountHistory = new Stack<>();
    }
    @Override
    public boolean execute(String account, int amount) {
        boolean result;
        result = engine.decrease(account, amount);
        if (result) {
            accountHistory.push(account);
            amountHistory.push(amount);
        }
        return result;
    }

    @Override
    public void undo() {
        engine.increase(accountHistory.pop(), amountHistory.pop());
    }
}
