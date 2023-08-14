package FinalTest.zavrsniback.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import FinalTest.zavrsniback.model.Takmicenje;
import FinalTest.zavrsniback.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeToTakmicenjeDTO implements Converter<Takmicenje, TakmicenjeDTO> {

	@Override
	public TakmicenjeDTO convert(Takmicenje takmicenje) {
		TakmicenjeDTO takmicenjeDTO = new TakmicenjeDTO();

		takmicenjeDTO.setId(takmicenje.getId());
		takmicenjeDTO.setNaziv(takmicenje.getNaziv());
		takmicenjeDTO.setMestoOdrzavanja(takmicenje.getMestoOdrzavanja());
		takmicenjeDTO.setDatumPocetka(takmicenje.getDatumPocetka().toString());
		takmicenjeDTO.setDatumZavrsetka(takmicenje.getDatumZavrsetka().toString());
		takmicenjeDTO.setFormatId(takmicenje.getFormat().getId());
		takmicenjeDTO.setNazivFormata(takmicenje.getFormat().getTip());
		takmicenjeDTO.setBrojUcesnika(takmicenje.getFormat().getBrojUcesnika());

		return takmicenjeDTO;
	}

	public List<TakmicenjeDTO> convert(List<Takmicenje> takmicenja) {
		List<TakmicenjeDTO> takmicenjeDTOS = new ArrayList<>();

		for (Takmicenje takmicenje : takmicenja) {
			takmicenjeDTOS.add(convert(takmicenje));
		}

		return takmicenjeDTOS;
	}
}
