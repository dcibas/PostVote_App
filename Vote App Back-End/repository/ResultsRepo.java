package com.codeacademy.voteapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codeacademy.voteapp.entity.Results;

@Repository
public interface ResultsRepo extends CrudRepository<Results, Long> {

	List<Results> findAllByVotepost_Id(Long id);
	
}
