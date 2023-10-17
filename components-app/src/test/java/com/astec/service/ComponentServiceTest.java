package com.astec.service;

import com.astec.model.Component;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ComponentServiceTest {

    private ComponentService componentService;

    @Mock
    private EntityManager em;

    @Mock
    private TypedQuery<Component> typedQuery;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        componentService = new ComponentService(em);
    }

    @Test
    public void testSave() {
        Component mockComponent = new Component(null, "TestComponent", "Description", null);
        componentService.save(mockComponent);
        verify(em).persist(mockComponent);
    }

    @Test
    public void testDeleteExistingComponent() {
        Long id = 1L;
        Component mockComponent = new Component(id, "TestComponent", "Description", null);

        when(em.find(Component.class, id)).thenReturn(mockComponent);

        componentService.delete(id);

        verify(em).remove(mockComponent);
    }

    @Test
    public void testDeleteNonExistingComponent() {
        Long id = 1L;
        when(em.find(Component.class, id)).thenReturn(null);

        componentService.delete(id);

        verify(em, never()).remove(any());
    }

    @Test
    public void testFindAll() {
        List<Component> expectedComponents = Arrays.asList(
            new Component(1L, "Component1", "Description1", null),
            new Component(2L, "Component2", "Description2", null)
        );

        when(em.createQuery("SELECT c FROM Component c", Component.class)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(expectedComponents);

        List<Component> components = componentService.findAll();

        assertEquals(expectedComponents, components);
    }
}
