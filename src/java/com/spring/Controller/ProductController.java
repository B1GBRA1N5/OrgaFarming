package com.spring.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;
import com.andromeda.commons.util.HttpUtils;
import com.spring.Model.User;
import com.spring.Model.Product;
import com.spring.Service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	String file = null;
	
	@ResponseBody
	@RequestMapping(value = "addProduct", method = { RequestMethod.POST })
	public Response addProduct(@RequestBody Product proModel)
	{
		handleFileUpload(proModel);
		proModel.setP_img(file);
		return productService.addProduct(proModel);
	}

@ResponseBody
@RequestMapping(value = "getProducts", method = { RequestMethod.POST, RequestMethod.GET })
public Response getProducts()
{
	return productService.getProducts();
}

public String handleFileUpload(Product product)
{
	
	FileOutputStream fos = null;    

	try
	{
		String folderName = "orga";
		String imageValue = product.getBase64String();
		byte[] imageByteArray = Base64.decode(imageValue);

		String baseDir = System.getProperty("catalina.base") + "/webapps/uploads/"+ folderName;
		File dir = new File(baseDir);
		if (!Files.isDirectory(Paths.get(baseDir)))
		{     
			dir.mkdirs();     
		}
		    
		fos = new FileOutputStream(baseDir + "/" + product.getP_name()+".jpg");
		file = "/../uploads/" + folderName + "/" +product.getP_name()+".jpg";
		fos.write(imageByteArray);
		fos.close();             

		System.out.println("---Path--> " + file);
	}
	catch (Exception e)
	{
		System.out.println("Exception: " + e.getMessage());
	} 
	return file.trim();
 }
}
