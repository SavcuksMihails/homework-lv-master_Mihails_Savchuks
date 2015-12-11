package io.fourfinanceit;

import java.util.Arrays;
import java.util.List;

import io.fourfinanceit.dto.Client;
import io.fourfinanceit.dto.LoanApplication;
import io.fourfinanceit.repositories.ClientRepository;
import io.fourfinanceit.ws.rest.controllers.BusinessController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomeworkApplicationTests {

	@InjectMocks
	BusinessController controller = new BusinessController();
	
	@Mock
	ClientRepository repository;
	
	@Mock
	Client client;
	
	@Mock
	LoanApplication application1, application2;
	
	@Test
	public void applyLoadToClient(){
		when(repository.findOne(1L)).thenReturn(client);
		when(client.getId()).thenReturn(1L);
		when(client.getLoanApplications()).thenReturn(Arrays.asList(application1, application2));
				
		List<LoanApplication> result = controller.getClientLoans(1l);
		
		assertTrue(result.size()==2);
		assertTrue(result.contains(application1));
		assertTrue(result.contains(application2));
		
	}

}
