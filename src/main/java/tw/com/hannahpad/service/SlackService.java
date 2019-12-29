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
import java.util.Arrays;
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

        String message = String.format("ip: %s\n", UserAnalysisUtil.getIpAddr(request));
        message += String.format("user agent: %s\n", UserAnalysisUtil.getUserAgent(request));
        message += String.format("ids: %s", Arrays.toString(ids.toArray()));
        SlackPayloadDto payload = new SlackPayloadDto(message);

        try {
            ResponseEntity<String> response = rest.postForEntity(url, payload, String.class);
            System.out.println(String.format("Slack: status code [%d], return message [%s] ", response.getStatusCodeValue(), response.getBody()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
