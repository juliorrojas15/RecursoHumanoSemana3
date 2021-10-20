package co.usa.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumano.recursohumano.model.Departamento;
import co.usa.recursohumano.recursohumano.repository.DepartamentoRepositorio;

@Service                //Esto es para determinar esta clase de SpringBoot, para poder administrar la lógica
public class DepartamentoServicio {
    
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    public List<Departamento> getAll(){
        return departamentoRepositorio.getAll();
    }

    public Optional<Departamento> getDepartamento(int Id){
        return departamentoRepositorio.getDepartamento(Id);
    }

    public Departamento	save (Departamento dpto){
        //Verificar si el objeto es nuevo, de ser así guardar

        if(dpto.getNumId() == null){    //Si no viene con ID, entonces guardar como nuevo
            return departamentoRepositorio.save(dpto);
        }
        else{   //Si viene con ID, hay dos opciones, que exista o no
            Optional<Departamento> consulta = departamentoRepositorio.getDepartamento(dpto.getNumId());
            if(consulta.isEmpty()){     //Si la consulta de codigos no existe pues guardar como nuevo
                return departamentoRepositorio.save(dpto);

            }else{      //Pero si si existia en la consulta, entoces sobreescribirlo
                return dpto;
            }

        }
    }

    public Departamento update (Departamento dpto){
        
        //Verificar si se ingresó un número de ID
        if (dpto.getNumId() != null){
            Optional<Departamento> consulta = departamentoRepositorio.getDepartamento(dpto.getNumId());
            if (!consulta.isEmpty()){
                if (dpto.getNombreDepartamento() != null){
                    consulta.get().setNombreDepartamento(dpto.getNombreDepartamento());
                }
                if (dpto.getFechaCreacionDate() != null){
                    consulta.get().setFechaCreacionDate(dpto.getFechaCreacionDate());
                }
                if (dpto.getEmpleados() != null){
                    consulta.get().setEmpleados(dpto.getEmpleados());
                }
                return departamentoRepositorio.save(consulta.get());
            } 
        }
        return dpto;
    }

}

