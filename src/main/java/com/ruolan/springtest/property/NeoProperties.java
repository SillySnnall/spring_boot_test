package com.ruolan.springtest.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class NeoProperties {
    @Value("${com}")
    private String title;
    @Value("${neo}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NeoProperties{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
