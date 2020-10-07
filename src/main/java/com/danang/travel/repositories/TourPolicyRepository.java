package com.danang.travel.repositories;

import com.danang.travel.models.dao.TourPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourPolicyRepository extends JpaRepository<TourPolicy, Integer> {
}
