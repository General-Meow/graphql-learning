package com.paulhoang.repository;

import com.paulhoang.types.Permission;
import com.paulhoang.types.Role;
import com.paulhoang.types.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Set<Role> findByUsers(User user);

  Set<Role> findByPermissions(Permission permission);
}
