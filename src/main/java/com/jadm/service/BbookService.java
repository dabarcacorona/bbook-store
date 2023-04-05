package com.jadm.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import antlr.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jadm.model.BbookEnvioTda;
import com.jadm.model.JsonCab;
import com.jadm.model.JsonDet;
import com.jadm.repository.BbookEnvioTdaRepository;
import com.jadm.utilities.HttpUtilities;

@Service
@Transactional
public class BbookService {

	@Value("${api_url}")
	private String apiurl;

	@Value("${token_uri}")
	private String token;
	
	@Autowired
	BbookEnvioTdaRepository updsdirepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(BbookService.class);

	public void EnvioTienda(List<BbookEnvioTda> bbooktda, String tipo) {
		
		 Gson g = new Gson();
		 JsonCab jsoncab=null;
		 List<JsonDet> json=new ArrayList<>();
		 HttpEntity<String> entity=null;
		 
	 try{
	     for (BbookEnvioTda row : bbooktda) {
	            		 
           json.add(new JsonDet(String.valueOf(row.getOrgLvlNumber()), row.getOrgNameFull(), row.getInactive(), row.getIsWarehouse()));
	     } 
	     
	     //jsoncab = new JsonCab(g.toJson(json));  
	     jsoncab = new JsonCab(json);
	     
	       // create full entity.
	 	   HttpHeaders headers = new HttpHeaders();
	 	   headers.set("user-agent", "Application");
	 	   //headers.set("cache-control", "no-cache");
	 	   
	 	   headers.setContentType(MediaType.APPLICATION_JSON);
	 	   //headers.set("Authorization", "Bearer " + token);
	 	   headers.set("X-Bbook-Token",token);
	 	   //headers.set("Authorization", token);
 	    
    	   // create entity, headers + body
 		   entity = new HttpEntity<String>(g.toJson(jsoncab), headers);
	 	  // entity = new HttpEntity<String>(g.toJson("\"data\": [{\"id\":\"80\",\"name\":\"Recoleta\",\"inactive\":\"true\",\"is_warehouse\":\"false\"},{\"id\":\"71\",\"name\":\"Eccommerce\",\"inactive\":\"true\",\"is_warehouse\":\"false\"}]"), headers);
 		  
 		   
        }catch (Exception e) {
        	LOG.error("Error al cargar json", e);
        }
 	    String responses=null;
        try {
 		     responses = HttpUtilities.BulkUpdateApiPoster(entity, apiurl, tipo);
		}catch (Exception e) {
         	LOG.error("Error al enviar datos", e);
         
         	responses="No se pudo informar tienda";
         }
        
        for (BbookEnvioTda row : bbooktda) {
   		 
        	//updsdirepository.uopdSdiSdiOrgmst(row.getId(), responses.substring(1,500));
			updsdirepository.uopdSdiSdiOrgmst(row.getId());
 	     } 
   }
}
