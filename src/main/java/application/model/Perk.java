package application.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "perks")
public class Perk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Membership membership;

    @ManyToOne
    private Product product;

    private Integer likes;
    private Integer dislikes;
    private Date expiryDate;

    public Perk(Membership membership, Product product, Date expiryDate){
        this.membership = membership;
        this.product = product;
        this.expiryDate = expiryDate;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Long getId(){
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

    public void setExpiryDate(Date expiryDate){
        this.expiryDate = expiryDate;
    }

    public Integer getUpvotes(){
        return this.likes;
    }

    public Integer getDownvotes(){
        return this.dislikes;
    }

    public void like(){
        this.likes++;
    }

    public void dislike(){
        this.dislikes++;
    }
}
