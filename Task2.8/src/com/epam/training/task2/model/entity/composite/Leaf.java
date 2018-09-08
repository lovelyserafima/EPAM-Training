package com.epam.training.task2.model.entity.composite;

import java.util.Objects;

/**
 * Leaf is the class which has content of specific component.
 *
 * 5 August 2018
 * @author Arthur Lyup
 */

public class Leaf implements Component {
    //field
    protected String content;

    public Leaf(){

    }

    public Leaf(String content) {
        this.content = content;
    }

    //getters and setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String print() {
        return toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null){ return false;}
        if (getClass() != o.getClass()){ return false;}

        Leaf leaf = (Leaf) o;
        if (null == content){ return content == leaf.content;}
        else {
            if (content != leaf.content){ return false;}
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        return prime * ((content == null) ? 0 : content.hashCode());
    }
}
