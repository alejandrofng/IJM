package com.IJM.clientcontroller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IJM.model.Category;
import com.IJM.model.Image;
import com.IJM.model.Product;
import com.IJM.service.CategoryService;
import com.IJM.service.ProductService;

@Controller
@RequestMapping("/productos")
public class ProductClientController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	private static final String EXTERNAL_FILE_PATH="C:/IJM/Images/Product/";

	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewAll()
	{
		List<Product> products = productService.findAllProducts();
		List<Category> categories = categoryService.findAllCategories();
		ModelAndView model = new ModelAndView("/product/view");
		model.addObject("products",products);
		model.addObject("categories",categories);
		return model;
	}
	
	@RequestMapping(value="/download/{code}/{type}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response,@PathVariable("code") String code, @PathVariable("type") String type) throws IOException {
     
        File file;
        String path="";
        if(productService.isProductExist(code))
        {
        	Product product = productService.findProductByCode(code);
        	Set<Image> images = product.getImages();
        	if(!images.isEmpty())
        	{
	        	for(Image image:images)
	        	{
	        		path=EXTERNAL_FILE_PATH+code+"/"+type+"/"+code+"-"+image.getChecksum()+"."+image.getExtension();
	        	}
        	}
	        file = new File(path);
	         
	        if(!file.exists()){
	            String errorMessage = "Sorry. The file you are looking for does not exist";
	            System.out.println(errorMessage);
	            OutputStream outputStream = response.getOutputStream();
	            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
	            outputStream.close();
	            return;
	        }
	         
	        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
	        if(mimeType==null){
	            System.out.println("mimetype is not detectable, will take default");
	            mimeType = "application/octet-stream";
	        }
	         
	        System.out.println("mimetype : "+mimeType);
	         
	        response.setContentType(mimeType);
	         
	        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
	            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
	        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
	 
	         
	        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
	        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	         
	        response.setContentLength((int)file.length());
	 
	        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	 
	        //Copy bytes from source to destination(outputstream in this example), closes both streams.
	        FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }
 
}
