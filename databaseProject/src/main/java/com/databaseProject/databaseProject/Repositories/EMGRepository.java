package com.databaseProject.databaseProject.Repositories;

import com.databaseProject.databaseProject.Model.EMG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EMGRepository extends JpaRepository<EMG, Integer> {
}
