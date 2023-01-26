package com.sportradar;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    @JsonProperty("sport_event_id")
    private String sportEventId;
    @JsonProperty("start_date")
    private Date startDate;
    @JsonProperty("sport_name")
    private String sportName;
    @JsonProperty("competition_name")
    private String competitionName;
    @JsonProperty("competition_id")
    private String competitionId;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("competitors")
    private List<Competitor> competitors;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("capacity")
    private String capacity;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("map_coordinates")
    private String mapCoordinates;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("probability_home_team_winner")
    private Double probabilityHomeTeamWinner;
    @JsonProperty("probability_draw")
    private Double probabilityDraw;
    @JsonProperty("probability_away_team_winner")
    private Double probabilityAwayTeamWinner;

    @Override
    public String toString() {
        return "Event{" +
                "sportEventId='" + sportEventId + '\'' +
                ", startDate=" + startDate +
                ", sportName='" + sportName + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", competitionId='" + competitionId + '\'' +
                ", seasonName='" + seasonName + '\'' +
                ", competitors=" + competitors +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", cityName='" + cityName + '\'' +
                ", mapCoordinates='" + mapCoordinates + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", probabilityHomeTeamWinner=" + probabilityHomeTeamWinner +
                ", probabilityDraw=" + probabilityDraw +
                ", probabilityAwayTeamWinner=" + probabilityAwayTeamWinner +
                '}';
    }

    public double getHighestProbableValue() {
        if (probabilityHomeTeamWinner > probabilityDraw && probabilityHomeTeamWinner > probabilityAwayTeamWinner) {
            return probabilityHomeTeamWinner;
        } else if (probabilityDraw > probabilityHomeTeamWinner && probabilityDraw > probabilityAwayTeamWinner) {
            return probabilityDraw;
        } else {
            return probabilityAwayTeamWinner;
        }
    }
}
