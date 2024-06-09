package com.silasgah.nbadatainjectionservice.repository;

import com.silasgah.nbadatainjectionservice.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<Statistic, Long> {
}
