package application.model;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String password;
    private String role;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Membership> memberships = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

    public String getRole() { return this.role; }

    public void setRole(String role) { this.role = role; }

    public Set<Membership> getMemberships(){
        return memberships;
    }

    public void addMembership(Membership membership){
        memberships.add(membership);
        membership.getUsers().add(this);
    }

}
