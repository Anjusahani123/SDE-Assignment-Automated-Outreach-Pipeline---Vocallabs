# Automated Outreach Pipeline

## Overview

This project implements an automated outreach pipeline using Java 17 and Spring Boot.

### Flow

User Domain
↓
Ocean Service
↓
Prospeo Service
↓
EazyReach Service
↓
Brevo Service
↓
Email Delivery

## Features

- Company Discovery
- Decision Maker Discovery
- Email Resolution
- Outreach Automation
- Duplicate Email Prevention
- Logging
- Exception Handling
- Execution Summary

## Tech Stack

- Java 17
- Spring Boot 3
- Maven
- Lombok

## Run

```bash
mvn spring-boot:run
```

## Sample Input

openai.com

## Sample Output

Companies Processed : 3
Emails Sent : 3
Pipeline Completed Successfully
