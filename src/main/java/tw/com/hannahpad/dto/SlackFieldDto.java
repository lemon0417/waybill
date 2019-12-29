package tw.com.hannahpad.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlackFieldDto {

    private String title;

    private String value;

    @JsonProperty("short")
    private String theShort;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTheShort() {
        return theShort;
    }

    public void setTheShort(String theShort) {
        this.theShort = theShort;
    }
}
