package com.example.mission.model.service;

import com.example.mission.model.model.Mission;

import java.util.List;
import java.util.Map;

public interface MissionServ {
    List<Mission> getMissions();
    Mission findMission(int id);
}
