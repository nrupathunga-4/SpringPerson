package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	 private PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	@Override
	public List<Person> getPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(int id) {
	  
		Optional<Person> person=personRepository.findById(id);
		if(person.isPresent())
		{
			return person.get();
		}
		else
		{
			throw new ResourceNotFoundException("Person", "id", id);
		}
	}

	@Override
	public Person update(Person person, int id) {
		
		Person existingperson=personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Person", "id", id));
		existingperson.setFirstname(person.getFirstname());
		existingperson.setLastname(person.getLastname());
		existingperson.setAge(person.getAge());
		
		personRepository.save(existingperson);
		return existingperson;
		
	}

	@Override
	public void delete(int id) {
		personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Person", "id", id));
		personRepository.deleteById(id);
	}
	 
}
