/*
 * Copyright (C) 2016 Angel Newton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quidditchcountcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Constants
    private static int SNITCH_POINTS = 30;
    private static int QUAFFLE_POINTS = 10;

    // Score and faul count
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private int redCardsTeamA = 0;
    private int redCardsTeamB = 0;
    private int blueCardsTeamA = 0;
    private int blueCardsTeamB = 0;
    private int yellowCardsTeamA = 0;
    private int yellowCardsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayAll();
    }


    private void displayAll(){
        displayForTeam(R.id.team_a_score, scoreTeamA);
        displayForTeam(R.id.team_a_red_cards, redCardsTeamA);
        displayForTeam(R.id.team_a_blue_cards, blueCardsTeamA);
        displayForTeam(R.id.team_a_yellow_cards, yellowCardsTeamA);

        displayForTeam(R.id.team_b_score, scoreTeamB);
        displayForTeam(R.id.team_b_red_cards, redCardsTeamB);
        displayForTeam(R.id.team_b_blue_cards, blueCardsTeamB);
        displayForTeam(R.id.team_b_yellow_cards, yellowCardsTeamB);
    }

    /*
     * Called when a button is pressed (score or fouls).
     */
    public void incrementScore(View view){
        switch (view.getId()){
            case R.id.team_a_plus_snitch:
                scoreTeamA += SNITCH_POINTS;
                displayForTeam(R.id.team_a_score, scoreTeamA);
                break;
            case R.id.team_a_plus_quaffle:
                scoreTeamA += QUAFFLE_POINTS;
                displayForTeam(R.id.team_a_score, scoreTeamA);
                break;
            case R.id.team_a_red_card:
                redCardsTeamA++;
                displayForTeam(R.id.team_a_red_cards, redCardsTeamA);
                break;
            case R.id.team_a_blue_card:
                blueCardsTeamA++;
                displayForTeam(R.id.team_a_blue_cards, blueCardsTeamA);
                break;
            case R.id.team_a_yellow_card:
                yellowCardsTeamA++;
                displayForTeam(R.id.team_a_yellow_cards, yellowCardsTeamA);
                break;

            case R.id.team_b_plus_snitch:
                scoreTeamB += SNITCH_POINTS;
                displayForTeam(R.id.team_b_score, scoreTeamB);
                break;
            case R.id.team_b_plus_quaffle:
                scoreTeamB += QUAFFLE_POINTS;
                displayForTeam(R.id.team_b_score, scoreTeamB);
                break;
            case R.id.team_b_red_card:
                redCardsTeamB++;
                displayForTeam(R.id.team_b_red_cards, redCardsTeamB);
                break;
            case R.id.team_b_blue_card:
                blueCardsTeamB++;
                displayForTeam(R.id.team_b_blue_cards, blueCardsTeamB);
                break;
            case R.id.team_b_yellow_card:
                yellowCardsTeamB++;
                displayForTeam(R.id.team_b_yellow_cards, yellowCardsTeamB);
                break;
        }
    }

    /**
     * Called when the Reset button is pressed.
     */
    public void resetGame(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        redCardsTeamA = 0;
        redCardsTeamB = 0;
        blueCardsTeamA = 0;
        blueCardsTeamB = 0;
        yellowCardsTeamA = 0;
        yellowCardsTeamB = 0;
        displayAll();
    }

    /**
     * Displays the given score for the Team.
     */
    public void displayForTeam(int id, int score) {
        TextView scoreView = (TextView) findViewById( id);
        scoreView.setText(String.valueOf(score));
    }
}
