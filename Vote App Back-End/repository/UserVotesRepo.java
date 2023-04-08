package com.codeacademy.voteapp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codeacademy.voteapp.entity.UserVotes;

@Repository
public interface UserVotesRepo extends CrudRepository<UserVotes, Long> {

	List<UserVotes> findAllByVotePost_Id(Long id);
	
}