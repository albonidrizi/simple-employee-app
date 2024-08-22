package org.sty.springboot_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sty.springboot_be.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
