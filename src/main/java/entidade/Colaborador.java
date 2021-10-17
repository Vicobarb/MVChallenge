package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador {

	@Id
	@Column (name = "CPF", nullable = false)
	private String cpf;
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@OneToMany (mappedBy = "colaborador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CafeManha> listaCafe;

	@Override
	public String toString() {
		return "Colaborador cpf= " + cpf + ", Nome= " + nome + ", ListaCafe= " + listaCafe + "\n";
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CafeManha> getListaCafe() {
		return listaCafe;
	}

	public void setListaCafe(List<CafeManha> listaCafe) {
		this.listaCafe = listaCafe;
	}

	@Override
	public boolean equals(Object obj) {
		Colaborador colaboradorEntrada = (Colaborador) obj;

		if (this.cpf.equalsIgnoreCase(colaboradorEntrada.getCpf())) {
			return true;
		} else {
			return false;
		}
	}
}
