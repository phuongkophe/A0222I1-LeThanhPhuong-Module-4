package son.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import son.codegym.entity.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, String> {
     Page<Customer> findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeIdOrderByCustomerEmail(String name, String email, int customerTypeId, Pageable pageable);
     Page<Customer> findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeNameContainingOrderByCustomerEmail(String name, String email, String customerTypeId, Pageable pageable);

     //     @Query(value = "select * from question where title like %?1% and id_question_type =?2", nativeQuery = true)
//     List<Question> searchBy(String search, String type);
//     @Query(value="select * from c customer c where c.customerName like %?1% and c.customerEmail like %?2% and customer_type_id =?3", nativeQuery = true)
//     Page<Customer> search(String name, String email, int customer_type_id, Pageable pageable);
//     Page<Customer> findAllByCustomerTypeId_CustomerNameContains(String name);


//     @Query("select c from Customer as c where c.customerName like %?1% and c.customerAddress like %?2% and c.customerEmail like %?3%")
//     Page<Customer> search(String name,String address, String email, Pageable pageable);
}
