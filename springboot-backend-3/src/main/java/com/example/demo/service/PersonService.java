package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Person;

public interface PersonService {
  Person savePerson(Person person);
  List<Person> getPersons();
  Person getPersonById(int id);
  Person update(Person person,int id);
  void delete(int id);
}

