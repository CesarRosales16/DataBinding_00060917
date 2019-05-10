package com.aldana.ejemplo14

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        val scoreTeamAObserver = Observer<Int> { newValueA ->
            tv_score_team_a.text = newValueA.toString()
        }

        val scoreTeamBObserver = Observer<Int> { newValueB ->
            tv_score_team_b.text = newValueB.toString()
        }

        scoreViewModel.scoreTeamA.observe(this, scoreTeamAObserver)
        scoreViewModel.scoreTeamB.observe(this, scoreTeamBObserver)


        bt_team_a_3_p.setOnClickListener {
            scoreViewModel.modifyScoreTeamA(3)
        }
        bt_team_a_2_p.setOnClickListener {
            scoreViewModel.modifyScoreTeamA(2)
        }
        bt_team_a_free_throw.setOnClickListener {
            scoreViewModel.modifyScoreTeamA(1)
        }

        bt_team_b_3_p.setOnClickListener {
            scoreViewModel.modifyScoreTeamB(3)
        }

        bt_team_b_2_p.setOnClickListener {
            scoreViewModel.modifyScoreTeamB(2)
        }
        bt_team_b_free_throw.setOnClickListener {
            scoreViewModel.modifyScoreTeamB(1)
        }

        bt_reset.setOnClickListener {
            scoreViewModel.resetScores()
        }
    }
}

