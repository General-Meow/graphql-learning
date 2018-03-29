package com.paulhoang.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.paulhoang.repository.RoleRepository;
import com.paulhoang.types.Role;
import com.paulhoang.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserQueryResolver implements GraphQLResolver<User> {

  @Autowired
  private RoleRepository roleRepository;

  public Set<Role> roles(User user) {
    return roleRepository.findByUsers(user);
  }
}
