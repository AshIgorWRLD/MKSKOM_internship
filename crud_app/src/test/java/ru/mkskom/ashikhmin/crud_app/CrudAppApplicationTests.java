package ru.mkskom.ashikhmin.crud_app;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.mkskom.ashikhmin.crud_app.controller.PersonController;
import ru.mkskom.ashikhmin.crud_app.domain.Person;
import ru.mkskom.ashikhmin.crud_app.repo.PersonRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(PersonController.class)
class CrudAppApplicationTests {

	@MockBean
	private PersonRepo personRepo;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private MockMvc mockMvc;

	@Before("")
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(personRepo).build();
	}

	@Test
	void shouldCreateMockMvc() {
		assertNotNull(mockMvc);
	}

	@Test
	void shouldReturnListOfPeople() throws Exception {
		when(personRepo.findAll()).thenReturn(List.of(
				new Person("Weekend", "Week123", "kendrick123"),
				new Person("Igor", "igash888", "sadfsad325"),
				new Person("Tanya", "tanyad2702", "qwer12wqe"),
				new Person("Alexander", "Salex2608", "gavrusha12")));

		this.mockMvc
				.perform(MockMvcRequestBuilders
						.get("/people"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()",
						Matchers.is(4)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name",
						Matchers.is("Weekend")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].login",
						Matchers.is("Week123")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].password",
						Matchers.is("kendrick123")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].name",
						Matchers.is("Igor")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].login",
						Matchers.is("igash888")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].password",
						Matchers.is("sadfsad325")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].name",
						Matchers.is("Tanya")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].login",
						Matchers.is("tanyad2702")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].password",
						Matchers.is("qwer12wqe")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[3].name",
						Matchers.is("Alexander")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[3].login",
						Matchers.is("Salex2608")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[3].password",
						Matchers.is("gavrusha12")));
	}

	@Test
	void shouldCreatePerson() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders
						.post("/people")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"name\" : \"Kanye\",\n" +
								"    \"login\" : \"kanyewest1\",\n" +
								"    \"password\" : \"kanye123\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());

		verify(personRepo).save(any(Person.class));
	}

	/*
	@Test
	void shouldNotCreatePerson() throws Exception {

		this.mockMvc
				.perform(MockMvcRequestBuilders
						.post("/people")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"name\" : \"Weekend\",\n" +
								"    \"login\" : \"Week123\",\n" +
								"    \"password\" : \"kendrick123\"}"))
				.andExpect(MockMvcResultMatchers.status().is5xxServerError());

		verify(personRepo).save(any(Person.class));
	}

	 */


}
