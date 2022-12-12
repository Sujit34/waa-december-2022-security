package edu.miu.springdata1Assignment.repository;

import edu.miu.springdata1Assignment.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends JpaRepository<ActivityLog, Integer> {
}

