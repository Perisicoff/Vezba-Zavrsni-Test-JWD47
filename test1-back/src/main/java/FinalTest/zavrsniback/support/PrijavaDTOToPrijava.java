package FinalTest.zavrsniback.support;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import FinalTest.zavrsniback.model.Prijava;
import FinalTest.zavrsniback.service.PrijavaService;
import FinalTest.zavrsniback.service.TakmicenjeService;
import FinalTest.zavrsniback.web.dto.PrijavaDTO;

@Component
public class PrijavaDTOToPrijava implements Converter<PrijavaDTO, Prijava> {

	@Autowired
	private PrijavaService prijavaService;
	
	@Autowired
	private TakmicenjeService takmicenjeService;

	@Override
	public Prijava convert(PrijavaDTO prijavaDTO) {
		Prijava prijava;

		if (prijavaDTO.getId() == null) {
			prijava = new Prijava();
		} else {
			prijava = prijavaService.findOne(prijavaDTO.getId());
		}

		if (prijava != null) {
			prijava.setEmail(prijavaDTO.getEmail());
			prijava.setDrzava(prijavaDTO.getDrzava());
			prijava.setDatumPrijave(LocalDate.now());
			prijava.setTakmicenje(takmicenjeService.findOne(prijavaDTO.getTakmicenjeId()));
		}
		return prijava;
	}
}
