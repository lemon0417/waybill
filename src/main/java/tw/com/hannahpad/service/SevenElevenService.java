package tw.com.hannahpad.service;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tw.com.hannahpad.model.DetailDto;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class SevenElevenService {
    public List<DetailDto> entry(Set<String> ids) {
        WebClient client = new WebClient(BrowserVersion.CHROME);
        client.addRequestHeader("Referer", "https://epayment.7-11.com.tw/C2C/C2CWeb/C2C.aspx");
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        List<DetailDto> list = new ArrayList<>();
        for (String id : ids) {
            System.out.println("start bill id: " + id);
            if (StringUtils.isBlank(id)) {
                continue;
            }

            try {
                WebRequest requestSettings = new WebRequest(new URL("https://epayment.7-11.com.tw/C2C/C2CWeb/PrintC2CPinCode.aspx"), HttpMethod.POST);

                List<NameValuePair> params = Arrays.asList( //
                        new NameValuePair("PinCodeNumber", id),
                        new NameValuePair("BackTag", "https://www.ecpay.com.tw"),
                        new NameValuePair("NewWindow", "N")
                );
                requestSettings.setRequestParameters(params);
                HtmlPage page = client.getPage(requestSettings);

                DetailDto dto = parseDetail(page);
                list.add(dto);

                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        client.close();

        return list;
    }

    private DetailDto parseDetail(HtmlPage page) {
        DetailDto dto = new DetailDto();
        dto.setImgBarCode1(page.getElementById("imgBarCode1").getAttribute("src"));
        dto.setLblBarCode1(page.getElementById("lblBarCode1").asText());

        dto.setImgBarCode2(page.getElementById("imgBarCode2").getAttribute("src"));
        dto.setLblBarCode2(page.getElementById("lblBarCode2").asText());

        dto.setImgBarCode3(page.getElementById("imgBarCode3").getAttribute("src"));
        dto.setLblBarCode3(page.getElementById("lblBarCode3").asText());

        dto.setLblC2BPinCode1(page.getElementById("lblC2BPinCode1").asText());

        dto.setQrcode(page.getElementById("QRCODE").getAttribute("src"));

        dto.setLblRecvshop1(page.getElementById("lblRecvshop1").asText());
        dto.setLblRecver1(page.getElementById("lblRecver1").asText());

        dto.setLblBarCode4(page.getElementById("lblBarCode4").asText());
        dto.setLblDeadDateTime1(page.getElementById("lblDeadDateTime1").asText());
        dto.setLblPaymentCPName1(page.getElementById("lblPaymentCPName1").asText());
        dto.setLblOrderNo(page.getElementById("lblOrderNo").asText());
        dto.setLblShopperName1(page.getElementById("lblShopperName1").asText());
        return dto;
    }
}
