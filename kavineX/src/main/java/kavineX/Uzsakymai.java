package kavineX;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import duomenys.web.kavine.*;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Uzsakymai {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String pav;
    private Integer trukme_ruosimo;
    private Integer trukme_kaitinimo;
    private String busena;    
    
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "uzsakymu_produktai", joinColumns = @JoinColumn(name = "id_patiekalo", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_produkto", referencedColumnName = "id"))
	private Set<Produktai> produktai;
    
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

	public Set<Produktai> getProduktai() {
		return produktai;
	}
	
	public void setProduktas (Set<Produktai> produktai) {
		this.produktai = produktai;
	}

	    
}