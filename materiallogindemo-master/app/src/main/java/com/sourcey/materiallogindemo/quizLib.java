package com.sourcey.materiallogindemo;

/**
 * Created by Annie on 2/17/2018.
 */

public class quizLib {
    private String mQuestions [] = {
            "How long did you sleep?",
            "Did you fall today or lose your balance?",
            "Did you bump into anything?",
            "Did you drop anything by mistake?",
            "Did you feel shaky?",
            "Did you have any headaches?",
            "How does your stomach feel",
            "Did you feel like you were moving slower today?",
            "Did you talk with other people today?",
            "Were you able to easily convey your message to other people?",
            "Did other people having meaningful or notable things to say?",
            "Were you able to sit still and complete everything you wanted to?",
            "Was there anything that was hard for you to grasp?",
            "Did you feel disoriented today?",
            "Rank your overall mood: "
    };


    private String mChoices [][] = {
            {"0-2", "2-5", "5-8", "8-10+"},
            {"A lot", "Moderate", "A little", "Not at all"},
            {"Yes, it hurt a lot", "Just something small by accident", "Yes, I just don't notice objects in front of me", "Definitely not"},
            {"Yes, but it was very heavy", "Yes, but it was slippery", "Yes, my hands were shaky", "No"},
            {"Yes, too shaky to move", "Yes, just a little bit but it was annoying", "No my body actually felt more stiff", "No, perfectly fine"},
            {"Nonexistent", "Mild", "Moderate", "Severe"},
            {"Indigestion/Vomiting", "Not hungry/lost my appetite", "Feels fine", "Cramps"},
            {"Yes, all the time", "Yes, sometimes", "No, normal Pace", "No, I was faster"},
            //talking with other ppl
            {"Yes, I had great conversations", "Yes, but I didn't talk a lot", "No, I wasn't too interested", "No, I was afraid to talk"},
            {"Yes, my conversation went well", "No, I kept stumbling my words and couldn't articulate well", "No, I didn't know how to bring up my points", "No, I kept losing track of my thoughts"},
            {"Yes, I received compliments", "Yes, they told me something was different about me", "Nothing out of the ordinary", "Yes, someone pointed out my rapid change in mood"},
            {"Yes, I was very productive today", "Yes, but I was feeling a bit tired afterward", "No, my mind keeps wandering", "No, I couldn't concentrate on the job"},
            {"Yes, something I was learning today was difficult material", "Yes, I had trouble thinking or grasping the subject", "Yes, I couldn't remember some facts I used to know", "No, everything was fine and clear"},
            {"Yes, I was feeling nauseous", "Yes, I had a headache", "Yes, I just felt sad and frustrated", "No, I felt focused"},
            {"Happiness/Satisfaction", "Sadness/Upset", "Fear/Anxiety", "Angry"}

    };


    public int getSize() {
        return mQuestions.length;

    }

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;

    }

}
