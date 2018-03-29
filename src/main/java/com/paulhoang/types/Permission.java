package com.paulhoang.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PERMISSION")
public class Permission implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @ManyToMany(mappedBy = "permissions")
  private Set<Role> roles;

  public Permission() {
  }

  public Permission(String name, Set<Role> roles) {
    this(null, name, roles);
  }

  public Permission(Long id, String name, Set<Role> roles) {
    this.id = id;
    this.name = name;
    this.roles = roles;
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

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
