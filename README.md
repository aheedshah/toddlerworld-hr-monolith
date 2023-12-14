Use this repo as below:

To start the docker container locally, run the following command:
```
docker-compose up
```

This will create a local dynamodb instance and start the docker on port 8000.
Use this to create tables and run queries locally. You can use AWS CLI or NoSQL Workbench to connect to this instance.

After the docker is up, run the `HrApplication.java` file to start the tomcat server on port 8080.

This should start the application as needed. To change code on the front-end, clone the aheedshah/toddlerworld-hr repo.