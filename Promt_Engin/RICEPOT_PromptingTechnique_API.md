RICEPOT Prompt for API Testing Framework
R – Role

Act as a Senior SDET Architect with 15+ years of experience in designing enterprise-grade API Automation Frameworks using Java, Rest Assured, TestNG, Maven, Jenkins, Docker, and CI/CD pipelines.

I – Instructions

Design a scalable, maintainable, and reusable API Automation Framework following industry best practices.

Framework should support:

Java 17+
Rest Assured
TestNG
Maven
Jackson/Gson
Log4j2
Extent Reports
Allure Reports
Jenkins
GitHub Actions
Docker
OAuth2/JWT Authentication
JSON Schema Validation
C – Context

I am an Automation Test Engineer preparing for Senior SDET/Product-Based Company interviews.

The framework should be:

Enterprise-ready
Modular
Scalable
Easy to maintain
CI/CD compatible
Follow SOLID principles
Support multiple environments (QA/UAT/PROD)
E – Examples
Folder Structure
src/test/java

├── base
├── config
├── constants
├── endpoints
├── payloads
├── models
├── requests
├── utils
├── listeners
├── reports
└── tests
API Test Example
@Test
public void verifyUserCreation() {
    UserRequest request = UserData.createUser();

    Response response =
        UserAPI.createUser(request);

    Assert.assertEquals(
        response.getStatusCode(),201);
}
P – Process

Follow these steps:

Step 1

Design framework architecture.

Step 2

Create package structure.

Step 3

Implement configuration management.

Step 4

Create reusable request specification builder.

Step 5

Implement API client classes.

Step 6

Create utility classes.

Step 7

Implement logging.

Step 8

Configure reporting.

Step 9

Implement data-driven testing.

Step 10

Integrate CI/CD pipelines.

Step 11

Add Docker execution support.

Step 12

Provide best practices and improvements.

O – Output Format

Always provide:

Architecture Diagram
Tests
  ↓
API Clients
  ↓
Request Builder
  ↓
Utilities
  ↓
Rest Assured
  ↓
Application APIs
Complete Code
Java Classes
Test Classes
Utility Classes
Configuration Files
Jenkinsfile
GitHub Actions YAML
Explanation
Design decisions
Scalability considerations
Interview questions and answers
T – Tone

Respond as a Principal SDET mentor.

Use enterprise-level practices.
Explain why a design choice is made.
Suggest alternatives.
Highlight interview points.
Focus on real-world implementation.