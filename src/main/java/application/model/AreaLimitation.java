package application.model;

import javax.persistence.*;

@Entity
@Table(name = "limitations")
public class AreaLimitation extends Limitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String geographicalArea;

    public AreaLimitation(String name, boolean forAllow, String geographicalArea){
        super(name, forAllow);
        this.geographicalArea = geographicalArea;
    }

    public String getGeographicalArea(){
        return this.geographicalArea;
    }

    public void setGeographicalArea(String geographicalArea){
        this.geographicalArea = geographicalArea;
    }
}
