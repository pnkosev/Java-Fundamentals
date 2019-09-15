package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Pr04TeamworkProjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teamList = new ArrayList<>();

        int numberOfTeams = Integer.parseInt(scanner.nextLine());

        while (numberOfTeams-- > 0) {
            String[] input = scanner.nextLine().split("-");
            String user = input[0];
            String teamName = input[1];

            if (teamList.stream().anyMatch(team -> team.getName().equals(teamName))) {
                System.out.println("Team " + teamName + " was already created!");
            } else if (teamList.stream().anyMatch(team -> team.getCreator().equals(user))) {
                System.out.println(user + " cannot create another team!");
            } else {
                teamList.add(new Team(user, teamName));
                System.out.println("Team " + teamName + " has been created by " + user + "!");
            }

//            boolean hasBrokenARule = false;

//            for (Team team : teamList) {
//                if (team.getName().equals(teamName)) {
//                    hasBrokenARule = true;
//                    System.out.println("Team " + teamName + " was already created!");
//                    break;
//                } else if (team.getCreator().equals(user)) {
//                    hasBrokenARule = true;
//                    System.out.println(user + " cannot create another team!");
//                    break;
//                }
//            }
//
//            if (!hasBrokenARule) {
//                teamList.add(new Team(user, teamName));
//                System.out.println("Team " + teamName + " has been created by " + user + "!");
//            }
        }

        String line;

        while (!(line = scanner.nextLine()).equals("end of assignment")) {
            String[] input = line.split("->");
            String member = input[0];
            String teamName = input[1];

            if (teamList.stream().noneMatch(team -> team.getName().equals(teamName))) {
                System.out.println("Team " + teamName + " does not exist!");
            } else if (teamList.stream().anyMatch(team -> team.getCreator().equals(member))) {
                System.out.println("Member " + member + " cannot join team " + teamName + "!");
            } else {
                for (Team team : teamList) {
                    if (team.getName().equals(teamName)) {
                        team.addMember(member);
                    }
                }
            }

//            boolean isTeamExisting = false;
//
//            for (Team team : teamList) {
//                if (team.getName().equals(teamName)) {
//                    isTeamExisting = true;
//                    if (team.getCreator().equals(member)) {
//                        System.out.println("Member " + member + " cannot join team " + teamName + "!");
//                        break;
//                    }
//                    team.addMember(member);
//                }
//            }
//            if (!isTeamExisting) {
//                System.out.println("Team " + teamName + " does not exist!");
//            }
        }

        List<Team> teamsDisband = teamList.stream().filter(t -> t.getMembersSize() == 0).collect(Collectors.toList());
        teamList = teamList.stream().filter(t -> t.getMembersSize() > 0).collect(Collectors.toList());

        Comparator<Team> teamComparator = Comparator.comparing(Team::getMembersSize).reversed().thenComparing(Team::getName);

        teamList = teamList.stream().sorted(teamComparator).collect(Collectors.toList());

        for (Team team : teamList) {
            System.out.println(team.getName());
            System.out.println("- " + team.getCreator());
            List<String> members = team.getMembers();
            members.sort(String::compareTo);
            for (String member : members) {
                System.out.println("-- " + member);
            }
        }

        System.out.println("Teams to disband:");
        teamsDisband.sort(Comparator.comparing(Team::getName));
        for (Team team : teamsDisband) {
            System.out.println(team.getName());
        }
    }

    static class Team {
        String creator;
        String name;
        List<String> members = new ArrayList<>();

        public Team(String creator, String name) {
            this.creator = creator;
            this.name = name;
        }

        public void addMember(String member) {
            this.members.add(member);
        }

        public String getName() {
            return this.name;
        }

        public String getCreator() {
            return this.creator;
        }

        public List<String> getMembers() {
            return this.members;
        }

        public int getMembersSize() {
            return this.members.size();
        }
    }
}
