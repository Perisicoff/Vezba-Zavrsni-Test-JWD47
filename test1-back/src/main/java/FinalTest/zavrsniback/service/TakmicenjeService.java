package FinalTest.zavrsniback.service;

import java.util.List;

import org.springframework.data.domain.Page;
import FinalTest.zavrsniback.model.Takmicenje;

public interface TakmicenjeService {

	Takmicenje findOne(Long id);

	List<Takmicenje> findAll();

	Page<Takmicenje> findAll(int brojStranice);
	
	Page<Takmicenje> search(Long formatId, String mestoOdrzavanja, int brojStranice);

	Takmicenje save(Takmicenje takmicenje);

	Takmicenje update(Takmicenje takmicenje);

	Takmicenje delete(Long id);
}
