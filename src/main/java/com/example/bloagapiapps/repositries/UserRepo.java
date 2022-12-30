package com.example.bloagapiapps.repositries;

import com.example.bloagapiapps.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
