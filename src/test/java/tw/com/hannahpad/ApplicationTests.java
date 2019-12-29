package tw.com.hannahpad;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.com.hannahpad.dto.DetailDto;
import tw.com.hannahpad.service.SevenElevenService;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private SevenElevenService ses;

    @Test
    void contextLoads() throws IOException {
        HashSet<String> ids = new HashSet<>();
        ids.add("C92502227535");
        ids.add("C90010835499");
        ids.add("C87516715441");
        List<DetailDto> dtos = ses.entry(ids);
        System.out.println(dtos);
    }

}
