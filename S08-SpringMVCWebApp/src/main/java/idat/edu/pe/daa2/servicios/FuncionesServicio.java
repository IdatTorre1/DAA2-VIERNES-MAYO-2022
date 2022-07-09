package idat.edu.pe.daa2.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.daa2.jpa.modelo.Funciones;
import idat.edu.pe.daa2.jpa.repositorios.FuncionesRepositorio;

@Service
@Transactional
public class FuncionesServicio {

	@Autowired
	public  FuncionesRepositorio repositorio;
	
	public Funciones crear(Funciones funciones) {
		return repositorio.save(funciones);
		
	}
	
	public List<Funciones> buscarTodo(){
		return (ArrayList<Funciones>) repositorio.findAll();
		
	}
	
	public  Funciones actualizar(Funciones funcionesActualizar) {
		
		Funciones funcionActual = repositorio.findById(funcionesActualizar.getIdFunciones()).get();
		funcionActual.setIdFunciones(funcionesActualizar.getIdFunciones());
		funcionActual.setHoraInicio(funcionesActualizar.getHoraInicio());
		funcionActual.setHoraFin(funcionesActualizar.getHoraFin());
		funcionActual.setPrecio(funcionesActualizar.getPrecio());
		Funciones funcionesActualizado = repositorio.save(funcionActual);
		return funcionesActualizado;
	}
	
	public Funciones buscarPorID(Integer id) {
		return repositorio.findById(id).get();
		
	}
	
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
		
	}
	
	public void actualizar (int id, Funciones funcion) {
	
	Funciones  funcionesActual = repositorio.findById(id).get();
	funcionesActual.setHoraInicio(funcion.getHoraInicio());
	funcionesActual.setHoraFin(funcion.getHoraFin());
	funcionesActual.setPelicula(funcion.getPelicula());
	funcionesActual.setPrecio(funcion.getPrecio());
	funcionesActual.setSala(funcion.getSala());
	repositorio.save(funcionesActual);

	}

}
