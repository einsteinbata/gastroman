package com.bata.exemp.repository.bill;

import com.bata.exemp.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
