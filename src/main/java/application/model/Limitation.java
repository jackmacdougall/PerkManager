package application.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "limitations")
public class Limitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean permitted;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perk_id")
    private Perk perk;

    public Limitation() {}

    public Limitation(String type, String description, boolean permitted){
        this.type = type;
        this.description = description;
        this.permitted = permitted;
    }

    public Long getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public boolean isPermitted(){
        return this.permitted;
    }

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    public Perk getPerk() { return this.perk; }

    public void setPerk(Perk perk) { this.perk = perk; }

}
