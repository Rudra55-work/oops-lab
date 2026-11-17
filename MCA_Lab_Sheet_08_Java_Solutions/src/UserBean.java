public class UserBean {
    private String password;
    public UserBean() {}
    // Write-only property: intentionally no getter.
    public void setPassword(String password) {
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password cannot be empty");
        this.password = password;
    }
    public boolean verifyPassword(String candidate) {
        return password != null && password.equals(candidate);
    }
    public static void main(String[] args) {
        UserBean user = new UserBean();
        user.setPassword("Java@123");
        System.out.println("Password accepted. Verification: " + user.verifyPassword("Java@123"));
    }
}
