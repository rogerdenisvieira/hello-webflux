package com.rogerdenisvieira.hellowebflux.repository;

import com.rogerdenisvieira.hellowebflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
