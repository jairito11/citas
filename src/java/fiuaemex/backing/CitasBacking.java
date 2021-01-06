/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Asesores;
import fiuaemex.entities.Citas;
import fiuaemex.facade.CitasFacadeLocal;
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
public class CitasBacking implements Serializable{
    
    @EJB
    private CitasFacadeLocal citasFacade;
    
    private List<Citas> listaCitas;
    private Citas cita;
    private Alumnos alumno;
    private Asesores asesor;
    private boolean muestraDialogo;
    /**
     * Creates a new instance of CitasBacking
     */
    public CitasBacking() {
    }
    
    
    
    public List<Citas> getListaCitas() {
        consultar();
        return listaCitas;
    }

    public void setListaCitas(List<Citas> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Asesores getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesores asesor) {
        this.asesor = asesor;
    }

    public void consultar(){
        listaCitas = citasFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        cita = new Citas();
        alumno = new Alumnos();
        asesor = new Asesores();
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
        
    public void seleccionarCita(Citas c){
        cita = c;
        muestraDialogo = true;
    }
    
    public void nuevo(){
        cita = new Citas();
        muestraDialogo = true;
    }
    
    public void guardar(){
        try{
            this.cita.setAlumnoId(alumno);
            this.cita.setAsesorId(asesor);
            this.citasFacade.edit(cita);
            consultar();
            cerrarDialogo();
            init();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void eliminar(Citas c){
        citasFacade.remove(c);
        consultar();
    }
}
