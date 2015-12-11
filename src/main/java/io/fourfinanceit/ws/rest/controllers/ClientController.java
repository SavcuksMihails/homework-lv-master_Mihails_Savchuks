package io.fourfinanceit.ws.rest.controllers;

import io.fourfinanceit.dto.Client;
import io.fourfinanceit.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping
	public Iterable<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	// Add new client to Client table
	@RequestMapping(value = "/addClient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Client addClient(@RequestBody Client client) {
		return clientRepository.save(client);
	}
	
	// Get one particular client
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Client getOnlyById(@PathVariable Long id) {
		return clientRepository.findOne(id);
	}
	
	// Delete one particular client
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteOneCandyById(@PathVariable Long id) {
		clientRepository.delete(id);
	}
}
