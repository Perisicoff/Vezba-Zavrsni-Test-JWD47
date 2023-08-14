package FinalTest.zavrsniback.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalTest.zavrsniback.model.Format;
import FinalTest.zavrsniback.service.FormatService;
import FinalTest.zavrsniback.support.FormatToFormatDTO;
import FinalTest.zavrsniback.web.dto.FormatDTO;

@RestController
@RequestMapping(value = "/api/formati", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormatController {

	@Autowired
	private FormatService formatService;

	@Autowired
	private FormatToFormatDTO toFormatDTO;

	@GetMapping
	public ResponseEntity<List<FormatDTO>> getAll() {
		
		List<Format> formati = formatService.findAll();
		
		return new ResponseEntity<>(toFormatDTO.convert(formati), HttpStatus.OK);
	}
}
