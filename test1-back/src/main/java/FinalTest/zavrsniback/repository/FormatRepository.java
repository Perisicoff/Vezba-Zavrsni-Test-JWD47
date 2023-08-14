package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Format;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {

}
