package com.paulhoang.repository;

import com.paulhoang.types.Role;
import com.paulhoang.types.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Set<User> findByRoles(Role role);
}
