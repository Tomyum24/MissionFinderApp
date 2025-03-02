package com.example.mission.model.repository;

import com.example.mission.model.model.Mission;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MissionRep {
    private final Map<Integer, Mission> missions = new HashMap<>();
    private int nextId = 6; // Начнем с 6, так как 1-5 уже есть

    @Bean
    public void init() {
        System.out.println("MissionRep initialized!");
    }

    public MissionRep() {
        missions.put(1, new Mission(1, "Merchant escort", "D", "Simple merchant security"));
        missions.put(2, new Mission(2, "Retrieve the Stolen Scroll", "C", "Recover an important scroll stolen by bandits."));
        missions.put(3, new Mission(3, "Capture the Rogue Ninja", "B", "Track and capture a ninja who abandoned the village."));
        missions.put(4, new Mission(4, "Infiltrate the Hidden Fortress", "A", "Gather intelligence from a heavily guarded enemy base."));
        missions.put(5, new Mission(5, "Assassinate the Criminal Lord", "S", "Eliminate a notorious underworld leader operating in secret."));
    }

    public List<Mission> getAllMissions() {
        return new ArrayList<>(missions.values());
    }

    public Mission getMissionById(int id) {
        return missions.get(id);
    }

    public void addMission(String name, String rank, String description) {
        Mission newMission = new Mission(nextId, name, rank, description);
        missions.put(nextId, newMission);
        nextId++;
    }

    public List<Mission> findByRank(String rank) {
        return missions.values().stream()
                .filter(mission -> mission.getRank().equalsIgnoreCase(rank))
                .collect(Collectors.toList());
    }
}
