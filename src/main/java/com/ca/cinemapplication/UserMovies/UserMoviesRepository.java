package com.ca.cinemapplication.UserMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMoviesRepository extends JpaRepository<UserMovies, Long> {

    List<UserMovies> findAllByUserIdEquals(Long id);

}
