package com.jadm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jadm.model.BbookEnvioTda;

@Repository
public interface BbookEnvioTdaRepository extends CrudRepository<BbookEnvioTda, String> {

	public List<BbookEnvioTda> findAllByTranType(String tranType);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update app_sam.sdi_sdiorgmst s set s.download_date_1 = sysdate where rowid = :id", nativeQuery = true)
    public void uopdSdiSdiOrgmst(@Param("id") String id);
	
}
