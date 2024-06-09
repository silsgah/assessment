package com.silasgah.NBAService.repository;

import com.silasgah.NBAService.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<Statistic, Long> {
}
