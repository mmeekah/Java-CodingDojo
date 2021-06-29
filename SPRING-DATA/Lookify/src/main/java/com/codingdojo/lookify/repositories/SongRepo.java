package com.codingdojo.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {
	List <Song> findAll();
	List<Song> findByArtistLike(String artist);
	List<Song> findTop5ByOrderByRatingDesc();
	
}
