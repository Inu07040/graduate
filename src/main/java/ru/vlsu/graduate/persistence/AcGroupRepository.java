package ru.vlsu.graduate.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcGroupRepository extends JpaRepository<AcGroup,Integer> {

}
