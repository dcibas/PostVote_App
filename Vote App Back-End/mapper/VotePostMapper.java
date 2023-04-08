package com.codeacademy.voteapp.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.codeacademy.voteapp.dto.VotePostDto;
import com.codeacademy.voteapp.entity.User;
import com.codeacademy.voteapp.entity.VotePost;

@Service
public class VotePostMapper {

	public VotePostDto toDto(VotePost entity) {
		if(entity == null) {
			return null;
		}
	
		VotePostDto dto = new VotePostDto();
		dto.setId(entity.getId());
		dto.setVotingTitle(entity.getVotingTitle());
		dto.setVotingDescription(entity.getVotingDescription());
		dto.setDate(entity.getDate());
		dto.setUserId(entity.getUser().getId());
		dto.setEndDate(entity.getEndDate());
		
		return dto;
	
}

	public VotePost fromDto(VotePostDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		VotePost entity = new VotePost();
		entity.setId(dto.getId());
		entity.setVotingTitle(dto.getVotingTitle());
		entity.setVotingDescription(dto.getVotingDescription());
		entity.setDate(dto.getDate());
		entity.setEndDate(dto.getEndDate());
		
		User user = new User();
		user.setId(dto.getUserId());
		entity.setUser(user);
		
		return entity;
		
	}
	
	public List<VotePostDto> toDtoList(List<VotePost> entities) {
		
		List<VotePostDto> dtos = new ArrayList<>();
		
		for(VotePost entity : entities) {
			dtos.add(toDto(entity));
		}
		
		return dtos;
					
	}		
	
}
