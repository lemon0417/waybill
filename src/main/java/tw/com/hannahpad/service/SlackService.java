package tw.com.hannahpad.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tw.com.hannahpad.dto.SlackPayloadDto;
import tw.com.hannahpad.helper.UserAnalysisUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Service
public class SlackService {

    @Autowired
    private RestTemplate rest;

    @Value("${slack.webhook.url}")
    private String url;

    public void sendMessage(Set<String> ids, HttpServletRequest request) {
        if (StringUtils.isBlank(url) || ids.size() == 0) {
            return;
        }

        StringBuilder message = new StringBuilder();
        message.append("ip: ").append(UserAnalysisUtil.getIpAddr(request))
                .append(System.lineSeparator())
                .append("user agent: ").append(UserAnalysisUtil.getUserAgent(request))
                .append(System.lineSeparator())
                .append("ids: ").append(String.join(", ", ids))
        ;
        SlackPayloadDto payload = new SlackPayloadDto(message.toString());

        try {
            ResponseEntity<String> response = rest.postForEntity(url, payload, String.class);
            System.out.println(String.format("Slack: status code [%d], return message [%s] ", response.getStatusCodeValue(), response.getBody()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
