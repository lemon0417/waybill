package tw.com.hannahpad.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlackAttachmentDto {

    private String fallback;

    private String pretext;

    private String color;

    private List<SlackFieldDto> fields;

    public String getFallback() {
        return fallback;
    }

    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    public String getPretext() {
        return pretext;
    }

    public void setPretext(String pretext) {
        this.pretext = pretext;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<SlackFieldDto> getFields() {
        return fields;
    }

    public void setFields(List<SlackFieldDto> fields) {
        this.fields = fields;
    }
}
