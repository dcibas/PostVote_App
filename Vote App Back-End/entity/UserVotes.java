package com.codeacademy.voteapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.codeacademy.voteapp.enu.VotingChoices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_votes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVotes {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "vote_post_id")
	private VotePost votePost;
	
	@Enumerated(EnumType.STRING)
	private VotingChoices votingChoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VotePost getVotePost() {
		return votePost;
	}

	public void setVotePost(VotePost votePost) {
		this.votePost = votePost;
	}

	public VotingChoices getVotingChoice() {
		return votingChoice;
	}

	public void setVotingChoice(VotingChoices votingChoice) {
		this.votingChoice = votingChoice;
	}
	
}
