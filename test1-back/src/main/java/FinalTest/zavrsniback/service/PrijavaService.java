package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.Prijava;

public interface PrijavaService {

	Prijava findOne(Long id);

	List<Prijava> findAll();

	Prijava save(Prijava prijava);
}
