package com.codeacademy.voteapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "results")
public class Results {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "voting_points1")
	private Integer votingPoints1;
	
	@Column(name = "voting_points2")
	private Integer votingPoints2;
	
	@Column(name = "voting_points3")
	private Integer votingPoints3;
	
	@Column(name = "voting_points4")
	private Integer votingPoints4;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "result")
	private VotePost votepost;

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

	public VotePost getVotepost() {
		return votepost;
	}

	public void setVotepost(VotePost votepost) {
		this.votepost = votepost;
	}
	
}
