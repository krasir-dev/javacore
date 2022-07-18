package Lesson7.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Date",
        "EpochDate",
        "Temperature",
        "Day",
        "Night",
        "Sources",
        "MobileLink",
        "Link"
})

public class WeatherResponse {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("EpochDate")
    private Integer epochDate;
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("Day")
    private Day day;
    @JsonProperty("Night")
    private Night night;
    @JsonProperty("Sources")
    private List<String> sources = null;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("EpochDate")
    public Integer getEpochDate() {
        return epochDate;
    }

    @JsonProperty("EpochDate")
    public void setEpochDate(Integer epochDate) {
        this.epochDate = epochDate;
    }

    @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }

    @JsonProperty("Temperature")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("Day")
    public Day getDay() {
        return day;
    }

    @JsonProperty("Day")
    public void setDay(Day day) {
        this.day = day;
    }

    @JsonProperty("Night")
    public Night getNight() {
        return night;
    }

    @JsonProperty("Night")
    public void setNight(Night night) {
        this.night = night;
    }

    @JsonProperty("Sources")
    public List<String> getSources() {
        return sources;
    }

    @JsonProperty("Sources")
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    @JsonProperty("MobileLink")
    public String getMobileLink() {
        return mobileLink;
    }

    @JsonProperty("MobileLink")
    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    @JsonProperty("Link")
    public String getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
class Day {

    @JsonProperty("Icon")
    private Integer icon;
    @JsonProperty("IconPhrase")
    private String iconPhrase;
    @JsonProperty("HasPrecipitation")
    private Boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    private String precipitationType;
    @JsonProperty("PrecipitationIntensity")
    private String precipitationIntensity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Icon")
    public Integer getIcon() {
        return icon;
    }

    @JsonProperty("Icon")
    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    @JsonProperty("IconPhrase")
    public String getIconPhrase() {
        return iconPhrase;
    }

    @JsonProperty("IconPhrase")
    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    @JsonProperty("HasPrecipitation")
    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    @JsonProperty("HasPrecipitation")
    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    @JsonProperty("PrecipitationType")
    public String getPrecipitationType() {
        return precipitationType;
    }

    @JsonProperty("PrecipitationType")
    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    @JsonProperty("PrecipitationIntensity")
    public String getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    @JsonProperty("PrecipitationIntensity")
    public void setPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
class Example {

    @JsonProperty("Headline")
    private Headline headline;
    @JsonProperty("DailyForecasts")
    private List<DailyForecast> dailyForecasts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Headline")
    public Headline getHeadline() {
        return headline;
    }

    @JsonProperty("Headline")
    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    @JsonProperty("DailyForecasts")
    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    @JsonProperty("DailyForecasts")
    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
class Headline {

    @JsonProperty("EffectiveDate")
    private String effectiveDate;
    @JsonProperty("EffectiveEpochDate")
    private Integer effectiveEpochDate;
    @JsonProperty("Severity")
    private Integer severity;
    @JsonProperty("Text")
    private String text;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("EndEpochDate")
    private Integer endEpochDate;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("EffectiveDate")
    public String getEffectiveDate() {
        return effectiveDate;
    }

    @JsonProperty("EffectiveDate")
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @JsonProperty("EffectiveEpochDate")
    public Integer getEffectiveEpochDate() {
        return effectiveEpochDate;
    }

    @JsonProperty("EffectiveEpochDate")
    public void setEffectiveEpochDate(Integer effectiveEpochDate) {
        this.effectiveEpochDate = effectiveEpochDate;
    }

    @JsonProperty("Severity")
    public Integer getSeverity() {
        return severity;
    }

    @JsonProperty("Severity")
    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    @JsonProperty("Text")
    public String getText() {
        return text;
    }

    @JsonProperty("Text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("EndDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("EndDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("EndEpochDate")
    public Integer getEndEpochDate() {
        return endEpochDate;
    }

    @JsonProperty("EndEpochDate")
    public void setEndEpochDate(Integer endEpochDate) {
        this.endEpochDate = endEpochDate;
    }

    @JsonProperty("MobileLink")
    public String getMobileLink() {
        return mobileLink;
    }

    @JsonProperty("MobileLink")
    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    @JsonProperty("Link")
    public String getLink() {
        return link;
    }

    @JsonProperty("Link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
class Maximum {

    @JsonProperty("Value")
    private Double value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private Integer unitType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty("Unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("Unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("UnitType")
    public Integer getUnitType() {
        return unitType;
    }

    @JsonProperty("UnitType")
    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
class Minimum {

    @JsonProperty("Value")
    private Double value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private Integer unitType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty("Unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("Unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("UnitType")
    public Integer getUnitType() {
        return unitType;
    }

    @JsonProperty("UnitType")
    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
class Night {

    @JsonProperty("Icon")
    private Integer icon;
    @JsonProperty("IconPhrase")
    private String iconPhrase;
    @JsonProperty("HasPrecipitation")
    private Boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    private String precipitationType;
    @JsonProperty("PrecipitationIntensity")
    private String precipitationIntensity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Icon")
    public Integer getIcon() {
        return icon;
    }

    @JsonProperty("Icon")
    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    @JsonProperty("IconPhrase")
    public String getIconPhrase() {
        return iconPhrase;
    }

    @JsonProperty("IconPhrase")
    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    @JsonProperty("HasPrecipitation")
    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    @JsonProperty("HasPrecipitation")
    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    @JsonProperty("PrecipitationType")
    public String getPrecipitationType() {
        return precipitationType;
    }

    @JsonProperty("PrecipitationType")
    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    @JsonProperty("PrecipitationIntensity")
    public String getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    @JsonProperty("PrecipitationIntensity")
    public void setPrecipitationIntensity(String precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
class Temperature {

    @JsonProperty("Minimum")
    private Minimum minimum;
    @JsonProperty("Maximum")
    private Maximum maximum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Minimum")
    public Minimum getMinimum() {
        return minimum;
    }

    @JsonProperty("Minimum")
    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    @JsonProperty("Maximum")
    public Maximum getMaximum() {
        return maximum;
    }

    @JsonProperty("Maximum")
    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
