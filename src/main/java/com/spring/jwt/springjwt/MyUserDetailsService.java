package com.spring.jwt.springjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.spring.jwt.springjwt.models.Employee;
import com.spring.jwt.springjwt.models.Role;
import com.spring.jwt.springjwt.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // return new User("2", "pass",
        //         new ArrayList<>());
        Optional<Employee> employee = employeeRepository.findById(s);
        if(employee == null){
            throw new UsernameNotFoundException("Invalid Employee ID or password");
        }
        return new org.springframework.security.core.userdetails.User(employee.get().getId(), employee.get().getPassword(), mapRolesToAuthorities(employee.get().getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    }
