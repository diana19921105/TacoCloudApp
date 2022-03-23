package hu.dia.tacocloud.repository;

import hu.dia.tacocloud.model.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByZip(String zip);

    List<Order> findAllByZipAndAndPlacedAtBetween(String zip, Date start, Date end);
}
