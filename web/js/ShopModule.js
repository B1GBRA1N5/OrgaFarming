var documentsArr = [];
var cartIndexes=[];
var cost=0;
cartItems={0:''};
var ShopModule = angular.module('ShopModule', []);  
ShopModule.controller('ShopController', ['$scope', '$http', function ($scope, $http ) {  
	
	  $scope.addProduct=function(formData){
		  	formData.base64String=documentsArr[0].base64String;    
		  	formData.fileName=documentsArr[0].fileName;
			$http.post('/orga/product/addProduct',formData).then(function(response){
				if(response.data.successful){	
						alert("Product Added !!");
						Andromeda.showAddProducts();
				}
				else{
					alert({
						title	:	"ERROR",
						text	:	"Product Not Added"
					});
					$scope.formData = {object : formData};
				}		  
			});
	  }
	  
	  
	  $scope.addToCart=function(itemIndex){
		 cartIndexes.push(itemIndex);
		 cost=parseInt(cost)+parseInt($scope.products[itemIndex].p_cost);
		 document.getElementById('totalcost').innerHTML=cost;
		 console.log(cartIndexes);
		 console.log(cost);
		
		 $.each($scope.products , function(index, val) { 
			 if (index in cartIndexes){
				 cartItems[index]=$scope.products[index];
				 $scope.cartData=cartItems;
			  	console.log(index, val);
			  	console.log($scope.cartData)
			 }
			});
	  };
	  
	  $scope.removeItem=function(itemIndex){
		  cartIndexes.splice(cartIndexes.indexOf(itemIndex))
		 cost=parseInt(cost)-parseInt($scope.products[itemIndex].p_cost);
		 document.getElementById('totalcost').innerHTML=cost;
		 $.each($scope.products , function(index, val) { 
			 if (index in cartIndexes){
				 cartItems[index]=val;
				 $scope.cartData=cartItems;
			 }
			 console.log(index, val);
			  	console.log($scope.cartData)
			  	console.log('CInd:',cartIndexes)
			});
	  };
	  
	  
	  
	  

	$http.post('/orga/product/getProducts').then(function(response) {
			if (response.data.successful) {
				//console.log(response.data.responseObject);
				$scope.products = response.data.responseObject;
			} else {
				alert("Can't view the Data");
			}
		}, function(errResponse) {
			console.error('Error while viewing notes');
		});
	
	
	$scope.uploadFiles = function(e)  
    {
        var k= 0;
        for(var i =0;	i < e.files.length; i++)
        {
            var singleFileInfo = e.files[i];
            (function(singleFileInfo)
            {
                var fileReader;
                fileReader = new FileReader();
                fileReader.onload = function(e)
                {
                    var fileName1 = singleFileInfo.name;
                    filesize =  singleFileInfo.size;
                    var fileDetails=fileName1.split(".");
                    var fileName = fileDetails[1];
                    var binaryString =  e.target.result;
                    var base64 = btoa(binaryString);                     
                    var fileModel =
                        {   
                            fileName		: fileName,
                            base64String	: base64.toString(),
                            name			: fileName
                        };
                     documentsArr[k] = fileModel;
                    k++;
                };
                fileReader.readAsBinaryString(e.files[i]);
            })(singleFileInfo);
        }    

    }    
}]);
 