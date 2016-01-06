package entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(schema="PUBLIC", name="KPI_AREAS")
public class Area {

	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty
	private String nome;

	@NotNull
	@ManyToOne
	private Frente frente;
	
	@OneToMany(mappedBy="area", fetch=FetchType.EAGER)
	private List<Kpi> kpis;


	public Area() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Frente getFrente() {
		return frente;
	}


	public void setFrente(Frente frente) {
		this.frente = frente;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + "]";
	}

	public List<Kpi> getKpis() {
		return kpis;
	}

	public void setKpis(List<Kpi> kpis) {
		this.kpis = kpis;
	}

}