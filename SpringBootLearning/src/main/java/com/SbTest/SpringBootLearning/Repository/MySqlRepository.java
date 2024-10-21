package com.SbTest.SpringBootLearning.Repository;

import com.SbTest.SpringBootLearning.Entity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<Addresses, Integer> {
}
