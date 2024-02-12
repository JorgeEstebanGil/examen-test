package com.example.demo.controller;

import com.example.demo.model.Examen;
import com.example.demo.service.ExamenService;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ExamenControllerTest {


    @Autowired
    ExamenController controller;

    @Autowired
    MockMvc mockmvc;

    @Mock
    private ExamenService service;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNavigate() {
        Model model = new ExtendedModelMap();
        Examen examen = new Examen();
        String route = "divisionChecker";
        String route2 = "ageChecker";
        String route3 = "error";
        assertEquals("divisionChecker", controller.navigate(route,model));
        assertEquals("ageChecker", controller.navigate(route2,model));
        assertEquals("error", controller.navigate(route3,model));
    }


    @Test
    void TestAge() {
        Model model = new ExtendedModelMap();
        Examen examen = new Examen(1,1, 1, new Date(2005, 0, 1));
        assertEquals("under-Age", controller.age(examen,model));

        Examen examen2 = new Examen(2,1, 1, new Date(1955, 0, 1));
        assertEquals("getAJobNow", controller.age(examen2,model));

        Examen examen3 = new Examen(3,1, 1, new Date(1950, 0, 1));
        assertEquals("retired", controller.age(examen3,model));

    }

    private static List<Examen> createMockedList() {
        List<Examen> listaCreada = new ArrayList<>();
        // Crear fechas de nacimiento
        Date date = new Date(2005, 0, 1);
        Date date2 = new Date(1955, 0, 1);
        Date date3 = new Date(1950, 0, 1);

        // Añadir objetos Examen a la lista con fechas de nacimiento
        listaCreada.add(new Examen(null,null, null, date));
        listaCreada.add(new Examen(null, null, null, date2));
        listaCreada.add(new Examen(null, null, null, date3));

        return listaCreada;
    }

    @Test
    public void TestDivision() {
        MockHttpServletRequestBuilder requestbuilder = MockMvcRequestBuilders.get("/divisionChecker").queryParam("dividendo", "10")
                .queryParam("divisor", "2");
        try {
            MvcResult mvcresult = mockmvc.perform(requestbuilder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            ModelAndView modelandview = mvcresult.getModelAndView();
            assertEquals("resultOperation", modelandview.getViewName());
            assertEquals(5, modelandview.getModel().get("msg"));
        } catch (Exception e) {
            e.printStackTrace();
            fail("No debería haber excepciones");

        }

    }

    void testInsertarStudentForm(){
        MockHttpServletRequestBuilder requestbuilder = MockMvcRequestBuilders.get("/insertStudent").queryParam("nombre", "Alberto")
                .queryParam("apellido", "Garcia");;
        try {
            MvcResult mvcresult = mockmvc.perform(requestbuilder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            ModelAndView modelandview = mvcresult.getModelAndView();
            assertEquals("fin", modelandview.getViewName());
            assertEquals("estudiantes", modelandview.getModel().get("estudiantes"));
        } catch (Exception e) {
            e.printStackTrace();
            fail("No debería haber excepciones");
        }
    }

    @Test
    public void index() {
    }
}