package com.rogerdenisvieira.hellowebflux.handler;

import com.rogerdenisvieira.hellowebflux.document.Playlist;
import com.rogerdenisvieira.hellowebflux.service.PlaylistService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PlaylistHandler {

    private final PlaylistService playlistService;

    public PlaylistHandler(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    public Mono<ServerResponse> findAll(ServerRequest request){

            return ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(this.playlistService.findAll(), Playlist.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){

        String id = request.pathVariable("id");

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.playlistService.findById(id), Playlist.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){

        final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(playlist.flatMap(this.playlistService::save), Playlist.class));
    }
}
