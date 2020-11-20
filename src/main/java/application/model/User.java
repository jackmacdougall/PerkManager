package application.model;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String password;
    private String role;
    public boolean enabled = true;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Membership> memberships = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
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
