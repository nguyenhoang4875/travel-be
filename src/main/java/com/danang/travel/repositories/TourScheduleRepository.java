package com.danang.travel.repositories;

import com.danang.travel.models.dao.TourSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourScheduleRepository extends JpaRepository<TourSchedule,Integer> {
}
