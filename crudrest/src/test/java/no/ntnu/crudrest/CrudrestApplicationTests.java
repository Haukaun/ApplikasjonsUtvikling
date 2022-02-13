package no.ntnu.crudrest;


import com.fasterxml.jackson.databind.ObjectMapper;
import no.ntnu.crudrest.Random.Book;
import no.ntnu.crudrest.Random.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CrudrestApplicationTests {

	BookController bookController = new BookController();

	/**
	 * Used for simulating API endpoint requests and analyzing them
	 */
	@Autowired
	MockMvc mvc;

	/**
	 * Used for converting Hello <-> JSON string
	 */
	@Autowired
	ObjectMapper objectMapper;


	@Test
	void contextLoads() {
	}


	@Test
	void checkBookCount() throws Exception {
		mvc.perform(get("/books/count"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("2")));
	}

	@Test
	void getNonExistingBook() throws Exception {
		mvc.perform(get("/books/883"))
				.andExpect(status().isNotFound());
	}


	@Test
	void getBookYearAndTitle() throws Exception {
		String jsonResponse = mvc.perform(get("/books/1"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Book book = objectMapper.readValue(jsonResponse, Book.class);

		assertThat(book.getTitle()).isEqualTo("Computer Networks");
		assertThat(book.getId()).isEqualTo(1);

	}

	@Test
	void deleteNonExisitingBook() throws Exception{
		mvc.perform(delete("/883"))
				.andExpect(status().isNotFound());
	}

	@Test
	void checkDeleteAndAddFunction() throws Exception {
		checkBookCount();
		getBookYearAndTitle();
		mvc.perform(delete("/books/1"))
				.andExpect(status().isOk());
		mvc.perform(get("/books/1"))
				.andExpect(status().isNotFound());
		mvc.perform(get("/books/count"))
				.andExpect(content().string(containsString("1")));

		String jsonString = objectMapper.writeValueAsString(new Book(10, "48 Rules Of Power", 1998, 480));
		mvc.perform(post("/books")
				.content(jsonString)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		String jsonResponse = mvc.perform(get("/books/10"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Book book = objectMapper.readValue(jsonResponse, Book.class);
		assertThat(book.getTitle()).isEqualTo("48 Rules Of Power");
		assertThat(book.getId()).isEqualTo(10);
	}



}
