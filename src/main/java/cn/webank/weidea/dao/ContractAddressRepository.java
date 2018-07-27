package cn.webank.weidea.dao;

import org.springframework.data.jpa.repository.Query;

import cn.webank.weidea.entity.ContractAddress;

public interface ContractAddressRepository extends CrudRepository<ContractAddress, Integer> {

	@Query("select address FROM ContractAddress where category = ?")
	public String findAddressByCategory(String category);
}
