package kesmarki.personapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import kesmarki.personapp.dto.PersonDTO;
import kesmarki.personapp.exceptions.WrongInputException;
import kesmarki.personapp.services.PersonService;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

		@Mock
		private PersonService personService;

		@InjectMocks
		private PersonController personController;

		@Test
		void testGetEveryBody() {
			// Mocking data
			List<PersonDTO> mockPersons = Arrays.asList(
					new PersonDTO(1L, "Smith", "Adam", 1L),
					new PersonDTO(2L, "Eckhart", "Aaron", 2L), 
					new PersonDTO(3L, "Pierce", "Maggie", 3L)
			);

			// Mocking service behavior
			Mockito.when(personService.getEverybody()).thenReturn(mockPersons);

			// Calling the controller method
			ResponseEntity<List<PersonDTO>> responseEntity = personController.getEverybody();

			// Assertions
			assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
			assertNotNull(responseEntity.getBody());
			assertEquals(3, responseEntity.getBody().size()); // Verify the expected size of the response body
			assertTrue(responseEntity.getBody().get(0).getFirstName() == "Adam");
		}

		@Test
		void testGetPersonById() throws WrongInputException {
			PersonDTO mockPersonDTO = new PersonDTO(1L, "Smith", "Adam", 1L);

			Mockito.when(personService.getPersonById(1L)).thenReturn(mockPersonDTO);

			ResponseEntity<PersonDTO> response = personController.getPerson(1L);

			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertNotNull(response.getBody());
			assertEquals(mockPersonDTO, response.getBody());
			assertEquals("Adam", response.getBody().getFirstName());

		}

		@Test
		void testGetPersonByWrongIdThrowsException() throws WrongInputException {
			Mockito.when(personService.getPersonById(2L)).thenThrow(new WrongInputException("Id does not exist."));

			// with exception object
			ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> {
				personController.getPerson(2L);
			});

			assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusCode());

		}

		@Test
		void testDeletePersonByIdSuccess() {
			Mockito.doNothing().when(personService).deletePersonById(1L);
			ResponseEntity<String> response = personController.deletePersonById(1L);

			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertEquals("Person 1 deleted.", response.getBody());
		}

		@Test
		void testDeletePersonByIdFailures() {
			Mockito.doThrow(new NoSuchElementException()).when(personService).deletePersonById(1L);

			ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> {
				personController.deletePersonById(1L);
			});

			assertEquals(HttpStatus.BAD_REQUEST, ex.getStatusCode());
		}
	}