package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Takmicenje;
import FinalTest.zavrsniback.repository.TakmicenjeRepository;
import FinalTest.zavrsniback.service.TakmicenjeService;

@Service
public class JPATakmicenjeService implements TakmicenjeService {

	@Autowired
	private TakmicenjeRepository takmicenjeRepository;

	@Override
	public Takmicenje findOne(Long id) {
		Optional<Takmicenje> takmicenje = takmicenjeRepository.findById(id);
		if (takmicenje.isPresent()) {
			return takmicenje.get();
		}
		return null;
	}

	@Override
	public List<Takmicenje> findAll() {
		return null;
	}

	@Override
	public Page<Takmicenje> findAll(int brojStranice) {
		return takmicenjeRepository.findAll(PageRequest.of(brojStranice, 3));
	}

	@Override
	public Page<Takmicenje> search(Long formatId, String mestoOdrzavanja, int brojStranice) {
		return takmicenjeRepository.search(formatId, mestoOdrzavanja, PageRequest.of(brojStranice, 2));
	}

	@Override
	public Takmicenje save(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje update(Takmicenje takmicenje) {
		return takmicenjeRepository.save(takmicenje);
	}

	@Override
	public Takmicenje delete(Long id) {
		Takmicenje takmicenje = findOne(id);
		if (takmicenje != null) {
			takmicenjeRepository.deleteById(id);
			return takmicenje;
		}
		return null;
	}

}
