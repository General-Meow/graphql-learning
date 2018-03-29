package com.paulhoang.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.google.common.collect.Sets;
import com.paulhoang.repository.PermissionRepository;
import com.paulhoang.repository.RoleRepository;
import com.paulhoang.repository.UserRepository;
import com.paulhoang.types.Permission;
import com.paulhoang.types.User;
import com.paulhoang.types.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Mutation implements GraphQLMutationResolver {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PermissionRepository permissionRepository;

  public User createUser(String name, String email, Set<Long> roleIds) {
    Set<Role> roles = Sets.newHashSet();
    if(!CollectionUtils.isEmpty(roleIds)) {
      roles = Sets.newHashSet(roleRepository.findAll(roleIds));
    }
    User newUser = new User(name, email, roles);
    return userRepository.saveAndFlush(newUser);
  }

  public Role createRole(String name, Set<Long> userIds, Set<Long> permissionIds) {
    Set<User> users = Sets.newHashSet();
    if(!CollectionUtils.isEmpty(userIds)){
      users = Sets.newHashSet(userRepository.findAll(userIds));
    }
    Set<Permission> permissions = Sets.newHashSet();
    if(!CollectionUtils.isEmpty(permissionIds)){
      permissions = Sets.newHashSet(permissionRepository.findAll(permissionIds));
    }
    Role newRole = new Role(name, users, permissions);
    return roleRepository.saveAndFlush(newRole);
  }
}
