package com.example.capstone3.DTO_in;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignReportDTO {

    @NotNull
    private Integer campaignId;

    private String issueTitle;

    private String details;

    private String reportedAt;
}