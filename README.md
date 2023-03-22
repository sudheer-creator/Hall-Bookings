In this project we are making a spring boot application which is used to complete the following tasks. 

Task-1. Fetch available halls for a particular time
Task-2. Book the hall using the Hall ID received from Step 1
Task-3. Fetch all the booked records from Database for a date range
Task-4. Book multiple halls in a single request (Step 1 and Step 2 both will be used here).

# Inupt and output format should be in json only . 

# We are now giving the format for running all the tasks 
- Under the postman select the post request . Go to headers and check the key as content type and value as application/json. And give the input under the body tag and then send the request at a below addresss for all the different inputs which are given below after running the appliaction App.java. 

# Task1 Input (localhost:8080/task1)
{"startDate":"02-06-2021 15:30:00","endDate":"02-06-2021 16:30:00","capacity":"100"}

# Task2 Input (localhost:8080/task2)
{"startDate":"02-06-2021 15:30:00","endDate":"02-06-2021 16:30:00", "capacity":"100","hallName":"Hall B"}

# Task3 Input (localhost:8080/task3)
{"startDate":"02-06-2021 15:30:00","endDate":"02-06-2021 16:30:00"}

# Task4 Input (localhost:8080/task3)
{"bookings":
[{"startDate":"02-06-2021 15:30:00","endDate":"02-06-2021 16:30:00", "capacity":"100", "hallName":"Hall B"},
{"startDate":"02-06-2021 15:30:00","endDate":"02-06-2021 16:30:00", "capacity":"100", "hallName":"Hall C"},
{"startDate":"02-06-2021 15:30:00","endDate":"02-06-2021 16:30:00", "capacity":"100", "hallName":"Hall D"},
{"startDate":"02-06-2021 15:30:00","endDate":"02-06-2021 16:30:00", "capacity":"100", "hallName":"Hall E"}]
}