package co.usa.recursohumano.recursohumano.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.recursohumano.recursohumano.model.Empleado;
import co.usa.recursohumano.recursohumano.repository.EmpleadoRepositorio;

@Service
public class EmpleadoServicio {
    
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado> getAll(){
        return empleadoRepositorio.getAll();
    }

    public Optional<Empleado> getEmpleado(int Id){
        return empleadoRepositorio.getEmpleado(Id);
    }

    public Empleado	save (Empleado empleado){
        //Verificar si el objeto es nuevo, de ser así guardar

        if(empleado.getNumId() == null){    //Si no viene con ID, entonces guardar como nuevo
            return empleadoRepositorio.save(empleado);
        }
        else{   //Si viene con ID, hay dos opciones, que exista o no
            Optional<Empleado> consulta = empleadoRepositorio.getEmpleado(empleado.getNumId());
            if(consulta.isEmpty()){     //Si la consulta de codigos no existe pues guardar como nuevo
                return empleadoRepositorio.save(empleado);

            }else{      //Pero si si existia en la consulta, entoces sobreescribirlo
                return empleado;
            }

        }
    }
}
