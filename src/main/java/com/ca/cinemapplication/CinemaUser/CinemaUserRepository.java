package com.ca.cinemapplication.CinemaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaUserRepository extends JpaRepository<CinemaUser, Long> {

    CinemaUser findTop1ByLoggedInIsTrue();

}
