package FinalTest.zavrsniback.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Takmicenje;

@Repository
public interface TakmicenjeRepository extends JpaRepository<Takmicenje, Long> {

	@Query("SELECT t FROM Takmicenje t WHERE" +
			"(:formatId IS NULL OR t.format.id = :formatId) AND " +
			"(:mestoOdrzavanja IS NULL OR t.mestoOdrzavanja LIKE %:mestoOdrzavanja%)")
	Page<Takmicenje> search(@Param("formatId") Long formatId, @Param("mestoOdrzavanja") String mestoOdrzavanja, Pageable pageable);
}
