package com.prashhanth.secuirty.service.external;

import com.prashhanth.secuirty.entity.external.UserExt;
import com.prashhanth.secuirty.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class UserExtService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Producer producer;

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    public ResponseEntity<?> getUsersList() {
        HashMap<String,Object> map= new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<UserExt>> entity = new HttpEntity<List<UserExt>>(headers);
        List<UserExt> body = restTemplate.exchange("http://localhost:9090/users", HttpMethod.GET, entity, List.class).getBody();
        long count=body.stream().count();
        map.put("total count",count);
        map.put("Users",body);
        producer.sendDataToActiveMq(body);
        return new ResponseEntity(map,HttpStatus.OK);
    }
}
