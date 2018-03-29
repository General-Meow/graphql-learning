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
@Table(name = "USER")
public class User implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "EMAIL")
  private String email;

  @ManyToMany
  @JoinTable(name = "USER_ROLES",
      joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"))
  private Set<Role> roles;

  public User() {
  }

  public User(String name, String email, Set<Role> roles) {
    this(null, name, email, roles);
  }

  public User(Long id, String name, String email, Set<Role> roles) {
    this.id = id;
    this.name = name;
    this.email = email;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
