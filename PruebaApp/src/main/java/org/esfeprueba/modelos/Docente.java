package org.esfeprueba.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nombre es requerido")
    private String nombre;

    @NotBlank(message = "Apellido es requerido")
    private String apellido;

    @NotBlank(message = "El Email es requerido")
    @Email(message = "la entrada no corresponde a un Email valido")
    private String email;

    @NotBlank(message = "El Telefono es requerido")
    private String telefono;

    @NotBlank(message = "La escuela es requerido")
    private String escuela;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Nombre es requerido") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "Nombre es requerido") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Apellido es requerido") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "Apellido es requerido") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El Email es requerido") @Email(message = "la entrada no corresponde a un Email valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El Email es requerido") @Email(message = "la entrada no corresponde a un Email valido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "El Telefono es requerido") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El Telefono es requerido") String telefono) {
        this.telefono = telefono;
    }

    public @NotBlank(message = "La escuela es requerido") String getEscuela() {
        return escuela;
    }

    public void setEscuela(@NotBlank(message = "La escuela es requerido") String escuela) {
        this.escuela = escuela;
    }
}
