package com.example.mission.model.service;

import com.example.mission.model.model.Mission;
import com.example.mission.model.repository.MissionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class BasicMissionServ implements MissionServ {

    private final MissionRep missionRep;
    @Autowired
    public BasicMissionServ(MissionRep missionRep) {
        this.missionRep = missionRep;
    }

    @Override
    public List<Mission> getMissions() {
        return missionRep.getAllMissions();
    }

    @Override
    public Mission findMission(int id) {
        return missionRep.getMissionById(id);
    }
}
