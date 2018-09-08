package com.liup.task4.entity;

import java.util.ArrayList;
import java.util.List;


public class PaperEditionList {
    private List<PaperEdition> paperEdition;

    public List<PaperEdition> getPaperEdition() {
        if (paperEdition == null) {
            paperEdition = new ArrayList<PaperEdition>();
        }
        return this.paperEdition;
    }

    @Override
    public String toString() {
        return "PaperEditionList{" +
                "paperEdition=" + paperEdition +
                '}';
    }
}
