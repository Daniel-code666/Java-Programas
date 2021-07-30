/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioBiblioteca;

/**
 *
 * @author Daniel
 */
public class Libro{
    protected String autor, libro;
    protected int cantDisp, cantPres;

    public Libro() {
    }

    public Libro(String autor, String libro, int cantDisp, int cantPres) {
        this.autor = autor;
        this.libro = libro;
        this.cantDisp = cantDisp;
        this.cantPres = cantPres;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public int getCantDisp() {
        return cantDisp;
    }

    public void setCantDisp(int cantDisp) {
        this.cantDisp = cantDisp;
    }

    public int getCantPres() {
        return cantPres;
    }

    public void setCantPres(int cantPres) {
        this.cantPres = cantPres;
    }
    
    @Override
    public String toString() {
        return "Autor=" + autor + " Libro=" + libro + ", Cantidad disponible=" + cantDisp + ", Cantidad prestada=" + cantPres;
    }
    
    
}
