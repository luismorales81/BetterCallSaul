package edu.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.it.dtos.Ticket;

@Repository
public interface GrabadorMultaRepository extends JpaRepository<Ticket, String> {

}
