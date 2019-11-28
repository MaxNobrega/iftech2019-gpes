package br.ifpb.iftech2019.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pratica")
@NoArgsConstructor
public class BoaPratica {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_boapratica")
	private Long id;

	@NotBlank
	@Size(max = 50)
	private String titulo;

	@ManyToMany(mappedBy="boasPraticas")
	private List<Categoria> categorias = new ArrayList<Categoria>();

	public Boolean adicionarCategoria(Categoria categ) {
		categorias.add(categ);
		return true;
	}

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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}



}
