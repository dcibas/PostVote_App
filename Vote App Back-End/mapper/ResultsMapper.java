package com.codeacademy.voteapp.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.codeacademy.voteapp.dto.ResultsDto;
import com.codeacademy.voteapp.entity.Results;

@Service
public class ResultsMapper {
	
	public ResultsDto toDto(Results entity) {
		if(entity == null) {
			return null;
		}
	
		ResultsDto dto = new ResultsDto();
		dto.setId(entity.getId());
		dto.setVotingPoints1(entity.getVotingPoints1());
		dto.setVotingPoints2(entity.getVotingPoints2());
		dto.setVotingPoints3(entity.getVotingPoints3());
		dto.setVotingPoints4(entity.getVotingPoints4());
		
		return dto;
	
}

	public Results fromDto(ResultsDto dto) {
		
		if(dto == null) {
			return null;
		}
		
		Results entity = new Results();
		entity.setId(dto.getId());
		entity.setVotingPoints1(dto.getVotingPoints1());
		entity.setVotingPoints2(dto.getVotingPoints2());
		entity.setVotingPoints3(dto.getVotingPoints3());
		entity.setVotingPoints4(dto.getVotingPoints4());
		
		return entity;
		
	}
	
	public List<ResultsDto> toDtoList(List<Results> entities) {
		
		List<ResultsDto> dtos = new ArrayList<>();
		
		for(Results entity : entities) {
			dtos.add(toDto(entity));
		}
		
		return dtos;
					
	}	
	
}
