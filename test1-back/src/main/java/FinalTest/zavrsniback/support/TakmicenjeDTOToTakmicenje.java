package FinalTest.zavrsniback.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import FinalTest.zavrsniback.model.Takmicenje;
import FinalTest.zavrsniback.service.FormatService;
import FinalTest.zavrsniback.service.TakmicenjeService;
import FinalTest.zavrsniback.web.dto.TakmicenjeDTO;

@Component
public class TakmicenjeDTOToTakmicenje implements Converter<TakmicenjeDTO, Takmicenje> {
	
	@Autowired
	private TakmicenjeService takmicenjeService;
	
	@Autowired
	private FormatService formatService;

	@Override
	public Takmicenje convert(TakmicenjeDTO takmicenjeDTO) {
		Takmicenje takmicenje;

	        if(takmicenjeDTO.getId() == null){
	        	takmicenje = new Takmicenje();
	        }else{
	        	takmicenje = takmicenjeService.findOne(takmicenjeDTO.getId());
	        }

	        if(takmicenje != null){
	        	takmicenje.setNaziv(takmicenjeDTO.getNaziv());
	        	takmicenje.setMestoOdrzavanja(takmicenjeDTO.getMestoOdrzavanja());
	        	takmicenje.setDatumPocetka(getLocalDate(takmicenjeDTO.getDatumPocetka()));
	        	takmicenje.setDatumZavrsetka(getLocalDate(takmicenjeDTO.getDatumZavrsetka()));
	        	takmicenje.setFormat(formatService.findOne(takmicenjeDTO.getFormatId()));
	        }
	        return takmicenje;
	}
	
	 private LocalDate getLocalDate(String date) throws DateTimeParseException {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        return LocalDate.parse(date, formatter);
	    }
}
