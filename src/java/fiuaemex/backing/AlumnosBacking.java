/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Alumnos;
import fiuaemex.facade.AlumnosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class AlumnosBacking implements Serializable{
    
    @EJB
    private AlumnosFacadeLocal alumnosFacade;
    
    private List<Alumnos> listaAlumnos;
    private Alumnos alumno;
    private boolean muestraDialogo;
    /**
     * Creates a new instance of AlumnosBacking
     */
    public AlumnosBacking() {
    }

    public List<Alumnos> getListaAlumnos() {
        consultar();
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumnos> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }
    
    public void consultar(){
        listaAlumnos = alumnosFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        alumno = new Alumnos();
        consultar();
    }

    public boolean isMuestraDialogo() {
        return muestraDialogo;
    }

    public void setMuestraDialogo(boolean muestraDialogo) {
        this.muestraDialogo = muestraDialogo;
    }
    
    public void cerrarDialogo(){
        muestraDialogo = false;
    }
    
    public void seleccionarAlumno(Alumnos a){
        alumno = a;
        muestraDialogo = true;
    }
    
    public void nuevo(){
        alumno = new Alumnos();
        muestraDialogo = true;
    }
    
    public void guardar(){
        try{
            this.alumnosFacade.edit(alumno);
            consultar();
            cerrarDialogo();
            init();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void eliminar (Alumnos a){
        alumnosFacade.remove(a);
        consultar();
    }
    
}
