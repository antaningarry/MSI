package com.composite.compositems.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import com.composite.compositems.entity.CustomerCartEmbeddable;
import com.composite.compositems.entity.CustomerCartEntity;

@RestController
public interface CustomerCartDatarepo extends JpaRepository<CustomerCartEntity,CustomerCartEmbeddable>{
	 
		@Query("SELECT CO FROM CustomerCartEntity CO WHERE CO.id.customerId = ?1")
		public List<CustomerCartEntity> findByCustomerId(Long id);


}
