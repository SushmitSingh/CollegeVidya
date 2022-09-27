package com.app.collegevidya.data.model;

import java.util.ArrayList;

public class CompareQuizModel {
    private String quiz;
    private ArrayList<OptionsModel> quizOptions;

    public CompareQuizModel(String quiz, ArrayList<OptionsModel> quizOptions) {
        this.quiz = quiz;
        this.quizOptions = quizOptions;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public ArrayList<OptionsModel> getQuizOptions() {
        return quizOptions;
    }

    public void setQuizOptions(ArrayList<OptionsModel> quizOptions) {
        this.quizOptions = quizOptions;
    }
}
