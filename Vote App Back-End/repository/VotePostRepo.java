package com.codeacademy.voteapp.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codeacademy.voteapp.entity.VotePost;

@Repository
public interface VotePostRepo extends CrudRepository<VotePost, Long> {

	List <VotePost> findAllByUser_IdAndEndDateGreaterThanEqual(Long id, Date endate);
	
	List <VotePost> findAllByEndDateLessThan(Date endate);
	
	List <VotePost> findAllByEndDateGreaterThanEqual(Date endate);
	
}
