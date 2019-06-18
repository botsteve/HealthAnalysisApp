package com.databaseProject.databaseProject.Repositories;

import com.databaseProject.databaseProject.Model.EKG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EKGRepository extends JpaRepository<EKG, Integer> {
}
