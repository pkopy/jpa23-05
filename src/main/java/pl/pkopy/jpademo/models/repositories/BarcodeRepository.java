package pl.pkopy.jpademo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pkopy.jpademo.models.BarcodeEntity;

import java.util.List;


@Repository
public interface BarcodeRepository extends CrudRepository<BarcodeEntity, Integer> {
//    BarcodeEntity findById(int id);
    List<BarcodeEntity> findAllByBarcodeContainsAndBarcodeContainsAndWeightGreaterThan(String s, String s1, int o);
    List<BarcodeEntity> findAllByWeightLessThanAndWeightGreaterThan(int o, int o1);
    List<BarcodeEntity> findAllByProductCompanyContains(String text);
    List<BarcodeEntity> findAllByProductNameContains(String text);



}
