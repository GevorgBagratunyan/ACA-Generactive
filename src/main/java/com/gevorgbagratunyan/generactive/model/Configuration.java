package com.gevorgbagratunyan.generactive.model;


import com.gevorgbagratunyan.generactive.model.enums.Resolution;

public class Configuration {

    private Resolution resolution;

    public Configuration(Resolution resolution) {
        this.resolution = resolution;
    }

    public Resolution getResolution() {
        return resolution;
    }

}
