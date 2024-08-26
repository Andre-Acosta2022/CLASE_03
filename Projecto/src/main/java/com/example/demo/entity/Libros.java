package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libro")
public class Libros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "paginas")
	private int paginas;
	@Column(name = "edicion")
	private String edicion;
	@Column(name = "seccion")
	private int seccion;
	@Column(name = "estado")
	private String estado;

	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false)
	private Seccion secciones;
	@ManyToOne
	@JoinColumn(name = "editorial_id", nullable = false)
	private Editorial editorial;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(
			name="libro_autor",
	joinColumns =@JoinColumn(name="libro_id", referencedColumnName ="id"),
	inverseJoinColumns = @JoinColumn(name="autor_id",referencedColumnName ="id")
	)
	private Set<Autor> autores;

}
