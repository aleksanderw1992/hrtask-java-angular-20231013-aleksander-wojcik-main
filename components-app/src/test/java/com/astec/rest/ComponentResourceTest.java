package com.astec.rest;

import com.astec.model.Component;
import com.astec.service.ComponentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComponentResourceTest {

    @InjectMocks
    private ComponentResource componentResource;

    @Mock
    private ComponentService componentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListComponents() {
        Component mockComponent = new Component(1L, "TestComponent", "This is a test component.", null);
        List<Component> components = Arrays.asList(mockComponent);

        when(componentService.findAll()).thenReturn(components);  // Mocking the call to findAll

        Response response = componentResource.listComponents();
        assertEquals(200, response.getStatus());
        assertEquals(components, response.getEntity());
    }

    @Test
    public void testAddAndDeleteComponent() {
        Component mockComponent = new Component(null, "TestComponent", "This is a test component.", null);
        Component savedComponent = new Component(1L, "TestComponent", "This is a test component.", null);

        when(componentService.save(any(Component.class))).thenReturn(savedComponent);  // Mocking the save call

        Response responseAdd = componentResource.addComponent(mockComponent);
        assertEquals(201, responseAdd.getStatus());
        assertEquals(mockComponent, responseAdd.getEntity());

        doNothing().when(componentService).delete(1L);  // Mocking the delete call

        Response responseDelete = componentResource.deleteComponent(1L);
        assertEquals(200, responseDelete.getStatus());
    }
}
