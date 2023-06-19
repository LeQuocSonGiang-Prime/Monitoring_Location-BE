package com.example.MonitoringLocation.repositories;

import com.example.MonitoringLocation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM persons p  WHERE p.id_user = :userId", nativeQuery = true)
    List<Person> findAllByUser(Long userId);

    Person findByToken(String token);


    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = "INSERT INTO persons (id_user, name, token, avatar) VALUES (:userId, :name, :token, :avatar)", nativeQuery = true)
    void insert(@Param("userId") Long userId, @Param("name") String name, @Param("token") String token, @Param("avatar") String avatar);
}
