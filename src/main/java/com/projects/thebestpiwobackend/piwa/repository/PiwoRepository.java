package com.projects.thebestpiwobackend.piwa.repository;

import com.projects.thebestpiwobackend.piwa.repository.entities.PiwoEntity;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PiwoRepository {
    private final Map<Integer, PiwoEntity> db = new ConcurrentHashMap<>();

    public PiwoRepository() {
        initialise();
    }

    public Optional<PiwoEntity> getById(int id) {
        return Optional.ofNullable(db.get(id));
    }

    public List<PiwoEntity> getAllSortedByRating() {
        return db.values().stream()
                .sorted((p1,p2) -> p2.getRating() - p1.getRating())
                .toList();
    }

    private void initialise() {
        db.put(1, new PiwoEntity(1, "Żywiec", 1000));
        db.put(2, new PiwoEntity(2, "Tyskie", 1000));
        db.put(3, new PiwoEntity(3, "Lech", 1000));
        db.put(4, new PiwoEntity(4, "Okocim", 1000));
        db.put(5, new PiwoEntity(5, "Warka", 1000));
        db.put(6, new PiwoEntity(6, "Książęce Ciemne Łagodne", 1000));
        db.put(7, new PiwoEntity(7, "Książęce Złote Pszeniczne", 1000));
        db.put(8, new PiwoEntity(8, "Perła Export", 1000));
        db.put(9, new PiwoEntity(9, "Perła Miodowa", 1000));
        db.put(10, new PiwoEntity(10, "Perła Chmielowa", 1000));
        db.put(11, new PiwoEntity(11, "Łomża Jasne", 1000));
        db.put(12, new PiwoEntity(12, "Łomża Miodowe", 1000));
        db.put(13, new PiwoEntity(13, "Namysłów Pils", 1000));
        db.put(14, new PiwoEntity(14, "Kasztelan", 1000));
        db.put(15, new PiwoEntity(15, "Żubr", 1000));
        db.put(16, new PiwoEntity(16, "Harnaś", 1000));
        db.put(17, new PiwoEntity(17, "Specjal Jasny Pełny", 1000));
        db.put(18, new PiwoEntity(18, "Bosman Full", 1000));
        db.put(19, new PiwoEntity(19, "Królewskie Jasne", 1000));
        db.put(20, new PiwoEntity(20, "Desperados Original", 1000));
        db.put(21, new PiwoEntity(21, "Desperados Red", 1000));
        db.put(22, new PiwoEntity(22, "Desperados Mojito", 1000));
        db.put(23, new PiwoEntity(23, "Desperados Lime", 1000));
        db.put(24, new PiwoEntity(24, "Heineken", 1000));
        db.put(25, new PiwoEntity(25, "Corona Extra", 1000));
        db.put(26, new PiwoEntity(26, "Carlsberg Pilsner", 1000));
        db.put(27, new PiwoEntity(27, "Carlsberg Export", 1000));
        db.put(28, new PiwoEntity(28, "Carlsberg Elephant", 1000));
        db.put(29, new PiwoEntity(29, "Lech Free", 1000));
        db.put(30, new PiwoEntity(30, "Lech Shandy", 1000));
        db.put(31, new PiwoEntity(31, "Fortuna Czarne", 1000));
        db.put(32, new PiwoEntity(32, "Fortuna Miodowe", 1000));
        db.put(33, new PiwoEntity(33, "Ciechan Wyborne", 1000));
        db.put(34, new PiwoEntity(34, "Ciechan Miodowe", 1000));
        db.put(35, new PiwoEntity(35, "Amber Żywe", 1000));
        db.put(36, new PiwoEntity(36, "Amber Naturalny", 1000));
        db.put(37, new PiwoEntity(37, "Miłosław Pilzner", 1000));
        db.put(38, new PiwoEntity(38, "Miłosław Witbier", 1000));
        db.put(39, new PiwoEntity(39, "Cornelius IPA", 1000));
        db.put(40, new PiwoEntity(40, "Cornelius Pszeniczne", 1000));
        db.put(41, new PiwoEntity(41, "Romber Lager", 1000));
        db.put(42, new PiwoEntity(42, "Romber Pale Ale", 1000));
        db.put(43, new PiwoEntity(43, "Romber Wheat", 1000));
        db.put(44, new PiwoEntity(44, "Zatecky Světlý Ležák", 1000));
        db.put(45, new PiwoEntity(45, "Zatecky Pils", 1000));
        db.put(46, new PiwoEntity(46, "Garage Hard Lemonade", 1000));
        db.put(47, new PiwoEntity(47, "Garage Hard Apple", 1000));
        db.put(48, new PiwoEntity(48, "Garage Hard Raspberry", 1000));
        db.put(49, new PiwoEntity(49, "Somersby Apple", 1000));
        db.put(50, new PiwoEntity(50, "Somersby Pear", 1000));
        db.put(51, new PiwoEntity(51, "Somersby Blackberry", 1000));
        db.put(52, new PiwoEntity(52, "Somersby Watermelon", 1000));
        db.put(53, new PiwoEntity(53, "Somersby Elderflower Lime", 1000));
        db.put(54, new PiwoEntity(54, "Red's Apple", 1000));
        db.put(55, new PiwoEntity(55, "Red's Grapefruit", 1000));
        db.put(56, new PiwoEntity(56, "Red's Orange", 1000));
        db.put(57, new PiwoEntity(57, "Red's Strawberry", 1000));
    }

}
