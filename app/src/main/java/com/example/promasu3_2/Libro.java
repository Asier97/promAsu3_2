package com.example.promasu3_2;

public class Libro {

    private int isbn;
    private String nombre;
    private String autor;
    private String genero;
    private String descripcion;

    public Libro(){}

    public Libro(int isbn,String nombre,String autor,String genero,String descripcion) {
        this.isbn=isbn;
        this.nombre=nombre;
        this.autor=autor;
        this.genero=genero;
        this.descripcion=descripcion;
    }

    public int getIsbn() {return isbn;}
    public String getNombre() {return nombre;}
    public String getAutor() {return autor;}
    public String getGenero() {return genero;}
    public String getDescripcion() {return descripcion;}

    public void setIsbn(int isbn) {this.isbn=isbn;}
    public void setNombre(String nombre) {this.nombre=nombre;}
    public void setAutor(String autor) {this.autor=autor;}
    public void setGenero(String genero) {this.genero=genero;}
    public void setDescripcion(String descripcion) {this.descripcion=descripcion;}
}
