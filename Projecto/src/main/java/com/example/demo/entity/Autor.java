package com.example.demo.entity;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table(name="autor")
	public class Autor {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
	    private Long id;
		@Column(name = "nombres")
	    private String nombres;
		@Column(name = "apellidos")
	    private int apellidos;
		@Column(name = "pais")
	    private String pais;
		@Column(name = "estado")
	    private char estado;
		
}
