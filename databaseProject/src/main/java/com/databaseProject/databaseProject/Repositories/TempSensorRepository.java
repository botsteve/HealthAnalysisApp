package com.databaseProject.databaseProject.Repositories;

import com.databaseProject.databaseProject.Model.TempSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempSensorRepository extends JpaRepository<TempSensor, Integer> {
}
