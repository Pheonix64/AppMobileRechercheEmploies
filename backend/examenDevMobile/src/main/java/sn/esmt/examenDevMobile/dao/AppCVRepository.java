package sn.esmt.examenDevMobile.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.examenDevMobile.entities.AppCVEntity;

@Repository
public interface AppCVRepository extends JpaRepository<AppCVEntity, Integer> {
    AppCVEntity findById(int id);

}
