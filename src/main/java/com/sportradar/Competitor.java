package com.sportradar;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Competitor {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("abbreviation")
    private String abbreviation;
    @JsonProperty("qualifier")
    private String qualifier;
    @JsonProperty("gender")
    private String gender;

    @Override
    public String toString() {
        return "Competitor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", country_code='" + countryCode + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", qualifier='" + qualifier + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
