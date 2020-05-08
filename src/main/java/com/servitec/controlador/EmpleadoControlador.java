package com.servitec.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servitec.modelo.entidad.Empleado;

import com.servitec.modelo.servicio.interfaz.IEmpleadoServicio;

@RestController
@RequestMapping("/empleado")
public class EmpleadoControlador {
     
	@Autowired
	private IEmpleadoServicio empleadoServicio;
	
	@RequestMapping
	public List<Empleado> listar(){
		return this.empleadoServicio.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(Empleado empleado) {
		this.empleadoServicio.save(empleado);
	}
	
	@RequestMapping("/{id}")
	public Empleado buscar(@PathVariable Long id) {
		return this.empleadoServicio.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
		Empleado empleadoActual = this.empleadoServicio.findById(id);
		empleadoActual.setAlias(empleado.getAlias());
		empleadoActual.setContrasena(empleado.getContrasena());
		this.empleadoServicio.save(empleadoActual);
		return empleadoActual;
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public Empleado eliminar(@PathVariable Long id) {
		Empleado empleadoActual = this.empleadoServicio.findById(id);
		this.empleadoServicio.delete(empleadoActual);
		return empleadoActual;
	}
	
	
}
