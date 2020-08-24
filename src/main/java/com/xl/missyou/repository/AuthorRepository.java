package com.xl.missyou.repository;

import com.xl.missyou.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findOneById(Long id);
}
