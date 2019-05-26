package com.ideathon.devops.automation.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BuildDetails {
    public String gitUrl;
    public String os;
    public String buildTools;
    public String language;
    public String langVersion;
    public String cloud;
    public boolean dockerize;
}
