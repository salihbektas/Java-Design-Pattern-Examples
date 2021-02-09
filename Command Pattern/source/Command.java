public interface Command {
    boolean execute(String account, int amount);
    void undo();
}
