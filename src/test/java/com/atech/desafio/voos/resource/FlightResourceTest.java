package com.atech.desafio.voos.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.atech.desafio.voos.model.filter.FlightFilter;
import com.atech.desafio.voos.model.transfer.FlightDTO;
import com.atech.desafio.voos.service.FlightService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlightResource.class)
@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class FlightResourceTest {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FlightService flightService;



    @Test
    public void findByFilter_WhenTheFlightExists_ShouldReturnTheFlightCorrespondingtoTheId() throws Exception {

        String endpoint = "/desafio/flight/filter";

        FlightDTO flightDTO = new FlightDTO();

        List<FlightDTO> flightDTOs = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        flightDTO.setId(Long.valueOf(1));
        flightDTO.setPilotName("TesteNome");
        flightDTO.setPilotActive(true);
        flightDTO.setPlaneModel("ModeloTeste");
        flightDTO.setPlaneTailCode("TailTeste");
        flightDTO.setStatusDescription("TesteStatus");
        flightDTO.setCityDepart("TesteCidadePartida");
        flightDTO.setCityDepart("TesteCidadeChegada");
        flightDTO.setDepartTime(simpleDateFormat.parse("31/05/2022 17:25:00"));
        flightDTO.setArriveTime(simpleDateFormat.parse("31/05/2022 18:25:00"));

        flightDTOs.add(flightDTO);

        when(flightService.findByFilter(any(FlightFilter.class))).thenReturn(flightDTOs);

        MvcResult result = mockMvc.perform(get(endpoint).param("pilotName", "TesteNome"))
                				  .andExpect(status().isOk())
                				  .andReturn();

		final String jsonReturn = result.getResponse().getContentAsString();
		final List<FlightDTO> returnedFlightDTOs = objectMapper.readValue(jsonReturn, objectMapper.getTypeFactory().constructCollectionType(List.class, FlightDTO.class));


		assertEquals(1,returnedFlightDTOs.size());
        assertEquals(flightDTO.getId(), returnedFlightDTOs.get(0).getId());
        assertEquals(flightDTO.getPilotName(), returnedFlightDTOs.get(0).getPilotName());
    }

}
