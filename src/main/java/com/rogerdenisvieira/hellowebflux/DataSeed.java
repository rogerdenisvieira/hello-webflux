package com.rogerdenisvieira.hellowebflux;

import com.rogerdenisvieira.hellowebflux.document.Playlist;
import com.rogerdenisvieira.hellowebflux.repository.PlaylistRepository;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;

import java.util.UUID;

public class DataSeed implements CommandLineRunner {

    private final PlaylistRepository playlistRepository;

    public DataSeed(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        this.playlistRepository
                .deleteAll()
                .thenMany(
                        Flux.just("My First Playlist", "A Cool Playlist", "Another Playlist", "Annoying Playlist")
                                .map(name -> new Playlist(UUID.randomUUID().toString(), name))
                                .flatMap(playlistRepository::save))
                .subscribe(System.out::println);
    }
}
