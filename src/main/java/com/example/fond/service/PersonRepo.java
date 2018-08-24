package com.example.fond.service;

        import com.example.fond.domain.Person;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.Date;
        import java.util.List;

public interface PersonRepo extends JpaRepository <Person, Long> {
    List <Person> findByLastNameOrFirstName(String lastname, String firstname);

    List <Person> findBydateOfBirthBetween(Date start, Date between);
}
