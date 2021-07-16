package io.github.wesleyosantos91.repository;

import io.github.wesleyosantos91.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
