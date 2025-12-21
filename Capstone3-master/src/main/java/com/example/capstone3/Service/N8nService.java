package com.example.capstone3.Service;


import com.example.capstone3.Api.ApiException;
import com.example.capstone3.DTO_in.CampaignReportDTO;
import com.example.capstone3.Model.Campaign;
import com.example.capstone3.Repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
@RequiredArgsConstructor
public class N8nService {
    private static final String N8N_WEBHOOK_URL = "http://localhost:5678/webhook/report";
    private final CampaignRepository campaignRepository;

    public void sendCampaignReport(CampaignReportDTO dto) {
        Campaign campaign=campaignRepository.findCampaignById(dto.getCampaignId());
        if (campaign==null){
            throw new ApiException("The campaign id is not exists");
        }
        dto.setReportedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CampaignReportDTO> requestEntity = new HttpEntity<>(dto, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(N8N_WEBHOOK_URL, requestEntity, String.class);
    }
}
