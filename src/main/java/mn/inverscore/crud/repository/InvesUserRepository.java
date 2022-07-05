package mn.inverscore.crud.repository;

import mn.inverscore.crud.entity.InvesUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvesUserRepository extends JpaRepository<InvesUserEntity, Long> {

}
