var validModle = angular.module('valid', []);
            
validModle.controller('mainController', ['$scope', '$http', function ($scope, $http ) {  
	
	  $scope.msg=function(formData){
				 if(formData != undefined)
					{
						if(formData.name == null || formData.name == undefined || formData.name == "")
						{
							alert(" Enter your name");
						}
						
						else if(formData.email == null || formData.email == undefined || formData.email == "")
						{
							alert(" Enter email ID");
						}
			
						else if(formData.review_text == null || formData.review_text == undefined || formData.review_text == "")
                         {
						  alert(" Please enter your response ");
						}
						 
						else
						{
				$http.post('/orga/register/add1',formData).then(function(response)
						{
					if(response.data.successful)
					{	
						alert("Thanks  for your FEEDBACK.. ");
						Andromeda.showContact();
				}
					else
					{
						alert({
							title	:	" ",
							text	:	"Your subscription is already completed.For further registration you can use mail link"
						});
						$scope.formData = {object : formData};
					}
				  
						});
				}
			}
			else
			{
				alert(" Fill all details");
			}
			  
		  };
	 
				
	$http.post('/orga/register/getReviews').then(function(response) {
			$scope.data = response.data;
			if ($scope.data.successful) {
				$scope.RegisterDetails = $scope.data.responseObject;
			} else {
				alert("Can't view the Data");
			}
		}, function(errResponse) {
			console.error('Error while viewing notes');
		});
}]);
