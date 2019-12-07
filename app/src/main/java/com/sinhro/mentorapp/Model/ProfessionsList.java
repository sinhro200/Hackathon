package com.sinhro.mentorapp.Model;

import java.io.Serializable;
import java.util.List;

public class ProfessionsList implements Serializable {
    List<ProfessionInfo> professionInfoList;

    public ProfessionsList(List<ProfessionInfo> professionInfoList) {
        this.professionInfoList = professionInfoList;
    }

    public List<ProfessionInfo> getProfessionInfoList() {
        return professionInfoList;
    }

    public void setProfessionInfoList(List<ProfessionInfo> professionInfoList) {
        this.professionInfoList = professionInfoList;
    }
}
