package com.lcroffi.springbootmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lcroffi.springbootmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	List<Post> findByTitleContainingIgnoreCase(String text); // função query method com palavras-chave do Spring com Mongo
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

}
