package com.paulhoang.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.paulhoang.repository.PermissionRepository;
import com.paulhoang.repository.RoleRepository;
import com.paulhoang.repository.UserRepository;
import com.paulhoang.types.Permission;
import com.paulhoang.types.Role;
import com.paulhoang.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PermissionRepository permissionRepository;

  public User user(Long id) {
    return userRepository.findOne(id);
  }

  public List<User> allUsers() {
    return userRepository.findAll();
  }

  public Role role(Long id) {
    return roleRepository.findOne(id);
  }

  public List<Role> allRoles() {
    return roleRepository.findAll();
  }

  public Permission permission(Long id) {
    return permissionRepository.findOne(id);
  }

  public List<Permission> allPermissions() {
    return permissionRepository.findAll();
  }
}
