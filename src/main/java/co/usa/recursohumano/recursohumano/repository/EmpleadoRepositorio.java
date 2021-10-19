package co.usa.recursohumano.recursohumano.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.recursohumano.recursohumano.model.Empleado;
import co.usa.recursohumano.recursohumano.repository.CRUD.EmpleadoCrudRepositorio;

@Repository
public class EmpleadoRepositorio {
    @Autowired
    private EmpleadoCrudRepositorio empleadoCrudRepositorio;

    public List<Empleado> getAll(){
        return (List<Empleado>)empleadoCrudRepositorio.findAll();
    }

    public Optional<Empleado> getEmpleado(int id){  //Opcional es un tipo de dato que empaqueta la entidad con un valor correcto y también con un valor null
        return empleadoCrudRepositorio.findById(id);
    }

    public Empleado save (Empleado empleado){
        return empleadoCrudRepositorio.save(empleado);
    }
}
