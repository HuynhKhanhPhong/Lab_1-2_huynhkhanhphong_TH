package com.example.lab10_11_hkp;

import java.io.Serializable;

public class ZodiacEntity implements Serializable {
    private final String name;
    private final String dateRange;
    private final String content;
    private final int imageResId;

    public ZodiacEntity(String name, String dateRange, String content, int imageResId) {
        this.name = name;
        this.dateRange = dateRange;
        this.content = content;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getDateRange() { return dateRange; }
    public String getContent() { return content; }
    public int getImageResId() { return imageResId; }
}
