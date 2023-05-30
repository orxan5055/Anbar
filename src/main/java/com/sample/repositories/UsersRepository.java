package com.sample.repositories;

import com.sample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    @Query( value = "Select * from users u where u.username = :username ",
            nativeQuery = true)
    Users findByUsername(String username);
}
