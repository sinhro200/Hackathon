package com.sinhro.mentorapp.Model;

import java.io.Serializable;

public class ProfessionInfo implements Serializable {
    String title;
    double percent;

    public ProfessionInfo(String title, double percent) {
        this.title = title;
        this.percent = percent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
