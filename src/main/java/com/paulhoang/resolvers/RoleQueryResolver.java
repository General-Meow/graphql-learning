package com.paulhoang.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.paulhoang.repository.PermissionRepository;
import com.paulhoang.repository.UserRepository;
import com.paulhoang.types.Permission;
import com.paulhoang.types.Role;
import com.paulhoang.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RoleQueryResolver implements GraphQLResolver<Role> {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PermissionRepository permissionRepository;

  public Set<User> users(Role role) {
    return userRepository.findByRoles(role);
  }

  public Set<Permission> permissions(Role role) {
    return permissionRepository.findByRoles(role);
  }
}
