package kavineX;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Patiekalai {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Integer id;
 private String pav;
 private Integer trukme_ruosimo;
 private Integer trukme_kaitinimo;    
 private Double kaina;
 
 @OneToMany(mappedBy = "patiekalai",cascade = CascadeType.ALL)
 private List<Patiekalu_produktai> patiekalu_produktai;  
 
// @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
// private List<Uzsakymai> uzsakymai; 

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

	public Integer getTrukme_ruosimo() {
		return trukme_ruosimo;
	}

	public void setTrukme_ruosimo(Integer trukme_ruosimo) {
		this.trukme_ruosimo = trukme_ruosimo;
	}

	public Integer getTrukme_kaitinimo() {
		return trukme_kaitinimo;
	}

	public void setTrukme_kaitinimo(Integer trukme_kaitinimo) {
		this.trukme_kaitinimo = trukme_kaitinimo;
	}	
	
	public Double getKaina() {
		return kaina;
	}

	public void setKaina(Double kaina) {
		this.kaina = kaina;
	}
	
/*	public List<Uzsakymai> getUzsakymai() {
		
		return uzsakymai;
	}
	public void setUzsakymai (List<Uzsakymai> uzsakymai) {
		
		this.uzsakymai = uzsakymai;
	} */
	
	public List<Patiekalu_produktai> getPatiekalu_produktai() {
		
		return patiekalu_produktai;
	}
	public void setPatiekalu_produktai (List<Patiekalu_produktai> patiekalu_produktai) {
		
		this.patiekalu_produktai = patiekalu_produktai;
	}
}