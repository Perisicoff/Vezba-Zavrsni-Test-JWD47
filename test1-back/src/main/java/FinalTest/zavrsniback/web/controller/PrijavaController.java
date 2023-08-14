package FinalTest.zavrsniback.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Format;
import FinalTest.zavrsniback.model.Prijava;
import FinalTest.zavrsniback.model.Takmicenje;
import FinalTest.zavrsniback.service.FormatService;
import FinalTest.zavrsniback.service.PrijavaService;
import FinalTest.zavrsniback.service.TakmicenjeService;
import FinalTest.zavrsniback.support.PrijavaDTOToPrijava;
import FinalTest.zavrsniback.web.dto.PrijavaDTO;

@RestController
@RequestMapping(value = "/api/prijava", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrijavaController {

	@Autowired
	private TakmicenjeService takmicenjeService;

	@Autowired
	private PrijavaService prijavaService;

	@Autowired
	private FormatService formatService;

	@Autowired
	private PrijavaDTOToPrijava toPrijava;

	@PreAuthorize("hasRole('ROLE_KORISNIK')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> prijava(@Valid @RequestBody PrijavaDTO prijavaDTO) {

		Takmicenje takmicenje = takmicenjeService.findOne(prijavaDTO.getTakmicenjeId());
		if (takmicenje == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<Prijava> prijave = prijavaService.findAll();
		for (Prijava prijava : prijave) {
			if (prijava.getEmail().equals(prijavaDTO.getEmail())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		Format format = takmicenje.getFormat();
		if (format.getBrojUcesnika() > 0) {
			int noviBrojUcesnika = format.getBrojUcesnika() - 1;
			format.setBrojUcesnika(noviBrojUcesnika);
			formatService.save(format);

			Prijava prijava = toPrijava.convert(prijavaDTO);
			prijavaService.save(prijava);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
