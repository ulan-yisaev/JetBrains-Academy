package engine.repository;

import engine.entity.Completion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompletionRepository extends JpaRepository<Completion, Long> {

//    @Query(value = "SELECT c.* from COMPLETION c, USER u WHERE u.EMAIL = :email and c.USER_ID = u. ID",
//            nativeQuery = true)
//    @Query("select c from Completion c where c.user.email = :email")
    @Query("SELECT c FROM Completion c where c.user.email = :email order by c.completedAt desc")
    Page<Completion> getCompletionsByUser(@Param("email") String email, Pageable pageable);
}