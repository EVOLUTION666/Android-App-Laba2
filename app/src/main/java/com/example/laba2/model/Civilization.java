package com.example.laba2.model;

import java.io.Serializable;

public class Civilization implements Serializable {
    private String flags;
    private String graphic;
    private String graphic_alt;
    private String helptext;
    private String name;
    private String req1;
    private String req2;

    public Civilization() {
    }

    public Civilization(String flags, String graphic, String graphic_alt, String helptext, String name, String req1, String req2) {
        this.flags = flags;
        this.graphic = graphic;
        this.graphic_alt = graphic_alt;
        this.helptext = helptext;
        this.name = name;
        this.req1 = req1;
        this.req2 = req2;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getGraphic_alt() {
        return graphic_alt;
    }

    public void setGraphic_alt(String graphic_alt) {
        this.graphic_alt = graphic_alt;
    }

    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReq1() {
        return req1;
    }

    public void setReq1(String req1) {
        this.req1 = req1;
    }

    public String getReq2() {
        return req2;
    }

    public void setReq2(String req2) {
        this.req2 = req2;
    }
}
