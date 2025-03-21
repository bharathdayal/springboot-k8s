# Spring Boot v3.4.2 -  on Kubernetes(K8s)

## 1. Build the Spring Boot Application
First, ensure you have a Spring Boot application ready. If you don't have one, you can create a simple Spring Boot application using Spring Initializr.

![image](https://github.com/user-attachments/assets/fba9921d-56f9-4d63-bedf-33cd21853b8a)

![image](https://github.com/user-attachments/assets/907b177f-efdf-4a19-9b27-43767d7b67ed)




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


 ![image](https://github.com/user-attachments/assets/81e35ca8-811c-4f42-ac25-deb281c5cf28)
 



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

![image](https://github.com/user-attachments/assets/f8acfb26-cd3e-46d1-b149-c5039f58d46c)



```yaml
kubectl apply -f k8s-app.yaml
```

![image](https://github.com/user-attachments/assets/44268845-a813-47f3-bbaa-fe1c44fc9eb4)



 
#### 5.2. Verify the Deployment
Check the status of your pods:
```yaml
kubectl get pods
```
 
You should see the pods running for your application.
#### 5.3. Access the Application
If you’ve used the LoadBalancer type for the service, Kubernetes will provision an external IP for you. You can check the external IP by running:
 	`kubectl get services`

  ![image](https://github.com/user-attachments/assets/8112290b-c356-44c9-8d16-811152c85b92)

  

 
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
### 8. Check the application 
#### 8.1 Minikube Dashboard
	minikube dashboard
 
 ![image](https://github.com/user-attachments/assets/e7ef797f-61f8-40c5-8cdb-8987f0ea52ea)
 
 ![image](https://github.com/user-attachments/assets/0337e370-0c26-4a62-b7c0-dcfa431ef801)

 ![image](https://github.com/user-attachments/assets/0059e4f7-8ee8-46c0-bffd-13caaa5c20c3) 

 ![image](https://github.com/user-attachments/assets/c90c45c0-8030-449d-a888-7f12d3041357)

 ![image](https://github.com/user-attachments/assets/90e30a26-6733-4a16-9a77-bd62f9ab3bff)

 

#### 8.2  Service Test – Get the service URL 
```yaml
minikube service springboot-k8s-svc --url
```

![image](https://github.com/user-attachments/assets/9f3661a6-42ff-4fbc-96ba-e792c57110bf)

![image](https://github.com/user-attachments/assets/9ed25b76-f623-4977-a9cf-464aa809e1dc)

![image](https://github.com/user-attachments/assets/8c5afa17-2a08-4304-a11b-c71d1de393bd)





 
 
 
### 9. Enable Health Checks (Optional)
It's a good practice to add health checks (liveness and readiness probes) to your Kubernetes configuration to ensure that your app is running smoothly.
You can add the following to your deployment.yaml file:
yaml
Copy
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
Ensure that the Spring Boot actuator dependency is added to your project for health checks:
xml
Copy
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
### 9. Conclusion
You now have a Spring Boot 3.4.2 application running on Kubernetes. With this setup, you can scale, manage, and monitor your Spring Boot microservice efficiently using Kubernetes.

