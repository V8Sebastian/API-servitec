package com.servitec.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servitec.modelo.dao.interfaz.IAliadoDao;
import com.servitec.modelo.entidad.Aliado;
import com.servitec.modelo.servicio.interfaz.IAliadoServicio;

@Service
public class AliadoServicioImpl implements IAliadoServicio {

	@Autowired
	private IAliadoDao aliadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Aliado> findAll() {
		return (List<Aliado>) this.aliadoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Aliado Aliado) {
		this.aliadoDao.save(Aliado);
	}

	@Override
	@Transactional(readOnly = true)
	public Aliado findById(Long id) {
		return this.aliadoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Aliado aliado) {
		this.aliadoDao.delete(aliado);

	}

}