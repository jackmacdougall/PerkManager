package application.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "userprofiles")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Membership> memberships = null;

    public UserProfile(String name) {
        this.name = name;
        this.memberships = new ArrayList<Membership>();
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

    public void addMembership(Membership membership){
        this.memberships.add(membership);
    }
}
