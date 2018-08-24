package com.example.fond;

import com.example.fond.domain.Person;
import com.example.fond.exceptions.EmptyListException;
import com.example.fond.exceptions.NullFirstNameException;
import com.example.fond.service.PersonRepo;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class AllControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/persons")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("listPersons")));
    }

    @Test(expected = EmptyListException.class)
    public void testFiltrEmptyListException() {
        PersonRepo personRepo = mock(PersonRepo.class);
        when(personRepo.findByLastNameOrFirstName("NAME", "Name")).thenReturn(Collections.emptyList());
        AllController controller = new AllController(personRepo, null, null);
        controller.filtr("NAME", "Name");
    }

    @Test(expected = NullFirstNameException.class)
    public void testFiltrNullFirstNameException() {
        AllController allController = new AllController(null, null, null);
        allController.filtr(null, "asasd");

    }

    @Test
    public void testFiltrReturn() {
        Person person = new Person();
        person.setFirstName("FIRST_111");
        person.setLastName("LAST_222");

        PersonRepo personRepo = mock(PersonRepo.class);
        when(personRepo.findByLastNameOrFirstName(anyString(), anyString()))
                .thenReturn(Collections.singletonList(person));

        AllController controller = new AllController(personRepo, null, null);
        List <Person> persons = controller.filtr("FIRST", "LAST");

        assertEquals(1, persons.size());
        Person p = persons.get(0);
        assertEquals("FIRST_111", p.getFirstName());
        assertEquals("LAST_222", p.getLastName());
    }

    @Test
    public void testGetAllPersons() throws Exception {
        this.mockMvc.perform(get("/persons1")
                .accept(MediaType.parseMediaType("application/json")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[*]", hasSize(101)))
                .andExpect(jsonPath("$.[100].id", is(1)));
                /*.andExpect(jsonPath("firstName").value("ASHOT"))
                .andExpect(jsonPath("lastName").value("AGALRAYAN"))
                .andExpect(jsonPath("patronymic").value("Garikovich"))
                .andExpect(jsonPath("inn").value(123456789))
                .andExpect(jsonPath("snils").value(987654321))
                .andExpect(jsonPath("dateOfBirth").value("1991-02-08"));*/
    }
}