Muath’s Contributions to the Project

• Designed and implemented core domain models and database structure, including:
	• Pilgrim
	• Campaign
	• Inspector
	• Violation
	• Objection
	• Designing the complete Database Diagram and defining entity relationships

• Implemented full business logic for violations and objections, including:
	•	Linking violations to inspectors and kitchens
	•	Allowing only one objection per violation
	•	Approving and rejecting objections with proper status handling
	•	Automatically closing violations when objections are approved

• Developed violation enforcement rules, including:
	•	Automatically suspending a kitchen when violations exceed a defined threshold
	•	Managing violation lifecycle (open, close, reopen)

• Built and integrated the emergency reporting feature using n8n, including:
	•	Designing the n8n workflow for emergency cases
	•	Creating a dedicated backend service to communicate with n8n
	•	Sending real-time emergency campaign reports to admins via a Telegram bot
	•	Broadcasting emergency messages to all admins using their stored Telegram chat IDs

• Implemented admin Telegram integration, including:
	•	Storing Telegram chatId in the Admin model
	•	Providing an endpoint to retrieve all admin chat IDs for notifications
	•	Linking backend data with n8n Telegram nodes dynamically


Rawan’s Contributions to the Project
• Models, Services and Controllers: 
Kitchen
• Provides full CRUD operations
• Includes additional endpoints
• Generates summarized kitchen reports
• Output:
KitchenReportDTO

Meal
• Provides full CRUD operations
• Includes additional endpoints

Rating
• Handles kitchen evaluations
• Provides full CRUD operations


• Services:
Email Service
• Sends automated email notifications
• Notifies the pilgrim when they are successfully registered in a campaign
• Includes registration confirmation details such as campaign information


• AI:
Multi-Language Health Advice
-Provides AI-generated health and nutrition advice
-Supports multiple languages
-Endpoint:
GET /advice/{lang}
-Output:
PilgrimAdviceDTO

Campaign Health Risk Prediction
• Analyzes campaign-level health data
• Predicts potential health risks
• Provides preventive recommendations
• Endpoint:
GET /risk/{campaignId}
-Output:
CampaignRiskDTO

Turki’s Contributions to the Project
•	Designed and wrote the email notification content and HTML layout, including:
	Custom HTML email templates
	Clear Arabic notification messages
	Proper formatting and styling for system emails
•	Implemented the WhatsApp notification service, including:
	Creating a dedicated WhatsApp service
	Sending real-time notifications for system events
•	Structuring clear and readable WhatsApp messages
•	Added and managed DTOs for the Objection workflow, including:
	DTO for submitting an objection (reason only)
	DTO for approving and rejecting objections
	DTOs for objection responses and reports
	Ensuring clean request/response separation using DTOs


•	Designed the project logo and visual identity, including:
	Creating the logo concept
Aligning branding with the project theme
Using the logo consistently in the presentation
•	Implemented the following core system endpoints:
Admin Endpoints
•	PUT /activate-kitchen/{id}
•	PUT /suspend-kitchen/{id}
•	PUT /assign-kitchens/{inspectorId}
•	PUT /reject-kitchen/{kitchenId}
Reports & AI Endpoints
•	GET /approval-report
(Objection approval statistics report)
•	POST /ai/meal/validate-for-pilgrim
(AI-based meal validation using pilgrim health records)
•	POST /ai/inspectors/evaluate-performance/{inspectorId}
(AIInspectorPerformanceService)
Campaign Management Endpoints
•	PUT /add-pilgrim/{pilgrimId}/{campaignId}
•	PUT /close-registration/{campaignId}
Health & Risk Classification Endpoints
•	GET /classify-risk/{pilgrimId}
(HealthRecord risk classification)
