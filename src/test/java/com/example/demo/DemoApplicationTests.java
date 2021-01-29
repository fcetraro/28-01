package com.example.demo;

import com.example.demo.model.HouseDTO;
import com.example.demo.model.RoomDTO;
import com.example.demo.model.StudentDTO;
import com.example.demo.model.SubjectDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class GetDemoApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	@Test
	void shouldCalculateAgeFromDates() throws Exception {
		this.mockMvc.perform(get("/04/04/1996"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("24")));
	}
	@Test
	void shouldCalculateArea() throws Exception {
		String url = "/house/totalArea";
		HouseDTO anObject = TestUtil.getHouseTest();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(anObject);
		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("6")));
	}
	@Test
	void shouldCalculateValue() throws Exception {
		String url = "/house/getValue";
		HouseDTO anObject = TestUtil.getHouseTest();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(anObject);
		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("4800")));
	}
	@Test
	void shouldGetBiggestRoom() throws Exception {
		String url = "/house/biggestRoom";
		HouseDTO anObject = TestUtil.getHouseTest();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(anObject);
		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("anotherTestRoomName")));
	}
	@Test
	void shouldGetRooms() throws Exception {
		String url = "/house/rooms";
		HouseDTO anObject = TestUtil.getHouseTest();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(anObject);
		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("area")))
				.andExpect(content().string(containsString("4")))
				.andExpect(content().string(containsString("2")));
	}
	@Test
	void shouldGetMeliCongrats() throws Exception {
		String url = "/degree";
		StudentDTO anObject = new StudentDTO();
		anObject.setName("testName");
		SubjectDTO aSubject = new SubjectDTO();
		aSubject.setName("testSubject");
		aSubject.setScore(10);
		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(aSubject);
		anObject.setSubjects(subjects);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(anObject);
		mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("MELI")));
	}
}