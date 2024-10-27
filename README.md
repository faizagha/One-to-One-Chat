# One-to-One Chat Application

A simple and efficient one-to-one chat application built using **Spring Boot** and **WebSocket**, allowing for real-time communication between users. The application persists chat history in a **MongoDB** database, ensuring that conversations are stored securely.

## Features

- **Real-Time Communication**: Utilizes WebSocket for seamless, real-time messaging.
- **Persistent Chat History**: Messages are stored in a MongoDB database, allowing users to retrieve previous conversations.
- **User Authentication**: Secure login mechanism to ensure that only authorized users can access the chat.
- **Responsive UI**: Designed with a user-friendly interface for an optimal experience across devices.

## Technologies Used

- **Backend**: Spring Boot 3.x.x
- **Database**: MongoDB
- **Frontend**: HTML, CSS, JavaScript
- **WebSocket**: For real-time messaging

## Installation

To set up the project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/faizagha/One-to-One-Chat.git
   ```

2. **Change into the project directory**:
   ```bash
   cd One-to-One-Chat
   ```

3. **Ensure that you have [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and [Maven](https://maven.apache.org/download.cgi) installed**.

4. **Set up MongoDB**:
   - Install MongoDB and run it on your local machine or use a cloud-based MongoDB service.
   - Update the MongoDB connection settings in the `application.properties` file if necessary.

5. **Build the project**:
   ```bash
   ./mvnw clean install
   ```

6. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

7. **Access the application**: Open your browser and go to `http://localhost:8080` to access the chat application.

## Usage

- Register a new user or log in if you already have an account.
- Start a conversation with another user by selecting them from the list of contacts.
- Send and receive messages in real-time.

## Contributing

Contributions are welcome! If you have suggestions or improvements, feel free to create a pull request or open an issue.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.

## Acknowledgments

- Inspired by the need for secure and private communication in the digital age.
- Thanks to the Spring Boot and MongoDB communities for their extensive documentation and support.
