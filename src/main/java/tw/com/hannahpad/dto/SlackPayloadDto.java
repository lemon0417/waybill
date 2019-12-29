package tw.com.hannahpad.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * https://api.slack.com/reference/surfaces/formatting
 * https://api.slack.com/messaging/composing/layouts#attachments
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlackPayloadDto {

    private String username;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("icon_emoji")
    private String iconEmoji;

    private String channel;

    private String text;

    private List<SlackAttachmentDto> attachments;

    public SlackPayloadDto() {
    }

    public SlackPayloadDto(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIconEmoji() {
        return iconEmoji;
    }

    public void setIconEmoji(String iconEmoji) {
        this.iconEmoji = iconEmoji;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<SlackAttachmentDto> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<SlackAttachmentDto> attachments) {
        this.attachments = attachments;
    }
}
