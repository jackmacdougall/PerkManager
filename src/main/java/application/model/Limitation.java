package application.model;

import javax.persistence.*;

@Entity
@Table(name = "limitations")
public abstract class Limitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean forAllow;

    public Limitation(String name, boolean forAllow){
        this.name = name;
        this.forAllow = forAllow;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isAllowLimitation(){
        return this.forAllow;
    }

}
