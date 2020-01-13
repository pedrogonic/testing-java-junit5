package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest implements ControllerTests {

    VetController vetController;

    VetService vetService;
    SpecialtyService specialityService;

    @BeforeEach
    void setUp() {

        specialityService = new SpecialityMapService();
        vetService = new VetMapService(specialityService);

        vetController = new VetController(vetService);

        Speciality dogSpeciality = new Speciality("dog");
        Speciality catSpeciality = new Speciality("cat");
        Speciality parakeetSpeciality = new Speciality("parakeet");

        Vet vet1 = new Vet(1l,
                "John",
                "Doe",
                new HashSet<>(Arrays.asList(new Speciality[]{dogSpeciality, catSpeciality}))
        );
        Vet vet2 = new Vet(2l,
                "Pedro",
                "Coelho",
                new HashSet<>(Arrays.asList(new Speciality[]{dogSpeciality, parakeetSpeciality}))
        );

        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {

        Model model = new ModelMapImpl();

        assertEquals("vets/index", vetController.listVets(model));

        assertEquals(2, ((Set) ((ModelMapImpl) model).getHashMap().get("vets")).size());

    }
}