package com.co.beca.common.usuario.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	public Curso(Long id, String nombre,Date createAt) {
		this.id = id;
		this.nombre = nombre;
		this.createAt = createAt;
		this.listaAlumno = new ArrayList<>();
	}
	
	public Curso() {
		
	}
	
	@PrePersist
	private void prePersist() {
		this.createAt = new Date();
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Alumno> listaAlumno;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getcreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public List<Alumno> getListaAlumno() {
		return listaAlumno;
	}
	public void setListaAlumno(List<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}
	public void addAlumnos(Alumno alumno) {
		this.listaAlumno.add(alumno);
	}
	public void removeAlumnos(Alumno alumno) {
		this.listaAlumno.remove(alumno);
	}
	
}
