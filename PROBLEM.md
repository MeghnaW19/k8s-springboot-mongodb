## Exercise: Deploy a Spring Boot microservices application with MongoDB on a K8s Cluster

  
* In this Exercise, you will deploy a Spring Boot microservices application with MongoDB on K8s Cluster.  

This exercise contains the following:

	- user-service - A Spring Boot application
	- k8s-manifests - Contains manifest files
	
This exercise contains following files in k8s-manifestss folder:

	- mongodb.yml - To create persistent volume, persistent volume claim, deployment, and service of type ClusterIP for MongoDB.
	- userservice.yml - To create the deployment, service of type NodePort for user-service microservice.

Understand and perform the following steps to complete this exercise:
	
	1. Define `mongodb.yml' following the comments given in the file.
	2. Run command `kubectl apply -f mongodb.yml` to create mongodb PV, PVC, Deployment and Service.
	3. Modify the properties in `application.yml` of `user-service` following the comments given in the file.
	4. Push the docker image named `userservice-mongo` of user-service application to DockerHub.
	5. Define service of type NodePort and deployment in `userservice.yml' following the comments given in the file.
	6. Run command `kubectl describe service <service name>` and look up for NopePort.
	7. Open POSTMAN and hit the POST endpoint using `http://<minikube ip>:<nodeport>/api/v1/user` to save the user in database.
	8. Run command `kubectl exec -it <mongodb pod name> -- /bin/bash` to get inside the mongo container.
	- Run mongo commands and verify if the data is inserted in the `User` collection of the userDb` database.
	9. Open POSTMAN and hit the GET endpoint using `http://<minikube ip>:<nodeport>/api/v1/users` to get all users from the database.
	10. To test if the data is persisted:
		- Run command `kubectl delete pod -f <mongo pod name>` to delete the pod.
		- Run command `kubectl apply -f mongodb.yml` to re-create the mongo pod.
		- Enter into the mongo container and check if the data is persisted.


### Instructions

- Take care of whitespace/trailing whitespace
- Do not change the provided code unless instructed
- Ensure your code compiles without any errors/warning/deprecations
- Follow best practices while coding