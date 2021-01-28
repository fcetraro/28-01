package com.example.demo;

import com.example.demo.model.HouseDTO;
import com.example.demo.model.RoomDTO;
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
		String url = "/calculator";
		HouseDTO anObject = new HouseDTO();
		anObject.setName("testName");
		anObject.setAddress("testAddress");
		RoomDTO aRoom = new RoomDTO();
		aRoom.setName("testRoomName");
		aRoom.setWidth(1);
		aRoom.setLength(2);
		List<RoomDTO> rooms = new ArrayList<>();
		rooms.add(aRoom);
		anObject.setRooms(rooms);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(anObject);
		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("2")));
	}
}