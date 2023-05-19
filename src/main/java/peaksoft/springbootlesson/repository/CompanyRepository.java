package peaksoft.springbootlesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springbootlesson.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

}
