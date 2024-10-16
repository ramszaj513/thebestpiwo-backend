package com.projects.thebestpiwobackend.piwa;

public record PiwoIdPair(int id, int id2) {
    public PiwoIdPair(int id, int id2) {
        if(id == id2){
            throw new RuntimeException("Ids should be different");
        }
        if(id < 1 || id > 50 || id2 < 1 || id2 > 50) {
            throw new RuntimeException("Invalid piwo id. Should be only between 1-50.");
        }
        this.id = id;
        this.id2 = id2;
    }
}
