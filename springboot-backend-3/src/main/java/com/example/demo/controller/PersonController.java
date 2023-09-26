package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/api/persons1")
public class PersonController {

	private PersonService personService;
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
//Build Insert Person Rest Api
	@PostMapping()
	public ResponseEntity<Person> savePerson(@RequestBody Person person)
	{
		return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.CREATED);
	}

//	Bulid get All Person Api
	@GetMapping()
	public List<Person> getPersons()
	{
		return personService.getPersons();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Person> getPersonbyId(@PathVariable(name="id")int id)
	{
		return new ResponseEntity<Person>(personService.getPersonById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Person> update(@PathVariable(name="id")int id,@RequestBody Person person)
	{
		return new ResponseEntity<Person>(personService.update(person,id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable(name="id" )int id)
	{
		personService.delete(id);
		return new ResponseEntity<String>("Person deleted From Databse", HttpStatus.OK);
	}
	
}
