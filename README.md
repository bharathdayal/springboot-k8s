# Spring Boot v3.4.2 -  on Kubernetes(K8s)

## 1. Build the Spring Boot Application
First, ensure you have a Spring Boot application ready. If you don't have one, you can create a simple Spring Boot application using Spring Initializr.

![image](https://github.com/user-attachments/assets/16cd5fbc-33c4-4233-903b-98251c44568c)


![image](https://github.com/user-attachments/assets/e457e1e1-bf61-4fea-bef7-a7ff579a2cb7)





Make sure that your application.properties or application.yml is configured as needed.
## 2. Containerize the Spring Boot Application
To run a Spring Boot app on Kubernetes, you need to package it into a Docker container

FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]


#### 2.1. Create a Dockerfile -Create a Dockerfile in your project’s root directory:






#### 2.2. Build the Docker Image
Run the following command to build the Docker image:
```yaml
docker build -f Dockerfile.dockerfile -t bharathdayal/demok8s .
```

## 3. Push the Docker Image to a Container Registry
You will need to upload the Docker image to a registry (like Docker Hub, Google Container Registry, or AWS ECR).
For Docker Hub:  
```yaml
docker push  bharathdayal/demok8s
```

![image](https://github.com/user-attachments/assets/9fb33b15-d0be-432a-9c41-66d176c386d0)

 


### 4. Create Kubernetes Configuration Files
Next, create Kubernetes configuration files to deploy your Spring Boot application.
#### 4.1. k8s-db-YAML (MYSQL)
This YAML defines a Kubernetes database(MySql) for your application.


#### 4.2. k8s-app-YAML
This YAML defines a Kubernetes deployment and service for your application.

### 5. Deploy to Kubernetes
Once you have your configuration files ready, deploy your Spring Boot application to your Kubernetes cluster.
#### 5.1. Apply the Deployment and Service YAML
Run the following commands to apply the configurations

```yaml
kubectl apply -f k8s-db.yaml
```


check mysql connection
```yaml
kubectl exec -it mysql-556f8d75b7-ljwwz -- /bin/bash
```
 ![image](https://github.com/user-attachments/assets/230bee9f-6282-49d4-8b0b-1b1759979096)


```yaml
kubectl apply -f k8s-app.yaml
```

![image](https://github.com/user-attachments/assets/4d55fc55-bb7b-4bcd-875b-c69d5a379413)

 
#### 5.2. Verify the Deployment
Check the status of your pods:
```yaml
kubectl get pods
```
 ![image](https://github.com/user-attachments/assets/c08f01cb-d45e-4d10-900e-b7e385659618)

You should see the pods running for your application.
#### 5.3. Verify the service
If you’ve used the LoadBalancer type for the service, Kubernetes will provision an external IP for you. You can check the external IP by running:
 	`kubectl get services`

  ![image](https://github.com/user-attachments/assets/757e21cc-7b9a-4a84-8439-f48518a7eaa4)

 
### 6. Scaling and Managing the Application
You can scale your application by modifying the replicas in the deployment YAML or by using the following command:
kubectl scale deployment spring-boot-k8s-demo --replicas=3
### 7. Monitor Logs and Debug
To view logs from your Spring Boot application, use the following command:
```yaml
kubectl logs <pod-name>
```
If you want to tail the logs of a specific pod:
```yaml
kubectl logs -f <pod-name>
```
### 8. Access the application 
#### 8.1 Minikube Dashboard	
	minikube dashboard
	 
 ![image](https://github.com/user-attachments/assets/bdb0da34-7d41-4293-b055-f4b6481cd114)

 ![image](https://github.com/user-attachments/assets/484263b0-d5ff-471f-9849-ef25bbbd2ba4)

 ![image](https://github.com/user-attachments/assets/508980b0-aa59-43e4-95e8-613d08d894f5)

 ![image](https://github.com/user-attachments/assets/1c7e0a26-3fd4-472c-b813-2ba58e0b5da9)

 ![image](https://github.com/user-attachments/assets/cbd472c1-fc30-404c-8bc6-b6e52c018a59)




 

 
#### 8.2  Service Test – Get the service URL 
```yaml
minikube service springboot-k8s-svc --url
```
 ![image](https://github.com/user-attachments/assets/5d974dd0-9f86-4bb7-8cfa-1bdd844460a6)

 ![image](https://github.com/user-attachments/assets/1ef9c7dd-d75d-4e4e-8cba-23d3fc19afc2)

 ![image](https://github.com/user-attachments/assets/df4d646d-afa8-4a95-a742-0c9b5ab774e0)



 
 
### 9. Enable Health Checks (Optional)
It's a good practice to add health checks (liveness and readiness probes) to your Kubernetes configuration to ensure that your app is running smoothly.
You can add the following to your deployment.yaml file:
```yaml
containers:
        - name: spring-boot-k8s-demo
          image: <your-docker-username>/spring-boot-k8s-demo:v1
          ports:
            - containerPort: 8080
          livenessProbe:
            httpGet:
              path: /actuator/health
              port: 8080
            initialDelaySeconds: 5
            periodSeconds: 10
          readinessProbe:
            httpGet:
              path: /actuator/health
              port: 8080
            initialDelaySeconds: 5
            periodSeconds: 10
```

Ensure that the Spring Boot actuator dependency is added to your project for health checks:
xml
Copy
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
### 9. Conclusion
You now have a Spring Boot 3.4.2 application running on Kubernetes. With this setup, you can scale, manage, and monitor your Spring Boot microservice efficiently using Kubernetes.

