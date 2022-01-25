package edu.ucentral.common.productos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//Definir como Entity, obliga a tener una tabla de base de datos
//Con nombre productos, generando la conexion y persistencia
@Entity

//anotacion para la tabla de base de datos
@Table(name="productos")

//implementar la interfaz serializable y crear automatico el atributo
public class Producto implements Serializable{
	
//se agregan validaciones, el id no necesita validacion
	
	//llave de la tabla
	@Id
	//manejador de base de datos
	//identity es myqsl
	//secuence es posgres
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//el codigo no puede ir vacio y el tamaño
	@NotEmpty(message="No puede estar vacio")
	//@Size(min=3, max=20, message="El numero de caracteres debe estar entre 3 y 20")
	private String codigo;
	
	@NotEmpty(message="No puede estar vacio")
	@Size(min=2, max=40, message="El numero de caracteres debe estar entre 3 y 40")
	private String nombre;
	
	//no entre vacio y tenga valor minimo
	@NotNull
	@Min(value=0, message="El valor no puede ser negativo")
	private Double precio;
	
	//formalizacion de la fecha
	@Temporal(TemporalType.DATE)
	//como se desea guardar el atributo
	@Column(name="create_at")
	private Date createAt;
	
	//agregar imagen
	@Lob
	@JsonIgnore
	private byte[] imagen;
	
	
	//@NotNull(message="no puede estar vacia")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoria_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Categoria categoria;
	
	//para que se ejecute necesita una anotacion
	@PrePersist
	//persistencia con dato para operar
	public void prePersist() {
		this.createAt = new Date();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	//metodo de la imagen ojo con el resouce automatico
	public Integer getImagenHashCode() {
		return (this.imagen!=null)? imagen.hashCode():null;
	}

	//metodo de comparacion de objetos
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Producto)) {
			return false;
		}
		
		Producto prod = (Producto) obj;
		return this.id!=null&& this.id.equals(prod.getId());
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1269077908552966187L;
}
