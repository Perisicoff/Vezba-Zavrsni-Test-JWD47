package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import FinalTest.zavrsniback.model.Prijava;
import FinalTest.zavrsniback.repository.PrijavaRepository;
import FinalTest.zavrsniback.service.PrijavaService;

@Service
public class JPAPrijavaService implements PrijavaService {

	@Autowired
	private PrijavaRepository prijavaRepository;

	@Override
	public Prijava save(Prijava prijava) {
		return prijavaRepository.save(prijava);
	}

	@Override
	public Prijava findOne(Long id) {
		Optional<Prijava> prijava = prijavaRepository.findById(id);
		if (prijava.isPresent()) {
			return prijava.get();
		}
		return null;
	}

	@Override
	public List<Prijava> findAll() {
		return prijavaRepository.findAll();
	}

}
