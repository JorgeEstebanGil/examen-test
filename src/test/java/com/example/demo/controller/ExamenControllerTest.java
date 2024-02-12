package com.example.demo.controller;

import com.example.demo.model.Examen;
import com.example.demo.service.ExamenService;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;





@ExtendWith(MockitoExtension.class)
public class ExamenControllerTest {

    ExamenController controller;

    @Mock
    private ExamenService service;
    @BeforeEach
    void setUp() throws Exception {
        controller = new ExamenController();
        controller.setService(service);
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
    public void testAge() {
        Model model = new ExtendedModelMap();
        Date fechaNacimiento = new Date(2005, 1, 1);
        when(service.ageChecker(any(Date.class), any(Date.class))).thenReturn(0L);

        String viewName = controller.age(new Examen(null, null, null, fechaNacimiento), model);
        assertNotNull(fechaNacimiento);
        assertEquals("underAge", viewName);

        Date fechaNacimiento2 = new Date(1980, 1, 1);
        when(service.ageChecker(any(Date.class), any(Date.class))).thenReturn(44L);

        String viewName2 = controller.age(new Examen(null, null, null, fechaNacimiento2), model);
        assertNotNull(fechaNacimiento2);
        assertEquals("getAJobNow", viewName2);

        Date fechaNacimiento3 = new Date(1950, 1, 1);
        when(service.ageChecker(any(Date.class), any(Date.class))).thenReturn(70L);

        String viewName3 = controller.age(new Examen(null, null, null, fechaNacimiento3), model);
        assertNotNull(fechaNacimiento3);
        assertEquals("retired", viewName3);

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

    }

    @Test
    public void index() {
    }
}