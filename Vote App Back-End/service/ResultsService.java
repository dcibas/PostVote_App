package com.codeacademy.voteapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeacademy.voteapp.dto.ResultsDto;
import com.codeacademy.voteapp.entity.Results;
import com.codeacademy.voteapp.entity.UserVotes;
import com.codeacademy.voteapp.entity.VotePost;
import com.codeacademy.voteapp.enu.VotingChoices;
import com.codeacademy.voteapp.mapper.ResultsMapper;
import com.codeacademy.voteapp.mapper.UserVotesMapper;
import com.codeacademy.voteapp.repository.ResultsRepo;
import com.codeacademy.voteapp.repository.UserVotesRepo;
import com.codeacademy.voteapp.repository.VotePostRepo;

@Service
public class ResultsService {

	@Autowired
	VotePostRepo votePostRepo;
	
	@Autowired
	UserVotesRepo userVotesRepo;
	
	@Autowired
	ResultsRepo resultsRepo;
	
	@Autowired
	ResultsMapper resultsMapper;
	
	@Autowired
	UserVotesMapper userVotesMapper;
	
	
	public ResultsDto findById(Long id) {
		
		Results result = resultsRepo.findById(id).orElse(null);
		
		ResultsDto resultsDto = resultsMapper.toDto(result);
		
		return resultsDto;
		
	}
	
	public List<ResultsDto> findAllResults() {
		
		List<Results> result = (ArrayList<Results>) resultsRepo.findAll();
		
		return resultsMapper.toDtoList(result);
		
	}
	
	public ResultsDto createResult(Long votePostId) throws Exception {
		
		Optional<VotePost> votePost = votePostRepo.findById(votePostId);

		if(votePost.get().getResult() != null) {
			
			throw new Exception("You have already posted a result!");
			
		}
						
		List<UserVotes> userVotes = userVotesRepo.findAllByVotePost_Id(votePostId);
		
		List<UserVotes> completelyAgainst = userVotes.stream().filter(userVote -> userVote.getVotingChoice() == VotingChoices.Completely_Against).collect(Collectors.toList());

		List<UserVotes> partiallyAgainst = userVotes.stream().filter(userVote -> userVote.getVotingChoice() == VotingChoices.Partially_Against).collect(Collectors.toList());

		List<UserVotes> partiallyAgree = userVotes.stream().filter(userVote -> userVote.getVotingChoice() == VotingChoices.Partially_Agree).collect(Collectors.toList());

		List<UserVotes> completelyAgree = userVotes.stream().filter(userVote -> userVote.getVotingChoice() == VotingChoices.Completely_Agree).collect(Collectors.toList());
		
		Results result = new Results();
		
		result.setVotepost(votePost.get());
		result.setVotingPoints1(completelyAgainst.size());
		result.setVotingPoints2(partiallyAgainst.size());
		result.setVotingPoints3(partiallyAgree.size());
		result.setVotingPoints4(completelyAgree.size());
		
		resultsRepo.save(result);
		
		votePost.get().setResult(result);
		
		votePostRepo.save(votePost.get());
		
		return resultsMapper.toDto(result);
		
	}
	
	public ResultsDto updateResult(ResultsDto resultsDto) {
		
		Results result = resultsMapper.fromDto(resultsDto);
		
		resultsRepo.save(result);
		
		return resultsMapper.toDto(result);
		
	}
	
	public void deleteResult(Long id) {
		
		resultsRepo.deleteById(id);
		
	}
	
}
