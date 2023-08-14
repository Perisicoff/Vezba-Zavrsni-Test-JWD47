package FinalTest.zavrsniback.service;

import java.util.List;

import FinalTest.zavrsniback.model.Format;

public interface FormatService {

	Format findOne(Long id);

	List<Format> findAll();

	Format save(Format format);
}
