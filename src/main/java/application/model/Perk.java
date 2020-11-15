package application.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "perk")
public class Perk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Membership membership;

    @ManyToOne
    private Product product;

    private Integer upvotes;
    private Integer downvotes;
    private Date expiryDate;

    public Perk(Membership membership, Product product, Date expiryDate){
        this.membership = membership;
        this.product = product;
        this.expiryDate = expiryDate;
        this.upvotes = 0;
        this.downvotes = 0;
    }

    public Integer getId(){
        return this.id;
    }

    public Membership getMembership(){
        return this.membership;
    }

    public Product getProduct(){
        return this.product;
    }

    public Date getExpiryDate(){
        return this.expiryDate;
    }

    public void setExpiryDate(){
        this.expiryDate = expiryDate;
    }

    public Integer getUpvotes(){
        return this.upvotes;
    }

    public Integer getDownvotes(){
        return this.downvotes;
    }

    public void upvote(){
        this.upvotes++;
    }

    public void downvote(){
        this.downvotes++;
    }
}
