package com.example.multithreading;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Song {
    private String artist_name;

    public String getArtist_name() {
        return artist_name;
    }

    @Override
    public String toString() {
        return "Song [artist_name = " + artist_name + "]";
    }
}