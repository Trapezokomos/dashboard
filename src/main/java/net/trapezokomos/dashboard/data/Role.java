package net.trapezokomos.dashboard.data;

public enum Role {
    ADMIN("Admin"),
    CUSTOMER_ADMIN("CustomerAdmin"),
    CUSTOMER_EMPLOYEE("CustomerEmployee");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
