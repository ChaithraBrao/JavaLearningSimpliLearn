package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductDao {

	
	@Autowired
	ProductRepo repo;
	//private final String FOLDER_PATH="E:\\img\\";
	//E:\img
	
	public Product insert(Product p)
	{
		
		return repo.save(p);
	}
	
	public List<Product> getall(){
		return repo.findAll();
	}
	
	public Product update(Product s) {
		
		Product pp=repo.findById(s.getId()).orElse(null);
        
		pp.setProductname(s.getProductname());
		return repo.save(pp);
		
	}
	
	//delete 
		public void deleteByid(int id) {
			repo.deleteById(id);
			
		}
		
//		public String uploadImage(MultipartFile file) throws IOException {
//			FileData data=new FileData();
//			String fileinfo=FOLDER_PATH+file.getOriginalFilename();
//			data.setName(file.getOriginalFilename());
//			data.setType(file.getContentType());
//			data.setFilePath(fileinfo);
//			FileData res=repo.save(data);
//			file.transferTo(new File(fileinfo));
//			if(res!=null) {
//			return	"file path is uploaded into the dB successfully.."+file.getOriginalFilename();
//			}
//			return null;
//		}


	
}

