public enum OperationType {
    DEPOSIT, WITHDRAW;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
