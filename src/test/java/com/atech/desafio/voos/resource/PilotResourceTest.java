package com.atech.desafio.voos.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

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

import com.atech.desafio.voos.model.transfer.PilotDTO;
import com.atech.desafio.voos.service.PilotService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PilotResource.class)
@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class PilotResourceTest {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PilotService pilotService;

    private final String uri = "/desafio/pilot";

    @Test
    public void findById_WhenTheProfileExists_ShouldReturnTheProfileCorrespondingtoTheId() throws Exception {

        String endpoint = "/1";

        PilotDTO pilotDTO = new PilotDTO();
        pilotDTO.setId(1L);
        pilotDTO.setName("Teste");
        pilotDTO.setActive(true);

        when(pilotService.findById(anyLong())).thenReturn(Optional.of(pilotDTO));

        MvcResult result = mockMvc.perform(get(uri + endpoint))
                				  .andExpect(status().isOk())
                				  .andReturn();

        final String jsonReturn = result.getResponse().getContentAsString();
        final PilotDTO returnedPilotDTO = objectMapper.readValue(jsonReturn, PilotDTO.class);

        assertEquals(pilotDTO.getId(), returnedPilotDTO.getId());
        assertEquals(pilotDTO.getName(), returnedPilotDTO.getName());
        assertTrue(returnedPilotDTO.isActive());
    }

    @Test
    public void findById_WhenProfileDoesNotExist_ShouldReturnEmpty() throws Exception {

        String endpoint = "/1";

        when(pilotService.findById(anyLong())).thenReturn(Optional.empty());

        mockMvc.perform(get(uri + endpoint))
                			.andExpect(status().isNoContent())
                			.andReturn();

    }
}
