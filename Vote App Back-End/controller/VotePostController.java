package com.codeacademy.voteapp.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codeacademy.voteapp.dto.UserVotesDto;
import com.codeacademy.voteapp.dto.VotePostDto;
import com.codeacademy.voteapp.service.VotePostService;

@CrossOrigin(origins = {"http://localhost:5500","http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/votepost")
public class VotePostController {

	@Autowired
	VotePostService votepostService;
	
	@GetMapping("/{id}")
	public VotePostDto findVotePostById(@PathVariable(name="id") Long id) {
		
		return votepostService.findVotePostById(id);
		
	}
	
	@GetMapping("")
	public List<VotePostDto> findAllVotePosts() {
		
		return votepostService.findAllVotePosts();
		
	}
	
	@PostMapping("")
	public VotePostDto createVotePost(@Valid @RequestBody VotePostDto votePostDto) throws Exception {
		
		return votepostService.createVotePost(votePostDto);
		
	}
	
	@PostMapping("/vote")
	public UserVotesDto voteVotePost(@Valid @RequestBody UserVotesDto userVotesDto) throws Exception {
		
		return votepostService.voteVotePost(userVotesDto);
		
	}
	
	@PostMapping("/archive")
	public List <VotePostDto> createVotePostArchive(){
		
		return votepostService.createVotePostArchive();
		
	}
	
	@PostMapping("/active")
	public List <VotePostDto> createVotePostActive(){
		
		return votepostService.createVotePostActive();
		
	}
	
	@PutMapping("/{id}")
	public VotePostDto updateVotePost(@Valid @RequestBody VotePostDto votePostDto, @PathVariable(name = "id") Long id) {
		
		return votepostService.updateVotePost(votePostDto);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteVotePost(@PathVariable(name = "id") Long id) {
		
		votepostService.deleteVotePost(id);
		
	}
	
}
