package com.example.susancarrera.susan2017summer.audio;

import java.io.Serializable;

/**
 * Created by SusanCarrera on 7/3/17.
 */

public class BaseBean implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
