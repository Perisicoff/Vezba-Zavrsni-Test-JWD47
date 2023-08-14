package FinalTest.zavrsniback.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalTest.zavrsniback.model.Format;
import FinalTest.zavrsniback.repository.FormatRepository;
import FinalTest.zavrsniback.service.FormatService;

@Service
public class JPAFormatService implements FormatService {

	@Autowired
	private FormatRepository formatRepository;

	@Override
	public List<Format> findAll() {
		return formatRepository.findAll();
	}

	@Override
	public Format findOne(Long id) {
		Optional<Format> format = formatRepository.findById(id);
		if (format.isPresent()) {
			return format.get();
		}
		return null;
	}

	@Override
	public Format save(Format format) {
		return formatRepository.save(format);
	}

}
