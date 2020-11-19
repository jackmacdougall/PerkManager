package application.model;

import javax.persistence.*;

@Entity
@Table(name = "limitations")
public class TimeLimitation extends Limitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time;

    public TimeLimitation(String name, boolean forAllow, String time){
        super(name, forAllow);
        this.time = time;
    }

    public String getTime(){
        return this.time;
    }

    public void setTime(String time){
        this.time = time;
    }
}
