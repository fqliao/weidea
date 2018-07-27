package cn.webank.weidea.dao;



import org.springframework.data.jpa.repository.Query;

import cn.webank.weidea.entity.KeyManagement;

public interface KeyManagementRepository extends CrudRepository<KeyManagement, Integer>{
	@Query("from KeyManagement where idCard = ?")
	KeyManagement searchRecord(String idCard);
}
