package com.example.mission.model.service;

import com.example.mission.model.model.Mission;
import com.example.mission.model.repository.MissionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("advancedServ")
public class AdvancedMissionServ implements MissionServ {
    private final MissionRep missionRep;

    @Autowired
    public AdvancedMissionServ(MissionRep missionRep) {
        this.missionRep = missionRep;
    }

    @Override
    public List<Mission> getMissions() {
        return missionRep.getAllMissions().stream()
                .filter(mission -> mission.getRank().matches("[BAS]"))
                .collect(Collectors.toList());
    }

    @Override
    public Mission findMission(int id) {
        return missionRep.getMissionById(id);
    }

    @Override
    public void addMission(String name, String rank, String description) {
        missionRep.addMission(name, rank, description);
    }

    @Override
    public List<Mission> findByRank(String rank) {
        return missionRep.getAllMissions().stream()
                .filter(mission -> mission.getRank().equalsIgnoreCase(rank))
                .collect(Collectors.toList());
    }

}
