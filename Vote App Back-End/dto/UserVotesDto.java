package com.codeacademy.voteapp.dto;

import com.codeacademy.voteapp.enu.VotingChoices;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVotesDto {

	private Long id;
	
	private Long userId;
	
	private Long votePostId;
	
	private VotingChoices votingChoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getVotePostId() {
		return votePostId;
	}

	public void setVotePostId(Long votePostId) {
		this.votePostId = votePostId;
	}

	public VotingChoices getVotingChoice() {
		return votingChoice;
	}

	public void setVotingChoice(VotingChoices votingChoice) {
		this.votingChoice = votingChoice;
	}
	
}
