package com.agonyengine.repository;

import com.agonyengine.model.actor.Actor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ActorRepository extends JpaRepository<Actor, UUID> {
    Actor findByConnectionSessionUsernameAndConnectionSessionId(String sessionUsername, String sessionId);
    List<Actor> findByRoomId(UUID roomId);
    List<Actor> findByConnectionIsNotNullAndRoomIdIsNotNull(Sort sort);
    List<Actor> findByConnectionDisconnectedDateIsBeforeAndRoomIdIsNotNull(Date cutoff);
    List<Actor> findByConnectionAccount(String account);
}
