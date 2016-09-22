1. create database and Import appdirect.sql

2. create access_token to access appdirectsm using below urls
	- access_token	1.  http://localhost:8080/appdirectsm/oauth/token?grant_type=password&client_id=appdirect&client_secret=secret&username=appdirect&password=manoj@1234
	- refres_token  2.  http://localhost:8080/appdirectsm/oauth/token?grant_type=refresh_token&client_id=appdirect&client_secret=secret&refresh_token=7ac7940a-d29d-4a4c-9a47-25a2167c8c49"
	
3. For Local CRUD

	- 1. Create URL http://localhost:8080/appdirectsm/api/subscription/create?access_token=27639d05-761f-4220-8285-a09fbac85f80
			Method POST
			Content Type application/json
			Request Body : {
							"request": {
								"transDate": "2016-09-22",
								"updateon": "2016-09-22",
								"userAction": 1,
								"transStatus": 1,
								"productPrice": 10000,
								"chargePrice": 9000,
								"mode": "WEB",
								"serviceName": "SELL",
								"channelName": "WEB",
								"segment": "Paid User"
							}
						}
		- 2. Update URL http://localhost:8080/appdirectsm/api/subscription/update?access_token=27639d05-761f-4220-8285-a09fbac85f80
			Method PUT
			Content Type application/json
			Request Body : {
							"request": {
								"transactionid": "58fa28dd69a54187a79574a9dda40e67",
								"transDate": "2016-09-22",
								"updateon": "2016-09-22",
								"userAction": 1,
								"transStatus": 1,
								"productPrice": 10000,
								"chargePrice": 9000,
								"mode": "WEB",
								"serviceName": "SELL",
								"channelName": "WEB",
								"segment": "Paid User"
							}
						}		
						
		- 3. Cancel URL http://localhost:8080/appdirectsm/api/subscription/cancel/{transactionId}?access_token=27639d05-761f-4220-8285-a09fbac85f80
			Method DELETE
			
		- 4 Get URL http://localhost:8080/appdirectsm/api/subscription/get/{transactionId}?access_token=55a99e14-1352-4e7f-adc7-40933cbb337b
			Mehtod GET
			Response :- 
				{
				  "transactionid": "58fa28dd69a54187a79574a9dda40e67",
				  "transDate": "2016-09-22",
				  "updateon": "2016-09-22",
				  "userAction": 1,
				  "transStatus": 5,
				  "productPrice": 0,
				  "chargePrice": 0,
				  "mode": "WEB",
				  "serviceName": "SELL",
				  "channelName": "WEB",
				  "segment": "Free User"
				}
				
4. AppDirect APIs URLs for create and cancel

	1. http://localhost:8080/appdirectsm/appdirect/subscription/create?access_token=475ce502-e542-4170-a40a-07158d424d63&url=https:%2F%2Fwww.appdirect.com%2Fapi%2Fbilling%2Fv1%2Fcompanies%2Fa012bb88-c2c5-40a1-b140-ec6ed4593b78%2Fusers%2F3d4d2342-b7c4-4865-85bd-842f269adae6%2Fsubscriptions&token=VeJO1tP7RKUE1rz
	
	2. http://localhost:8080/appdirectsm/appdirect/subscription/cancel?access_token=475ce502-e542-4170-a40a-07158d424d63&url=https:%2F%2Fwww.appdirect.com%2Fapi%2Fbilling%2Fv1%2Fcompanies%2Fa012bb88-c2c5-40a1-b140-ec6ed4593b78%2Fusers%2F3d4d2342-b7c4-4865-85bd-842f269adae6%2Fsubscriptions&token=VeJO1tP7RKUE1rz				
												