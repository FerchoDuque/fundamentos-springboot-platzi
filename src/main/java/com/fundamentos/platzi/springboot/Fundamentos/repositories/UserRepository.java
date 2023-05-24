package com.fundamentos.platzi.springboot.Fundamentos.repositories;

import com.fundamentos.platzi.springboot.Fundamentos.dto.UserDTO;
import com.fundamentos.platzi.springboot.Fundamentos.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);
    @Query("SELECT u from User u WHERE u.name like ?1% ")
    List<User> findAndSort(String name, Sort sort);
    List<User> findByName(String name);
    Optional<User> findByNameAndEmail(String name, String email);
    List<User> findByNameLike(String name);
    List<User> findByNameOrEmail(String name, String email);
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
    List<User> findByNameOrderByIdDesc(String Name);
    List<User> findByNameLikeOrderByIdDesc(String Name);
    List<User> findByNameContainingOrderByIdDesc(String Name);
    @Query("SELECT new com.fundamentos.platzi.springboot.Fundamentos.dto.UserDTO(u.id, u.name, u.email, u.birthDate)" +
        " from User u " +
            " WHERE u.birthDate=:parametroFecha " +
            " and u.email=:parametroEmail"
    )
    Optional<UserDTO> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date, @Param("parametroEmail") String email);

 }
