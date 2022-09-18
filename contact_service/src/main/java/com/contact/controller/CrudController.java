package com.contact.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Crud;
import com.contact.service.CrudService;

@RestController
@RequestMapping("/crud")
public class CrudController
{
	CrudService crudService;

	public CrudController(CrudService crudService)
	{
		this.crudService = crudService;
	}

	@PostMapping("/create")
	public String createCrud(@RequestBody Crud crud) throws Exception{
		return crudService.createCrud(crud);
	}

	@GetMapping("/get")
	public Crud getCrud(@RequestParam String documentId) throws Exception{
		return crudService.getCrud(documentId);
	}

	@PutMapping("/update")
	public String updateCrud(@RequestBody Crud crud) throws Exception
	{
		return crudService.updateCrud(crud);
	}

	@DeleteMapping("/delete")
	public String deleteCrud(@RequestParam String documentId) throws Exception
	{
		return crudService.deleteCrud(documentId);
	}

	@GetMapping("/test")
	public ResponseEntity<String> getTestCheck(){
		return ResponseEntity.ok("test endpoint is working");
	}


}
