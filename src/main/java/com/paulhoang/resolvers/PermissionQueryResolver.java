package com.paulhoang.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.paulhoang.repository.RoleRepository;
import com.paulhoang.types.Permission;
import com.paulhoang.types.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PermissionQueryResolver implements GraphQLResolver<Permission> {

  @Autowired
  private RoleRepository roleRepository;

  public Set<Role> roles(Permission permission) {
    return roleRepository.findByPermissions(permission);
  }
}
