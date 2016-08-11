package com.custanalytics.demo.clinicalmanager.dao;

import com.custanalytics.demo.clinicalmanager.entity.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dm on 7/25/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {

    List<AppUser>findUsersByLastName(String lastName);

    @Query(value = "SELECT a FROM AppUser a WHERE a.userName = :username and a.password =:password ")
    AppUser login(@Param("username")String userId, @Param("password")String password);

}
