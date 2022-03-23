package hu.dia.tacocloud.repository;

import hu.dia.tacocloud.model.data.Taco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {
}
