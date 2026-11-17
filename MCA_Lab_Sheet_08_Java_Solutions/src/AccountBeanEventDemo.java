public class AccountBeanEventDemo {
    public static void main(String[] args) {
        AccountBean account = new AccountBean();
        account.addPropertyChangeListener(e ->
            System.out.println("Balance updated: " + e.getOldValue() + " -> " + e.getNewValue()));
        account.setBalance(500);
        account.setBalance(800);
    }
}
