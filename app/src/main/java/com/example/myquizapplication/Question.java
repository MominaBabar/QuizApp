package com.example.myquizapplication;

public class Question
{
    private String _questionText;
    private boolean _correctAnswer;
    private boolean answered;
    private String hint;
    private int score;
    private int deductedscore;

    public Question(String question, boolean correctAnswer, boolean answered, String hint) {
        this._questionText = question;
        this._correctAnswer = correctAnswer;
        this.answered = answered;
        this.hint = hint;
        this.score = 1;
        this.deductedscore = -1;

    }

    public String getQuestionText() {
        return this._questionText;
    }

    public boolean getCorrectAnswer() {
        return this._correctAnswer;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getDeductedscore() {
        return deductedscore;
    }

    public int getScore() {
        return score;
    }

    public String getHint() {
        return hint;
    }
}
