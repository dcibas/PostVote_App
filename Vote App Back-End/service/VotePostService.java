package com.codeacademy.voteapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codeacademy.voteapp.dto.UserVotesDto;
import com.codeacademy.voteapp.dto.VotePostDto;
import com.codeacademy.voteapp.entity.UserVotes;
import com.codeacademy.voteapp.entity.VotePost;
import com.codeacademy.voteapp.mapper.UserVotesMapper;
import com.codeacademy.voteapp.mapper.VotePostMapper;
import com.codeacademy.voteapp.repository.UserVotesRepo;
import com.codeacademy.voteapp.repository.VotePostRepo;

@Service
public class VotePostService {
	
	@Autowired
	UserVotesRepo userVotesRepo;
	
	@Autowired
	VotePostRepo votepostRepo;
	
	@Autowired
	VotePostMapper votepostMapper;
	
	@Autowired
	UserVotesMapper userVotesMapper;

	public VotePostDto findVotePostById(Long id) {
		
		VotePost votePost = votepostRepo.findById(id).orElse(null);
		
		VotePostDto votePostDto = votepostMapper.toDto(votePost);
		
		return votePostDto;
		
	}
	
	public List<VotePostDto> findAllVotePosts() {
		
		List<VotePost> votePost = (ArrayList<VotePost>) votepostRepo.findAll();
		
		return votepostMapper.toDtoList(votePost);
		
	}
	
	public VotePostDto createVotePost(VotePostDto votePostDto) throws Exception {
		
		VotePost votePost = votepostMapper.fromDto(votePostDto);
		
		votePost.setDate(new Date());
		
		if(votepostRepo.findAllByUser_IdAndEndDateGreaterThanEqual(votePostDto.getUserId(), new Date()).size() != 0) {
		
		throw new Exception("A vote post already exists!");
		
		}
		
		votepostRepo.save(votePost);
		
		return votepostMapper.toDto(votePost);
		
	}
	
	public List<VotePostDto> createVotePostArchive() {
		
		
		List<VotePost> votePostArchive = votepostRepo.findAllByEndDateLessThan(new Date());
		
		List<VotePostDto> votePostArchiveDto = votepostMapper.toDtoList(votePostArchive);
		
		return votePostArchiveDto;
		
	}
	
	public List<VotePostDto> createVotePostActive() {
		
		List<VotePost> votePostActive = votepostRepo.findAllByEndDateGreaterThanEqual(new Date());
		
		List<VotePostDto> votePostActiveDto = votepostMapper.toDtoList(votePostActive);
		
		return votePostActiveDto;
	}
	
	public UserVotesDto voteVotePost(UserVotesDto userVotesDto) throws Exception {
		
		UserVotes userVote = userVotesMapper.fromDto(userVotesDto);
		
		List<UserVotes> userVotes = userVotesRepo.findAllByVotePost_Id(userVotesDto.getVotePostId());
		
		List<Long> userIds = userVotes.stream().map(usersVote -> usersVote.getUser().getId()).collect(Collectors.toList());
		
		if(userIds.contains(userVotesDto.getUserId())) {
			
			throw new Exception("You have already voted on this votepost!");
			
	}
		
		userVotesRepo.save(userVote);
		
		return userVotesMapper.toDto(userVote);
		
	}
	
	public VotePostDto updateVotePost(VotePostDto votePostDto) {
		
		VotePost votePost = votepostMapper.fromDto(votePostDto);
		
		votePost.setDate(new Date());
		
		votepostRepo.save(votePost);
		
		return votepostMapper.toDto(votePost);
		
	}
	
	public void deleteVotePost(Long id) {
		
		votepostRepo.deleteById(id);
		
	}
	
}
