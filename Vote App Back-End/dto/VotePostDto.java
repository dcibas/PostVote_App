package com.codeacademy.voteapp.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotePostDto {

	private Long id;
	
	@NotBlank(message = "Voting title cannot be blank")
	private String votingTitle;
	
	@NotBlank(message = "Voting description cannot be blank")
	private String votingDescription;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	private Long userId;
	
	private Long resultsId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVotingTitle() {
		return votingTitle;
	}

	public void setVotingTitle(String votingTitle) {
		this.votingTitle = votingTitle;
	}

	public String getVotingDescription() {
		return votingDescription;
	}

	public void setVotingDescription(String votingDescription) {
		this.votingDescription = votingDescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getResultsId() {
		return resultsId;
	}

	public void setResultsId(Long resultsId) {
		this.resultsId = resultsId;
	}
	
}
