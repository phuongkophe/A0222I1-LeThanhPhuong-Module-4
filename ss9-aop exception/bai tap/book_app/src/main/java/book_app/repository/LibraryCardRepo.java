package book_app.repository;

import book_app.entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepo extends JpaRepository<LibraryCard,Long> {
    LibraryCard findByLibraryCardCodeContaining(String libCardCode);
}
