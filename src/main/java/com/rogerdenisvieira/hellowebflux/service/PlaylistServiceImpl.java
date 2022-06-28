package com.rogerdenisvieira.hellowebflux.service;

import com.rogerdenisvieira.hellowebflux.document.Playlist;
import com.rogerdenisvieira.hellowebflux.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    private PlaylistRepository repository;


    @Autowired
    public PlaylistServiceImpl(PlaylistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Playlist> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return  this.repository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return this.repository.save(playlist);
    }
}
