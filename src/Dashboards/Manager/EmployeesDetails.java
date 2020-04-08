package Dashboards.Manager;

import com.jfoenix.controls.JFXButton;

public class EmployeesDetails {

    private String EmployeeName;
    private String Role;
    private JFXButton Fire;

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public JFXButton getFire() {
        return Fire;
    }

    public void setFire(JFXButton fire) {
        Fire = fire;
    }
}
