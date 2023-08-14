package FinalTest.zavrsniback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FinalTest.zavrsniback.model.Prijava;

@Repository
public interface PrijavaRepository extends JpaRepository<Prijava, Long> {

}
