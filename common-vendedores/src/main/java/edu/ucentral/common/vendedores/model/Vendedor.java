package edu.ucentral.common.vendedores.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name="vendedores")
public class Vendedor implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="No puede estar vacio")
	@Size(min=2, max=40, message="El numero de caracteres debe estar entre 3 y 40")
	private String nombre;
	private String nivel;
	private String documento;
	private String direccion;
	private String correo;
	private String telefono;
	
	@Temporal(TemporalType.DATE)
	@Column(name="create_at")
	private Date createAt;

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	


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




	public String getNivel() {
		return nivel;
	}




	public void setNivel(String nivel) {
		this.nivel = nivel;
	}




	



	public String getDocumento() {
		return documento;
	}




	public void setDocumento(String documento) {
		this.documento = documento;
	}


	


	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public Date getCreateAt() {
		return createAt;
	}




	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Vendedor)) {
			return false;
		}
		
		Vendedor client = (Vendedor) obj;
		return this.id!=null&& this.id.equals(client.getId());
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
