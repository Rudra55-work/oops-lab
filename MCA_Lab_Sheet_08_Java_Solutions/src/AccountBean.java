import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AccountBean {
    private double balance;
    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    public AccountBean() {}
    public double getBalance() { return balance; }
    public void setBalance(double newBalance) {
        if (newBalance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        double oldBalance = this.balance;
        this.balance = newBalance;
        changes.firePropertyChange("balance", oldBalance, newBalance);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) { changes.addPropertyChangeListener(listener); }
    public void removePropertyChangeListener(PropertyChangeListener listener) { changes.removePropertyChangeListener(listener); }
    public static void main(String[] args) {
        AccountBean account = new AccountBean();
        account.addPropertyChangeListener(event ->
            System.out.println("Property '" + event.getPropertyName() + "' changed from " +
                event.getOldValue() + " to " + event.getNewValue()));
        account.setBalance(1000);
        account.setBalance(1750);
    }
}
