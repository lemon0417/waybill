package tw.com.hannahpad.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class RetryService {

    @Retryable(value = UnknownHostException.class, maxAttempts = 5, backoff = @Backoff(delay = 3000L, multiplier = 0))
    public boolean precheck(String hostUrl) throws UnknownHostException {
        System.out.println("Start check " + hostUrl + "...");
        InetAddress inetAddress = InetAddress.getByName(hostUrl);
        return true;
    }

    @Recover
    public boolean recover(UnknownHostException e) throws UnknownHostException {
        System.out.println("Noooooooo! Check connection fail.");
        e.printStackTrace();
        return false;
    }
}
