package co.usa.recursohumano.recursohumano.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.recursohumano.recursohumano.model.Departamento;
import co.usa.recursohumano.recursohumano.repository.CRUD.DepartamentoCrudRepositorio;

@Repository
public class DepartamentoRepositorio {
    
    @Autowired
    private DepartamentoCrudRepositorio departamentoCrudRepositorio;

    public List<Departamento> getAll(){
        return (List<Departamento>)departamentoCrudRepositorio.findAll();
    }

    public Optional<Departamento> getDepartamento(int id){  //Opcional es un tipo de dato que empaqueta la entidad con un valor correcto y también con un valor null
        return departamentoCrudRepositorio.findById(id);
    }

    public Departamento save (Departamento dpto){
        return departamentoCrudRepositorio.save(dpto);
    }
}
