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
    private String name;

    @ManyToMany(mappedBy = "profiles", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Membership> memberships = new HashSet<>();

    public Profile(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Membership> getMemberships(){
        return memberships;
    }
    public void addMembership(Membership membership){
        memberships.add(membership);
        membership.getProfiles().add(this);
    }
}
