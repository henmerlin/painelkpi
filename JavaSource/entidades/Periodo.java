package entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(schema="PUBLIC", name="KPI_PERIODOS")
public class Periodo{
	
	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty
	private String nome;
	
	@OneToMany(mappedBy="periodo", fetch=FetchType.EAGER)
	private List<Resultado> resultado;
	
	@NotNull 
	private Date data;

	public Periodo() {
	
	}


	public Integer getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public List<Resultado> getResultado() {
		return resultado;
	}


	public void setResultado(List<Resultado> resultado) {
		this.resultado = resultado;
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
		Periodo other = (Periodo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Periodo [id=" + id + "]";
	}
	
	
	
	
}
