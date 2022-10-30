package book_app.repository;

import book_app.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    @Transactional
    @Modifying
    @Query(value="UPDATE book b SET b.quantity = ? WHERE b.id = ?",nativeQuery = true)
    int update(Integer quantity, Long id);
}
