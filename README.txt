
# Medical Appointment Booking System

A system to manage medical appointments, built with Spring Boot and Vue.js.

## Features

- Create a new appointment
- View details of an appointment
- List all appointments
- Cancel an appointment

## Installation

### Prerequisites

- Java 17+
- Maven
- Node.js and npm
- MySQL

### Backend Setup

1. Clone the repository and navigate to the backend directory:

   ```bash
   git clone <repository-url>
   cd appointment-system/appointmentSystem
   ```

2. Create a MySQL database named `appointment_db` and update `src/main/resources/application.properties`:


CREATE TABLE appointments_db.appointment (
    id BIGINT NOT NULL AUTO_INCREMENT,
    patient_name VARCHAR(255) NOT NULL,
    doctor_name VARCHAR(255) NOT NULL,
    date VARCHAR(255) NOT NULL,
    time VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);


   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/appointment_db
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run the backend:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend Setup

1. Navigate to the frontend directory:

   ```bash
   cd ../appointment-system
   ```

2. Install dependencies and run the frontend:

   ```bash
   npm install
   npm run serve
   ```

## Usage

1. Open your browser and go to `http://localhost:8081`.
2. Use the interface to manage appointments.

## Technologies Used

- Spring Boot
- Vue.js
- MySQL
- Element UI
- Axios

