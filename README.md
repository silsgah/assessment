The task was approached with a microservice components architecture, consisting of:
Data Ingestion Service: Microservice 1
Receives raw NBA game statistics data from external sources (e.g., APIs, data feeds).
Validates the data to ensure its integrity (positive numbers, valid ranges, etc.).
Stores the validated data in a relational database (e.g., PostgreSQL).
Feign 

Data Aggregation Service:Microservice 2
Subscribes to events from the Data Ingestion Service.
Queries the database for new game statistics data.
Calculates aggregate statistics (e.g., season averages, player rankings) based on the new data.
Stores aggregated data in a dedicated table in the database.

API Service:
Exposes a REST API for human users to access and query the calculated aggregate statistics.
Handles requests, retrieves data from the database, and returns results in a structured format (e.g., JSON).
Key Technologies:
Microservices: Independent services communicate through APIs.
Relational Database: Stores raw and aggregated data (used- PostgreSQL).
REST API: Enables communication with human users.
Benefits:
Scalability: Independent services can be scaled horizontally to handle increasing data volumes and user traffic. AWS cloud formation was used to enable handle high volume of data inflow.
Resilience: Failures in one service don't impact others. Automatic load balancers 
Maintainability: Smaller, focused services are easier to develop, deploy, and maintain.
Up-to-Date Data: Data is propagated to the statistic table as soon as they are created in the service for collecting the data.
Additional Considerations:
Security:No security implemented due to time constraint and not mentioned
Monitoring: Track system health and performance metrics.
Logging: Capture logs for debugging and troubleshooting.
Deployment: AWS ECS was employed for deployment
