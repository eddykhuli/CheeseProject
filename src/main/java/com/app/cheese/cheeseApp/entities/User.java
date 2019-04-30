/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.cheese.cheeseApp.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Data
@Table(name ="users")
public class User implements UserDetails, Serializable {//class implements spring-security UserDetails thats would else be created separately the implemented here but, i just implemented it directly here and overidden its methods
    
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email", nullable = false, unique = true)
//    @Email(message = "Please provide a valid e-mail")
//    @NotEmpty(message = "Please provide an e-mail")
    private String email;
    @Column
    private String password;
    @Column
    private String username;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column 
    private String cell_no;
     @Column 
    private String gender;
      @Column 
    private String birth_date;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Role role;
    private boolean enabled;
    @Column(name="token")
    private String confirmationToken;
     
    public User() {
        super();
        this.enabled=false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(role);
    }

  @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
