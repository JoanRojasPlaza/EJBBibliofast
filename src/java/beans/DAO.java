/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Autor;
import model.Categoria;
import model.Editorial;
import model.Estado;
import model.Idioma;
import model.Libro;


@Stateless
public class DAO implements IDAO{
    @PersistenceContext(unitName = "EJBBibliofastPU")
    private EntityManager em;
    /**
     * @author joan
     * @param isbn
     * @param titulo
     * @param numPags
     * @param precioRef
     * @param anioPublic
     * @param publicacion
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int registrarL(String isbn, String titulo, int numPags, int precioRef, int anioPublic, int publicacion) {
        Libro l = new Libro();
        l.setIsbn(isbn);
        l.setTitulo(titulo);
        l.setNumPags(numPags);
        l.setPrecioRef(precioRef);
        l.setAnioPublic(anioPublic);
        l.setPublicacion(publicacion);
        em.persist(l);
        return 1;
    }
    /**
     * @author joan
     * @param numSerie
     * @param isbn
     * @param titulo
     * @param numPags
     * @param precioRef
     * @param anioPublic
     * @param publicacion
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int modificarL(int numSerie,String isbn, String titulo, int numPags, int precioRef, int anioPublic, int publicacion) {
        Libro l = buscarL(numSerie);
        if (l != null) {
            l.setIsbn(isbn);
            l.setTitulo(titulo);
            l.setNumPags(numPags);
            l.setPrecioRef(precioRef);
            l.setAnioPublic(anioPublic);
            l.setPublicacion(publicacion);
            em.merge(l);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param numSerie
     * @return un objeto libro, siempre y cuando el id exista
     */
    @Override
    public Libro buscarL(int numSerie) {
        Libro l = em.find(Libro.class, numSerie);
        return l;
    }
    /**
     * @author joan
     * @return una lista de objetos Libro
     */
    @Override
    public List<Libro> mostrarTodosL() {
        return em.createNamedQuery("Libro.findAll").getResultList();
    }
    /**
     * @author joan
     * @param numserie
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int eliminarL(int numserie) {
        Libro l = buscarL(numserie);
        if (l != null) {
            em.remove(l);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param nombre
     * @param apePat
     * @param apeMat
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int registrarA(String nombre, String apePat, String apeMat) {
        Autor a = new Autor();
        a.setNombre(nombre);
        a.setApePaterno(apePat);
        a.setApeMaterno(apeMat);
        em.persist(a);
        return 1;
    }
    /**
     * @author joan
     * @param idAutor
     * @param nombre
     * @param apePat
     * @param apeMat
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int modificarA(int idAutor, String nombre, String apePat, String apeMat) {
        Autor a = buscarA(idAutor);
        if (a != null) {
            a.setNombre(nombre);
            a.setApePaterno(apePat);
            a.setApeMaterno(apeMat);
            em.merge(a);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param idAutor
     * @return un objeto Autor, siempre y cuando el id exista
     */
    @Override
    public Autor buscarA(int idAutor) {
        Autor a = em.find(Autor.class, idAutor);
        return a;
    }
    /**
     * @author joan
     * @return una lista de objetos Autor
     */
    @Override
    public List<Autor> mostrarTodosA() {
        return em.createNamedQuery("Autor.findAll").getResultList();
    }
    /**
     * @author joan
     * @param idAutor
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int eliminarA(int idAutor) {
        Autor a = buscarA(idAutor);
        if (a != null) {
            em.remove(a);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param nombreEdit
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int registrarE(String nombreEdit) {
        Editorial e = new Editorial();
        e.setNombreEdit(nombreEdit);
        em.persist(e);
        return 1;
    }
    /**
     * @author joan
     * @param idEdit
     * @param nombreEdit
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int modificarE(int idEdit, String nombreEdit) {
        Editorial e = buscarE(idEdit);
        if (e != null) {
            e.setNombreEdit(nombreEdit);
            em.merge(e);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param idEdit
     * @return un objeto Editorial, siempre y cuando el id exista
     */
    @Override
    public Editorial buscarE(int idEdit) {
        Editorial e = em.find(Editorial.class, idEdit);
        return e;       
    }
    /**
     * @author joan
     * @return una lista de objetos Editorial
     */
    @Override
    public List<Editorial> mostrarTodosE() {
        return em.createNamedQuery("Editorial.findAll").getResultList();
    }
    /**
     * @author joan
     * @param idEdit
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int eliminarE(int idEdit) {
        Editorial e = buscarE(idEdit);
        if (e != null) {
            em.remove(e);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param nombreCate
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int registrarC(String nombreCate) {
        Categoria c = new Categoria();
        c.setNombreCate(nombreCate);
        em.persist(this);
        return 1;
    }
    /**
     * @author joan
     * @param idCate
     * @param nombreCate
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int modificarC(int idCate, String nombreCate) {
        Categoria c = buscarC(idCate);
        if (c != null) {
            c.setNombreCate(nombreCate);
            em.merge(c);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param idCate
     * @return un objeto Categoria, siempre y cuando el id exista
     */
    @Override
    public Categoria buscarC(int idCate) {
        Categoria c = em.find(Categoria.class, idCate);
        return c;
    }
    /**
     * @author joan
     * @return una lista de objetos Categoria
     */
    @Override
    public List<Categoria> mostrarTodosC() {
        return em.createNamedQuery("Categoria.findAll").getResultList();
    }
    /**
     * @author joan
     * @param idCate
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int eliminarC(int idCate) {
        Categoria c = buscarC(idCate);
        if (c != null) {
            em.remove(c);
            return 1;
        } 
        return 2;
    }
    /**
     * @author joan
     * @param nombreIdioma
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int registrarI(String nombreIdioma) {
        Idioma i = new Idioma();
        i.setNombreIdioma(nombreIdioma);
        em.persist(i);
        return 1;
    }
    /**
     * @author joan
     * @param idIdioma
     * @param nombreIdioma
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int modificarI(int idIdioma, String nombreIdioma) {
        Idioma i = buscarI(idIdioma);
        if (i != null) {
            i.setNombreIdioma(nombreIdioma);
            em.merge(i);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param idIdioma
     * @return un objeto Idioma, siempre y cuando el di exista
     */
    @Override
    public Idioma buscarI(int idIdioma) {
        Idioma i = em.find(Idioma.class, idIdioma);
        return i;
    }
    /**
     * @author joan
     * @return una lista de objetos Idioma
     */
    @Override
    public List<Idioma> mostrarTodosI() {
        return em.createNamedQuery("Idioma.findAll").getResultList();
    }
    /**
     * @author joan
     * @param idIdioma
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int eliminarI(int idIdioma) {
        Idioma i = buscarI(idIdioma);
        if (i != null) {
            em.remove(i);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param nombreEst
     * @param Descripcion
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int registrarEst(String nombreEst, String Descripcion) {
        Estado est = new Estado();
        est.setNombreEstado(nombreEst);
        est.setDescripcionEstado(Descripcion);
        em.persist(est);
        return 1;
    }
    /**
     * @author joan
     * @param codEstado
     * @param nombreEst
     * @param Descripcion
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int ModificarEst(int codEstado, String nombreEst, String Descripcion) {
        Estado est = buscarEst(codEstado);
        if (est != null) {
            est.setNombreEstado(nombreEst);
            est.setDescripcionEstado(Descripcion);
            em.merge(est);
            return 1;
        }
        return 2;
    }
    /**
     * @author joan
     * @param codEstado
     * @return un objeto Estado, siempre y cuando el cod exista
     */
    @Override
    public Estado buscarEst(int codEstado) {
        Estado est = em.find(Estado.class, codEstado);
        return est;
    }
    /**
     * @author joan
     * @return una lista de objetos Estado
     */
    @Override
    public List<Estado> mostrarTodosEst() {
        return em.createNamedQuery("Estado.findAll").getResultList();
    }
    /**
     * @author joan
     * @param codEstado
     * @return 1 si la operación se ejecutó satisfactoriamente, 2 si hubo en error
     */
    @Override
    public int eliminarEst(int codEstado) {
        Estado est = buscarEst(codEstado);
        if (est != null) {
            em.remove(est);
            return 1;
        }
        return 2;
    }
    
}
