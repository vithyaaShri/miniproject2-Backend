package com.miniproject2.miniproject2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.miniproject2.miniproject2.entity.Role;

public interface RoleSecurityRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
