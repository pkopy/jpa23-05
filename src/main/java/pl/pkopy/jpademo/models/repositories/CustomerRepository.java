package pl.pkopy.jpademo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pkopy.jpademo.models.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity,Integer> {
}
