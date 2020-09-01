package com.probation.sandbox.repositories;

import com.probation.sandbox.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository <Parent,Long>{
    Optional<Parent> findParentByEmail (String email);
}
