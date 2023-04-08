package com.codeacademy.voteapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultsDto {
	
	private Long id;
	
	private Integer votingPoints1;
	
	private Integer votingPoints2;
	
	private Integer votingPoints3;

	private Integer votingPoints4;
	
	private VotePostDto votePostDto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVotingPoints1() {
		return votingPoints1;
	}

	public void setVotingPoints1(Integer votingPoints1) {
		this.votingPoints1 = votingPoints1;
	}

	public Integer getVotingPoints2() {
		return votingPoints2;
	}

	public void setVotingPoints2(Integer votingPoints2) {
		this.votingPoints2 = votingPoints2;
	}

	public Integer getVotingPoints3() {
		return votingPoints3;
	}

	public void setVotingPoints3(Integer votingPoints3) {
		this.votingPoints3 = votingPoints3;
	}

	public Integer getVotingPoints4() {
		return votingPoints4;
	}

	public void setVotingPoints4(Integer votingPoints4) {
		this.votingPoints4 = votingPoints4;
	}

	public VotePostDto getVotePostDto() {
		return votePostDto;
	}

	public void setVotePostDto(VotePostDto votePostDto) {
		this.votePostDto = votePostDto;
	}
	
}
