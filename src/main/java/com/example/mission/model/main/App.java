package com.example.mission.model.main;

import com.example.mission.model.model.Mission;
import com.example.mission.model.service.MissionServ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.mission");
        MissionServ missionService = context.getBean("basicMissionServ", MissionServ.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показать все миссии");
            System.out.println("2. Найти миссию по ID");
            System.out.println("3. Найти миссию по рангу");
            System.out.println("4. Добавить новую миссию");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Введите число.");
                scanner.nextLine(); // Очистка буфера
                continue;
            }

            scanner.nextLine(); // Очистка буфера после nextInt()

            switch (choice) {
                case 1:
                    missionService.getMissions().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Введите ID миссии: ");
                    int id = scanner.nextInt();
                    System.out.println(missionService.findMission(id));
                    break;
                case 3:
                    System.out.print("Введите ранг миссий (A, B, C, D, S): ");
                    String rank = scanner.nextLine();
                    List<Mission> missionsByRank = missionService.findByRank(rank);
                    missionsByRank.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Название миссии: ");
                    String name = scanner.nextLine();
                    System.out.print("Ранг миссии (A, B, C, D, S): ");
                    String missionRank = scanner.nextLine();
                    System.out.print("Описание миссии: ");
                    String description = scanner.nextLine();
                    missionService.addMission(name, missionRank, description);
                    System.out.println("Миссия добавлена!");
                    break;
                case 5:
                    System.out.println("Выход...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");
            }
        }
    }
}
