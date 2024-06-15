package com.hutech.demo.demo.repository;

import com.hutech.demo.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findRoleById(Long id);
}