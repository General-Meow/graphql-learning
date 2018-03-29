package com.paulhoang.repository;

import com.paulhoang.types.Permission;
import com.paulhoang.types.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

  Set<Permission> findByRoles(Role role);
}
