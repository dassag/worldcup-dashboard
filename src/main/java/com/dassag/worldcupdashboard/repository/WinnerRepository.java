package com.dassag.worldcupdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dassag.worldcupdashboard.model.Winner;

@Repository
public interface WinnerRepository extends CrudRepository<Winner, Long> {

}
