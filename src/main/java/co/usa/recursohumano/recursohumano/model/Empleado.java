package co.usa.recursohumano.recursohumano.model;

import java.io.Serializable;

import javax.persistence.*; //es la de Entity, pero como son varias de Persistence, entonces mejor el * 

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable  {

    //Campo llave primaria y autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numId;
    private String nombre;
    private Integer edad;
    private String ciudad;
    private Integer salario;

    //Creación de la relación como dependiente del departamento
    @ManyToOne
    @JoinColumn(name = "deparamento_id")
    @JsonIgnoreProperties("empleado")
    private Departamento departamento;

    
    public Integer getNumId() {
        return numId;
    }
    public void setNumId(Integer numId) {
        this.numId = numId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Integer getSalario() {
        return salario;
    }
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
        

    
}
