package com.example.mission.model.main;

import com.example.mission.model.config.AppConfig;
import com.example.mission.model.model.Mission;
import com.example.mission.model.repository.MissionRep;
import com.example.mission.model.service.MissionServ;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MissionServ missionServ = context.getBean(MissionServ.class);
        MissionRep missionRep = context.getBean(MissionRep.class);

        Scanner scanner = new Scanner(System.in);

        System.out.println("All Missions:");
        for (Mission mission : missionRep.getAllMissions()) {
            System.out.println(mission);
        }

        System.out.print("\nEnter rank to search for missions (D, C, B, A, S): ");
        String rank = scanner.nextLine().trim();

        List<Mission> missionsByRank = missionRep.findByRank(rank);

        if (missionsByRank.isEmpty()) {
            System.out.println("No missions found for rank: " + rank);
        } else {
            System.out.println("\nMissions with rank '" + rank + "':");
            for (Mission mission : missionsByRank) {
                System.out.println(mission);
            }
        }

        context.close();
        scanner.close();
    }
}
