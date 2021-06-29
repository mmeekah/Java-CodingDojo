package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepo;


@Service
public class SongService {
	private final SongRepo songRepo;
	
	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}
	
	//Methods
	public List<Song> all(){
		return songRepo.findAll();
	}
	
	public Song find(Long id) {
		Optional<Song> song = songRepo.findById(id);
		if(song.isPresent()) {
			return song.get();
		}else {
			return null;
		}
	}
	
	public Song create(Song song) {
		return songRepo.save(song);
	}
	
	public Song update(Song song) {
		Optional<Song> temp = songRepo.findById(song.getId());
		if(temp.isPresent()) {
			temp.get().setTitle(song.getTitle());
			temp.get().setArtist(song.getArtist());;
			temp.get().setRating(song.getRating());
			return songRepo.save(temp.get());
		} else {
			return null;
		}
	}
	
	public Song update(Long id, String title, String artist, int rating) {
		Optional<Song> temp = songRepo.findById(id);
		if (temp.isPresent()) {
			temp.get().setTitle(title);
			temp.get().setArtist(artist);
			temp.get().setRating(rating);
			return songRepo.save(temp.get());
		} else {
			return null;
		}
	}
	
	public void delete(Long id) {
		songRepo.deleteById(id);
	}
	
	public List<Song> findByArtist(String artist){
		List<Song> songs = songRepo.findByArtistLike(artist);
		if(songs.isEmpty()) {
			return null;
		} else {
			return songs;
		}
		
	}
	
	public List<Song> findTopFive(){
		return songRepo.findTop5ByOrderByRatingDesc();
	}

}
