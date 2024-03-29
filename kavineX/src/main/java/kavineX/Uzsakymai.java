package kavineX;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Uzsakymai {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String pav;
    private Integer trukme_ruosimo;
    private Integer trukme_kaitinimo;
    private String busena;    
    
 //   @ManyToOne(fetch = FetchType.LAZY)
 //   @JoinColumn(name= "patiekalai")
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public Integer getTrukme_kaitinimo() {
		return trukme_kaitinimo;
	}

	public void setTrukme_kaitinimo(Integer trukme_kaitinimo) {
		this.trukme_kaitinimo = trukme_kaitinimo;
	}
    
	public Integer getTrukme_ruosimo() {
		return trukme_ruosimo;
	}

	public void setTrukme_ruosimo(Integer trukme_ruosimo) {
		this.trukme_ruosimo = trukme_ruosimo;
	}
	
	public String getBusena() {
		return busena;
	}

	public void setBusena(String busena) {
		this.busena = busena;
	}
	    
}