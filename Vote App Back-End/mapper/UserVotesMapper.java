package com.codeacademy.voteapp.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.codeacademy.voteapp.dto.UserVotesDto;
import com.codeacademy.voteapp.entity.User;
import com.codeacademy.voteapp.entity.UserVotes;
import com.codeacademy.voteapp.entity.VotePost;


@Service
public class UserVotesMapper {

	public UserVotesDto toDto(UserVotes entity) {
		if(entity == null) {
			return null;
		}
	
		UserVotesDto dto = new UserVotesDto();
		dto.setId(entity.getId());
		dto.setVotingChoice(entity.getVotingChoice());
		dto.setUserId(entity.getUser().getId());
		dto.setVotePostId(entity.getVotePost().getId());
		
		return dto;
	
}

	public UserVotes fromDto(UserVotesDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		UserVotes entity = new UserVotes();
		
		entity.setId(dto.getId());
		entity.setVotingChoice(dto.getVotingChoice());
		
		User user = new User();
		user.setId(dto.getUserId());
		entity.setUser(user);
		VotePost votePost = new VotePost();
		votePost.setId(dto.getVotePostId());
		entity.setVotePost(votePost);	
		
		return entity;
		
	}
	
	public List<UserVotesDto> toDtoList(List<UserVotes> entities) {
		
		List<UserVotesDto> dtos = new ArrayList<>();
		
		for(UserVotes entity : entities) {
			dtos.add(toDto(entity));
		}
		
		return dtos;
					
	}	
	
}
