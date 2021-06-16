package test.hes.demo.entity;

public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String displayValue;

    private Status(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
