package com.liup.task4.builder;

import com.liup.task4.entity.PaperEdition;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPaperBuilder {
    protected Set<PaperEdition> paperEditions;
    public AbstractPaperBuilder() {
        paperEditions = new HashSet<>();
    }
    public AbstractPaperBuilder(Set<PaperEdition> paperEditions) {
        this.paperEditions = paperEditions;
    }
    public Set<PaperEdition> getPapers() {
        return Collections.unmodifiableSet(paperEditions);
    }
    public abstract void buildSetPaperEdition(String fileName);
}
