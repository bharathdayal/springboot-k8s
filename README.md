# Spring Boot v3.4.2 -  on Kubernetes(K8s)

## 1. Build the Spring Boot Application
First, ensure you have a Spring Boot application ready. If you don't have one, you can create a simple Spring Boot application using Spring Initializr.




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
 

```yaml
kubectl apply -f k8s-app.yaml
```
 
#### 5.2. Verify the Deployment
Check the status of your pods:
```yaml
kubectl get pods
```
 
You should see the pods running for your application.
#### 5.3. Access the Application
If you’ve used the LoadBalancer type for the service, Kubernetes will provision an external IP for you. You can check the external IP by running:
 	`kubectl get services`
 
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
#### 8.1 Minikube Dashboard	8.1 Minikube Dashboard
	minikube dashboard
	 
 
 
 
 
#### 8.2  Service Test – Get the service URL 
```yaml
minikube service springboot-k8s-svc --url
```
 
 
 
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

