package com.example.demo.models.domain;

import jakarta.validation.constraints.*;

public class usuario {
    //Variables
    @NotBlank
    @Pattern(regexp="[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}", message = "El formato esperado es: [00][.][000][.][000][-][A-Z]")
    private String identificador;
    @NotBlank(message = "El campo nombre no puede estas vacío")
    @Size(min=3, max = 60)
    private String nombre;

    @NotBlank(message = "El campo apellido no puede estas vacío")
    @Size(min=3, max = 60)
    private String apellido;
    @NotBlank
    @Size(min=3, max = 60)
    private String usuario;
    @NotBlank
    @Size(min=3, max = 60)
    private String contrasena;
    @NotBlank(message = "El campo correo no puede estas vacío")
    @Size(min=3, max = 60)
    @Email(message = "Correo con formato incorrecto")//validación de correos
    private String correo;

    //Getters and Setters

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
