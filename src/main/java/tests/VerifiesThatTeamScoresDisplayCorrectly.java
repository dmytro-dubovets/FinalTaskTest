package tests;

import driver.DriverFactory;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifiesThatTeamScoresDisplayCorrectly extends DriverFactory {
    String championshipTeam_1 = "Scottish Championship";
    String firstTeam_1 = "Dunfermline";
    String secondTeam_1 = "Partick Thistle";
    String firstScoreTeam_1 = "5";
    String secondScoreTeam_1 = "1";
    String monthAndYearTeam_1 = "2019 November";

    String championshipTeam_2 = "National League";
    String firstTeam_2 = "Notts County";
    String secondTeam_2 = "Barnet";
    String firstScoreTeam_2 = "2";
    String secondScoreTeam_2 = "0";
    String monthAndYearTeam_2 = "2020 July";

    String championshipTeam_3 = "Europa League";
    String firstTeam_3 = "LASK";
    String secondTeam_3 = "Manchester United";
    String firstScoreTeam_3 = "0";
    String secondScoreTeam_3 = "5";
    String monthAndYearTeam_3 = "2020 March";

    String championshipTeam_4 = "Premier League";
    String firstTeam_4 = "Burnley";
    String secondTeam_4 = "Crystal Palace";
    String firstScoreTeam_4 = "0";
    String secondScoreTeam_4 = "2";
    String monthAndYearTeam_4 = "2019 November";

    String championshipTeam_5 = "England Football Team";
    String firstTeam_5 = "Kosovo";
    String secondTeam_5 = "England";
    String firstScoreTeam_5 = "0";
    String secondScoreTeam_5 = "4";
    String monthAndYearTeam_5 = "2019 November";


    @Test
    public void checkThatTeamsScores() {
        List<String> expectedScoreOnTheTeamPage = new HomePage(driver)
                .clickOnSport()
                .clickOnFootball()
                .clickOnScoresAndFixtures()
                .typeInTheSearchAndPressEnter(championshipTeam_1)
                .getScoresOnTheTeamPage(firstScoreTeam_1, secondScoreTeam_1, firstTeam_1,
                        secondTeam_1, monthAndYearTeam_1);
        assertThat(expectedScoreOnTheTeamPage).containsSequence(firstScoreTeam_1, secondScoreTeam_1);
    }

    @Test
    public void checkThatTeamsScoresSecondChampionShip() {
        List<String> expectedScoreOnTheTeamPage = new HomePage(driver)
                .clickOnSport()
                .clickOnFootball()
                .clickOnScoresAndFixtures()
                .typeInTheSearchAndPressEnter(championshipTeam_2)
                .getScoresOnTheTeamPage(firstScoreTeam_2, secondScoreTeam_2, firstTeam_2,
                        secondTeam_2, monthAndYearTeam_2);
        assertThat(expectedScoreOnTheTeamPage).containsSequence(firstScoreTeam_2, secondScoreTeam_2);
    }

    @Test
    public void checkThatTeamsScoresThirdChampionShip() {
        List<String> expectedScoreOnTheTeamPage = new HomePage(driver)
                .clickOnSport()
                .clickOnFootball()
                .clickOnScoresAndFixtures()
                .typeInTheSearchAndPressEnter(championshipTeam_3)
                .getScoresOnTheTeamPage(firstScoreTeam_3, secondScoreTeam_3, firstTeam_3,
                        secondTeam_3, monthAndYearTeam_3);
        assertThat(expectedScoreOnTheTeamPage).containsSequence(firstScoreTeam_3, secondScoreTeam_3);
    }

    @Test
    public void checkThatTeamsScoresFourthChampionShip() {
        List<String> expectedScoreOnTheTeamPage = new HomePage(driver)
                .clickOnSport()
                .clickOnFootball()
                .clickOnScoresAndFixtures()
                .typeInTheSearchAndPressEnter(championshipTeam_4)
                .getScoresOnTheTeamPage(firstScoreTeam_4, secondScoreTeam_4, firstTeam_4,
                        secondTeam_4, monthAndYearTeam_4);
        assertThat(expectedScoreOnTheTeamPage).containsSequence(firstScoreTeam_4, secondScoreTeam_4);
    }

    @Test
    public void checkThatTeamsScoresFifthChampionShip() {
        List<String> expectedScoreOnTheTeamPage = new HomePage(driver)
                .clickOnSport()
                .clickOnFootball()
                .clickOnScoresAndFixtures()
                .typeInTheSearchAndPressEnter(championshipTeam_5)
                .getScoresOnTheTeamPage(firstScoreTeam_5, secondScoreTeam_5, firstTeam_5,
                        secondTeam_5, monthAndYearTeam_5);
        assertThat(expectedScoreOnTheTeamPage).containsSequence(firstScoreTeam_5, secondScoreTeam_5);
    }
}
