package application.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String role;

    @ManyToMany(mappedBy = "profiles", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Membership> memberships = new HashSet<>();

    public Profile(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
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
        membership.getProfiles().add(this);
    }
}
