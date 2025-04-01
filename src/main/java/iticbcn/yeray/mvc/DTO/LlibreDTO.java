package iticbcn.yeray.mvc.DTO;

import java.time.LocalDate;

public class LlibreDTO {
    private int idLlibre;
    private String titol;
    private String autor;
    private String editorial;
    private LocalDate datapublicacio;
    private String tematica;
    private String isbn;

    public int getIdLlibre() {
        return idLlibre;
    }

    public void setIdLlibre(int idLlibre) {
        this.idLlibre = idLlibre;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getDatapublicacio() {
        return datapublicacio;
    }

    public void setDatapublicacio(LocalDate datapublicacio) {
        this.datapublicacio = datapublicacio;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}