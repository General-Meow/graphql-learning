package com.paulhoang.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  @ManyToMany
  @JoinTable(
      name = "ROLE_PERMISSIONS",
      joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "id")
  )
  private Set<Permission> permissions;

  public Role() {
  }

  public Role(String name, Set<User> users, Set<Permission> permissions) {
    this(null, name, users, permissions);
  }

  public Role(Long id, String name, Set<User> users, Set<Permission> permissions) {
    this.id = id;
    this.name = name;
    this.users = users;
    this.permissions = permissions;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(Set<Permission> permissions) {
    this.permissions = permissions;
  }
}
