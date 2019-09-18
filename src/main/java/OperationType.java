public enum OperationType {
    DEPOSIT;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
