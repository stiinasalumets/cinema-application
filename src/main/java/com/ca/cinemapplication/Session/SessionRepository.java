package com.ca.cinemapplication.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findAllByMovieIdEqualsAndStartTimeAfter(Long movieId, Date date);
    List<Session> findByStartTimeAfter(Date date);

}
