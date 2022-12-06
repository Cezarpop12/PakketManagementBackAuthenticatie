package com.Authenticatie.repository;

import com.Authenticatie.model.Postzegel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostzegelRepository extends JpaRepository<Postzegel, Integer> {

}
