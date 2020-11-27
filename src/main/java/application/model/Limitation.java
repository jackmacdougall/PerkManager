package application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "limitations")
public class Limitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean permitted;
    private String type;

    @ManyToOne
    @JoinColumn(name = "perk_id")
    @JsonBackReference
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

    public boolean getPermitted(){
        return this.permitted;
    }

    public void setPermitted(boolean permitted) { this.permitted = permitted; }

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    public Perk getPerk() { return this.perk; }

    public void setPerk(Perk perk) { this.perk = perk; }
}
