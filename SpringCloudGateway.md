# **Spring Cloud Gateway with Eureka Service Registry in Spring Boot 3**  

## **1. Introduction**  
In a **microservices architecture**, managing multiple services efficiently is crucial. **Spring Cloud Gateway** acts as an API gateway, providing routing, security, and load balancing. When combined with **Eureka Service Registry**, it enables **dynamic service discovery**, allowing requests to be routed without hardcoding service locations.  

### 🔹 **Key Components:**
- **Spring Cloud Gateway** → Handles **routing**, **filtering**, **authentication**, and **rate limiting**.  
- **Eureka Service Registry** → Allows microservices to **register** themselves and discover each other **dynamically**.  

---

## **2. Why Use Spring Cloud Gateway?**  
✅ **Dynamic Routing:** Routes traffic to registered services dynamically.  
✅ **Load Balancing:** Distributes requests across service instances.  
✅ **Security:** Centralized authentication and authorization.  
✅ **API Gateway Features:** Caching, rate limiting, logging, and monitoring.  
✅ **Microservices-Friendly:** Works with **Spring Boot 3** and **Spring Cloud**.  

---

## **3. Project Setup**  
### **1️⃣ Add Dependencies in `pom.xml`**  
```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Cloud Gateway -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>

    <!-- Eureka Client -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>

    <!-- Actuator for monitoring -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
</dependencies>
```
🔹 **Spring Boot 3 Compatibility:** Ensure you are using **Spring Cloud 2022.0.x (Kilburn)** or newer.

---

## **4. Configure Eureka Server**  
Before configuring **Spring Cloud Gateway**, ensure your **Eureka Server** is running.

### **Eureka Server Configuration (`application.yml`)**  
```yaml
server:
  port: 8761

eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
```
👉 Run the Eureka Server on **port 8761**.

---

## **5. Configure Spring Cloud Gateway with Eureka**  
### **Gateway Service Configuration (`application.yml`)**  
```yaml
server:
  port: 8080  # Gateway runs on port 8080

spring:
  application:
    name: api-gateway
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true  # Enables dynamic routing via Eureka
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
          filters:
            - AddRequestHeader=X-Request-Gateway, SpringCloudGateway
        - id: order-service
          uri: lb://ORDER-SERVICE
          predicates:
            - Path=/orders/**

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
### **Explanation:**
🔹 `lb://USER-SERVICE` → Routes requests to **User Service** dynamically via **Eureka Load Balancer**.  
🔹 `lb://ORDER-SERVICE` → Routes requests to **Order Service** dynamically.  
🔹 `Path=/users/**` → Any request starting with `/users/` is routed to `USER-SERVICE`.  
🔹 `filters` → Adds **custom headers** to track requests.  
🔹 `discovery.locator.enabled=true` → Allows dynamic service discovery without manually defining routes.  

---

## **6. Configure Microservices (`User Service` & `Order Service`)**  
Each microservice needs to be registered with Eureka.  

### **User Service (`application.yml`)**
```yaml
server:
  port: 8081

spring:
  application:
    name: USER-SERVICE

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
✅ This service will be dynamically discoverable by **Spring Cloud Gateway**.

---

### **Order Service (`application.yml`)**
```yaml
server:
  port: 8082

spring:
  application:
    name: ORDER-SERVICE

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```
✅ This ensures **Order Service** is also discoverable.

---

## **7. Testing the Setup**  

### **1️⃣ Start Services in Order**  
1️⃣ **Start Eureka Server** (`EurekaServerApplication.java`)  
2️⃣ **Start User Service** (`UserServiceApplication.java`)  
3️⃣ **Start Order Service** (`OrderServiceApplication.java`)  
4️⃣ **Start API Gateway** (`ApiGatewayApplication.java`)  

### **2️⃣ Verify Service Registration**  
- Visit **http://localhost:8761/**  
- You should see **USER-SERVICE** and **ORDER-SERVICE** registered.

### **3️⃣ Test Routing Through API Gateway**  
#### ✅ **Test User Service (via API Gateway)**
```sh
curl http://localhost:8080/users/1
```
Internally, this request gets **routed to USER-SERVICE (port 8081)**.

#### ✅ **Test Order Service (via API Gateway)**
```sh
curl http://localhost:8080/orders/100
```
Internally, this request gets **routed to ORDER-SERVICE (port 8082)**.

---

## **8. Advanced Features**  

### **1️⃣ Load Balancing Between Multiple Instances**  
If multiple instances of **USER-SERVICE** run on different ports, Spring Cloud Gateway will distribute traffic evenly.

### **2️⃣ Rate Limiting with Resilience4j**
To prevent API abuse:
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
          filters:
            - name: RequestRateLimiter
              args:
                redis-rate-limiter.replenishRate: 5
                redis-rate-limiter.burstCapacity: 10
```

### **3️⃣ Circuit Breaker for Fault Tolerance**
Use **Resilience4j Circuit Breaker** to handle failures:
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
          filters:
            - name: CircuitBreaker
              args:
                name: userServiceCircuitBreaker
                fallbackUri: forward:/fallback
```
✅ If `USER-SERVICE` fails, requests are routed to **fallback**.

---

## **9. Conclusion**  
Spring Cloud Gateway with Eureka **simplifies routing, service discovery, and load balancing** in microservices. It provides:  
✅ **Dynamic routing** via Eureka  
✅ **Load balancing** without hardcoded URLs  
✅ **API Gateway functionalities** (filtering, authentication, monitoring)  
✅ **Scalability** with multiple service instances  

🔥 **Next Steps:**  
- Add **security** with **Spring Security & OAuth2**  
- Implement **Global Filters** for logging requests  
- Use **Resilience4j** for better fault tolerance  

Would you like me to add **Spring Security** to this setup? 🚀
