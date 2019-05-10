package com.aldana.ejemplo14

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    var scoreTeamA = MutableLiveData<Int>()
    var scoreTeamB = MutableLiveData<Int>()
    var countTeamA = 0
    var countTeamB = 0

    fun modifyScoreTeamA(num: Int) {
        countTeamA += num
        scoreTeamA.postValue(countTeamA)
    }

    fun modifyScoreTeamB(num: Int) {
        countTeamB += num
        scoreTeamB.postValue(countTeamB)
    }

    fun resetScores() {
        countTeamA = 0
        countTeamB = 0
        scoreTeamA.postValue(countTeamA)
        scoreTeamB.postValue(countTeamB)
    }
}