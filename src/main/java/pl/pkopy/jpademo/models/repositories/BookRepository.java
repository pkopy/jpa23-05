package pl.pkopy.jpademo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pkopy.jpademo.models.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
}
