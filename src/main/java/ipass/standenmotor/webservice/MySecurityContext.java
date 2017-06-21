package ipass.standenmotor.webservice;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MySecurityContext implements SecurityContext {
    private String name;
    private String status;
    private boolean isSecure;

    public MySecurityContext(String name, String status, boolean isSecure) {
        this.name = name;
        this.status = status;
        System.out.println("Secure: " + isSecure);
        System.out.println("MySecurityContext");
    }

    public Principal getUserPrincipal() {
        System.out.println("AuthenticationFilter/getUserPrincipal");
        return () -> name;
    }
    public boolean isUserInRole(String role) { System.out.println("AuthenticationFilter/isUserInRole, status: " + status + ", role2: " + this.status); return role.equals(this.status); }
    public boolean isSecure() { System.out.println("AuthenticationFilter/isSecure"); return isSecure; }
    public String getAuthenticationScheme() { System.out.println("AuthenticationFilter/getAuthenticationScheme"); return "Bearer"; }
}