/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Remote;
import model.Autor;
import model.Categoria;
import model.Editorial;
import model.Estado;
import model.Idioma;
import model.Libro;

/**
 *
 * @author 56982
 */
@Remote
public interface IDAO {
    //Métodos de Libro
    public int registrarL(String isbn, String titulo, int numPags, int precioRef, int anioPublic, int publicacion);
    public int modificarL(int numSerie,String isbn, String titulo, int numPags, int precioRef, int anioPublic, int publicacion);
    public Libro buscarL(int numSerie);
    public List<Libro> mostrarTodosL();
    public int eliminarL(int numserie);
    //Métodos de Autor
    public int registrarA(String nombre, String apePat, String apeMat);
    public int modificarA(int idAutor, String nombre, String apePat, String apeMat);
    public Autor buscarA(int idAutor);
    public List<Autor> mostrarTodosA();
    public int eliminarA(int idAutor);
    //Métodos de editorial
    public int registrarE(String nombreEdit);
    public int modificarE(int idEdit, String nobreEdit);
    public Editorial buscarE(int idEdit);
    public List<Editorial> mostrarTodosE();
    public int eliminarE(int idEdit);
    //Métodos de categoría
    public int registrarC(String nombreCate);
    public int modificarC(int idCate, String nombreCate);
    public Categoria buscarC(int idCate);
    public List<Categoria> mostrarTodosC();
    public int eliminarC(int idCate);
    //Métodos de idioma
    public int registrarI(String nombreIdioma);
    public int modificarI(int idIdioma, String nombreIdioma);
    public Idioma buscarI(int idIdioma);
    public List<Idioma> mostrarTodosI();
    public int eliminarI(int idIdioma);
    //Métodos de estado
    public int registrarEst(String nombreEst, String Descripcion);
    public int ModificarEst(int codEstado, String nombreEst, String Descripcion);
    public Estado buscarEst(int codEstado);
    public List<Estado> mostrarTodosEst();
    public int eliminarEst(int codEstado);
    }
