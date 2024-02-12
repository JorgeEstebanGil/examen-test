package com.example.demo.controller;

import com.example.demo.model.Examen;
import com.example.demo.service.ExamenService;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamenControllerTest {

    ExamenController controller;

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
        String route4 = null;
        assertEquals("divisionChecker", controller.navigate(route,model));
        assertEquals("ageChecker", controller.navigate(route2,model));
        assertEquals("error", controller.navigate(route3,model));
    }


    void TestAge() {
        Model model = new ExtendedModelMap();
        Examen examen = new Examen();
        Long age = 0L;
        List<Examen> listaPrecreada = createMockedList();
        when(service.ageChecker(examen.getFechaNacimiento(),new Date())).thenReturn(createMockedList());//listaPrecreada, puedes poner eso en vez de createMockedList, se pone para simplicar el codigo

        try {
            age = service.ageChecker(examen.getFechaNacimiento(),new Date())	;
        } catch (Exception e) {
            assertEquals("error", controller.age(examen,model));
        }
        if(age<18) {
            assertEquals("underAge", controller.age(examen,model));
        }else if (age > 18 && age < 67) {
            assertEquals("getAJobNow", controller.age(examen,model));
        }else if(age > 67) {
            assertEquals("retired", controller.age(examen,model));
        }
        assertEquals("error", controller.age(examen,model));


    }

    private static List<Examen> createMockedList() {
        List<Examen> listaPrecreada = new ArrayList<>();

        // Crear fechas de nacimiento
        Date date = new Date(2005, 0, 1);
        Date date2 = new Date(1955, 0, 1);
        Date date3 = new Date(1950, 0, 1);

        // Añadir objetos Examen a la lista con fechas de nacimiento
        listaPrecreada.add(new Examen(null, null, date));
        listaPrecreada.add(new Examen(null, null, date2));
        listaPrecreada.add(new Examen(null, null, date3));

        return listaPrecreada;
    }

    @Test
    public void division() {
    }

    @Test
    public void index() {
    }
}