
package com.Verduleria.dao;

import com.Verduleria.Domain.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Long> {
    
    @Query(value="SELECT u FROM Empleado WHERE u.email = ?1", nativeQuery=true)
    User findByEmail(String email);
}
