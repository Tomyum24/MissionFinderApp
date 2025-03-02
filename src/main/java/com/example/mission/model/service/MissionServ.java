package com.example.mission.model.service;

import com.example.mission.model.model.Mission;

import java.util.List;

public interface MissionServ {
    List<Mission> getMissions();
    Mission findMission(int id);
    void addMission(String name, String rank, String description);
    List<Mission> findByRank(String rank);
}
