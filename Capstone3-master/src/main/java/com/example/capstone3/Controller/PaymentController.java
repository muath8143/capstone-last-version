package com.example.capstone3.Controller;

import com.example.capstone3.Model.PaymentRequest;
import com.example.capstone3.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping("/card")
    public ResponseEntity<String> payByCard(@RequestBody PaymentRequest request) {
        return paymentService.createCardPayment(request);
    }


    @GetMapping("/get-status/{paymentId}")
    public ResponseEntity<String> getStatus(@PathVariable String paymentId) {
        return paymentService.getPaymentStatus(paymentId);
    }

    @GetMapping("/callback")
    public ResponseEntity<String> callback() {
        return ResponseEntity.ok("ok");
    }

}
