package ru.vlsu.graduate.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraduateRepository extends JpaRepository<Graduate, Integer> {

    List<Graduate> findByGroupId(Integer groupId);
}
