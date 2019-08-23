package kavineX;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Patiekalu_produktai implements Serializable {
	
    private static final long serialVersionUID = -6790693372846798580L;	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
    private Integer produktai_id;
    private Double kiekis;
    @Column(nullable=false)
    private Integer patiekalai_id;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="patiekalai_id",referencedColumnName="id", insertable=false, updatable=false)
    private Patiekalai patiekalai;

    @ManyToOne(optional=false)
    @JoinColumn(name="produktai_id",referencedColumnName="id", insertable=false, updatable=false)
    private Produktai produktai; 
    
    public Patiekalu_produktai() {
    	
    }    
    
    public Integer getId () {
    	return id;
    }
    
    public void setId( Integer id ) {
    	
    	this.id = id;
    } 

    public Double getKiekis () {
    	
    	return kiekis;
    }
    
    public Produktai getProduktai () {
    	return produktai;
    }

    public void setProduktai( Produktai produktai ) {
	
    	this.produktai = produktai;
    }     
    
    public void setKiekis( Double kiekis ) {
    	
    	this.kiekis = kiekis;
    }    
    
    public Integer getProduktai_id () {
    	return produktai_id;
    }
    
    public void setProduktai_id( Integer produktai_id ) {
    	
    	this.produktai_id = produktai_id;
    } 
    
    public Integer getPatiekalai_id () {
    	return patiekalai_id;
    }
    
    public void setPatiekalai_id( Integer patiekalai_id ) {
    	
    	this.patiekalai_id = patiekalai_id;
    } 
}