# **Spring Profiles – Detailed Explanation**

## **1. Introduction**
Spring Profiles is a feature in **Spring Framework** that allows developers to define **different configurations** for different **environments** (e.g., development, testing, production).  

With **Spring Profiles**, you can activate a specific configuration based on the environment without changing the code manually.

---

## **2. Why Use Spring Profiles?**
In real-world applications, different environments have different configurations:
- **Development** → Uses an **H2 database**, enables debugging logs.
- **Testing** → Uses a **test database**, enables mock services.
- **Production** → Uses a **PostgreSQL database**, enables optimizations.

Instead of maintaining multiple configuration files and manually switching between them, **Spring Profiles** automate the process.

---

## **3. How to Use Spring Profiles?**
Spring Profiles can be used in three ways:
1. **Using `application.properties` or `application.yml`**
2. **Using `@Profile` annotation in Java classes**
3. **Setting active profiles via environment variables or command-line arguments**

---

## **4. Using Spring Profiles in `application.properties`**
You can create multiple `application-{profile}.properties` files for different environments.

### **Step 1: Create Profile-Specific Configuration Files**
#### **Development Profile (`application-dev.properties`)**
```properties
server.port=8081
spring.datasource.url=jdbc:h2:mem:devdb
spring.datasource.username=devuser
spring.datasource.password=devpass
```

#### **Testing Profile (`application-test.properties`)**
```properties
server.port=8082
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=testuser
spring.datasource.password=testpass
```

#### **Production Profile (`application-prod.properties`)**
```properties
server.port=8080
spring.datasource.url=jdbc:postgresql://prod-db-server:5432/mydb
spring.datasource.username=produser
spring.datasource.password=prodpass
```

---

### **Step 2: Activate a Profile**
To activate a profile, set the `spring.profiles.active` property.

#### **Option 1: In `application.properties`**
```properties
spring.profiles.active=dev
```

#### **Option 2: Using Command-Line Argument**
```sh
java -jar myapp.jar --spring.profiles.active=prod
```

#### **Option 3: Using Environment Variable**
```sh
export SPRING_PROFILES_ACTIVE=test
```

---

## **5. Using `@Profile` Annotation in Java Classes**
You can define beans that should only be created for a specific profile using `@Profile`.

### **Example: Profile-Specific Bean Configuration**
#### **Dev Configuration**
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public String dataSource() {
        return "Using Dev Database";
    }
}
```

#### **Prod Configuration**
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {

    @Bean
    public String dataSource() {
        return "Using Production Database";
    }
}
```

#### **Testing the Active Profile**
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private String dataSource;

    @GetMapping("/profile")
    public String getActiveProfile() {
        return "Active Profile: " + dataSource;
    }
}
```

If `spring.profiles.active=dev`, the output will be:
```
Active Profile: Using Dev Database
```

If `spring.profiles.active=prod`, the output will be:
```
Active Profile: Using Production Database
```

---

## **6. Setting Multiple Profiles**
You can specify multiple profiles:
```properties
spring.profiles.active=dev,test
```
Spring will **merge** the properties from both profiles.

---

## **7. Default Profile**
If no profile is specified, Spring uses the **default profile**.

You can define a default configuration in `application.properties`:
```properties
server.port=9090
spring.profiles.default=dev
```

---

## **8. Use Cases of Spring Profiles**
✅ **Environment-Specific Configuration** → Use different settings for dev, test, and prod.  
✅ **Feature Toggles** → Enable or disable features based on active profiles.  
✅ **Multi-Tenant Applications** → Configure different settings for different clients.  
✅ **Cloud Deployment** → Set profiles dynamically for AWS, GCP, or Azure environments.  

---

## **9. Conclusion**
Spring Profiles provide a **flexible way** to manage environment-specific configurations.  
By using profile-specific properties and `@Profile` annotations, you can switch between environments **effortlessly** without modifying the code. 🚀
