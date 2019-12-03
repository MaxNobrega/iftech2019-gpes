package br.ifpb.iftech2019.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_categoria")
@NoArgsConstructor
@Data
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;

	@NotBlank
	@Size(max = 35)
	private String titulo;

	@ManyToMany
	
	@JoinTable(name="boaspraticas_categorias", joinColumns=
	
{@JoinColumn(name="boapratica_id")}, inverseJoinColumns=
	{@JoinColumn(name="categoria_id")})
	private List<BoaPratica> boasPraticas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<BoaPratica> getBoasPraticas() {
		return boasPraticas;
	}

	public void setBoasPraticas(List<BoaPratica> boasPraticas) {
		this.boasPraticas = boasPraticas;
	}


}
