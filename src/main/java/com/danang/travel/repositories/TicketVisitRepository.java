package com.danang.travel.repositories;

import com.danang.travel.models.dao.TicketVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketVisitRepository extends JpaRepository<TicketVisit,Integer> {
}
