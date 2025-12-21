package com.example.capstone3.Service;

import com.example.capstone3.Model.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${moyasar.api.key:}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String MOYASAR_URL = "https://api.moyasar.com/v1/payments";

    public ResponseEntity<String> createCardPayment(PaymentRequest req) {

        if (apiKey == null || apiKey.isBlank()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("MOYASAR_API_KEY is not set");
        }


        int amountHalalas = (int) Math.round(req.getAmount() * 100);

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey, "");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        body.add("source[type]", "card");
        body.add("source[name]", req.getName());
        body.add("source[number]", req.getNumber());
        body.add("source[cvc]", req.getCvc());
        body.add("source[month]", req.getMonth());
        body.add("source[year]", req.getYear());
        body.add("callback_url", req.getCallbackUrl());

        body.add("amount", String.valueOf(amountHalalas));
        body.add("currency", req.getCurrency());      // "SAR"
        body.add("description", req.getDescription());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        return restTemplate.postForEntity(MOYASAR_URL, entity, String.class);
    }

    public ResponseEntity<String> getPaymentStatus(String paymentId) {

        if (apiKey == null || apiKey.isBlank()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("MOYASAR_API_KEY is not set");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey, "");
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                MOYASAR_URL + "/" + paymentId,
                HttpMethod.GET,
                entity,
                String.class
        );
    }
}
