
var Registration = angular.module('RegistrationModule', []);
Registration.controller('RegistrationController', ['$http','$scope', function($http, $scope) {
	
			     
			   		        
		$http.post('/orga/register/getReviews').then(function(response) {
				$scope.reviews = response.data;
				if ($scope.reviews.successful) {
					$scope.review = $scope.reviews.responseObject;
				} else {
					alert("Can't view the Data");            
				}
			}, function(errResponse) {
				console.error('Error while viewing notes');
			});
			
			$scope.registration = function(data){
				 
				 if(data != undefined)
					{
						if(data.fname == null || data.fname == undefined || data.fname == "")
						{
							alert(" Enter first name");
						}
						else if(data.lname == null || data.lname == undefined || data.lname == "")
						{
							alert(" Enter last name");
						}
						else if(data.mail == null || data.mail == undefined || data.mail == "")
						{
							alert(" Enter email ID");
						}
						else if(data.aadhaar == null || data.aadhaar == undefined || data.aadhaar == "")
						{
							alert(" Enter aadhaar number");
						}
						else if(data.username == null || data.username == undefined || data.username == "")
						{
							alert(" Enter user name");
						}
				
						else if(data.password == null || data.password == undefined || data.password == "")
						{
							  alert(" Enter password");
						}
						
						else if(data.confirmpassword == null || data.confirmpassword == undefined || data.confirmpassword == "")
						{
						  alert(" Please confirm your password");
						}
						else if(data.type == null || data.type == undefined || data.type == "") {
						  alert(" Select your type");
						}
						 
						else
						{
				 
							 alert("Please wait a while for completing the process ");
					  /*console.log(data);*/
					  
					  $http.post('/orga/user/add',data).then(function(response)
								{
			
						  $scope.data = response.data;
							if($scope.data.successful)
							{
								
								alert("Thank you for registering.. Please check your mail. ");
								
						}
							else
							{
								alert("User with this mail has already registered");
									
							
								$scope.data = {object : data};
							}
						  
								});
						}
					}
					else
					{
						alert(" Fill all details");
					}
					  
				  };
				  
				  
				  
				  $scope.updateData = function(data){
						 
						 if(data != undefined)
							{
								if(data.fname == null || data.fname == undefined || data.fname == "")
								{
									alert(" Enter first name");
								}
								else if(data.lname == null || data.lname == undefined || data.lname == "")
								{
									alert(" Enter last name");
								}
								else if(data.mail == null || data.mail == undefined || data.mail == "")
								{
									alert(" Enter email ID");
								}
								
								else if(data.username == null || data.username == undefined || data.username == "")
								{
									alert(" Enter user name");
								}
						
								else if(data.password == null || data.password == undefined || data.password == "")
								{
									  alert(" Enter password");
								}
								
								
								else if(data.type == null || data.type == undefined || data.type == "") {
								  alert(" Select your type");
								}
								 
								else
								{
						 
									
									alert("Please wait a while for completing the process ");
							  
									/*console.log(data);*/
							  
							  $http.post('/orga/user/updateData',data).then(function(response)
										{
					
								  $scope.data = response.data;
									if($scope.data.successful)
									{
										
										alert("Profile Updated.. Please check your mail. ");
										
								}
									else
									{
										alert({
											title	:	" ",
											text	:	"Your subscription is already completed.For further registration you can use mail link"
										});
										$scope.data = {object : data};
									}
								  
										});
								}
							}
							else
							{
								alert(" Fill all details");
							}
							  
						  };
			
		
		} ]);

		
