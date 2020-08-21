package com.danang.travel.repositories;

import com.danang.travel.models.dao.TourTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourTicketRepository extends JpaRepository<TourTicket, Integer> {
}
