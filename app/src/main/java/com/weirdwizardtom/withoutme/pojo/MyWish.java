package com.weirdwizardtom.withoutme.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class MyWish {
    private String name;
    private String description;
    private Date timeAdded;

    public MyWish(String name, String description, Date timeAdded) {
        this.name = name;
        this.description = description;
        this.timeAdded = timeAdded;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getTimeAdded() {
        return timeAdded;
    }
}
