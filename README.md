# comcastLCS

#To Run Spring Boot Application use commans
mvn spring-boot:run


#To Run Spring Boot Application Test Cases use command
mvn test

#To check for the rest endpoint use after application started

curl --location --request POST 'http://localhost:8080/lcs/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "setOfStrings": [
        {
            "value": "comcast"
        },
        {
            "value": "comcastics"
        }
    ]
}'

Github Repo for the application is

