package edu.javeriana.ingenieria.estudiantes;


import edu.javeriana.ingenieria.estudiantes.repositorio.RepositorioEstudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.SQLException;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ControladorEstudianteTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@BeforeEach
	public void limpiarYRecargarBaseDatos() throws SQLException {
		// Leer el script SQL desde el archivo
		ClassPathResource resource = new ClassPathResource("Script.sql");
		ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), resource);
		resource = new ClassPathResource("Inserts-Prueba.sql");
		ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), resource);
	}
	@Test
	void testObtenerEstudiantes() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/estudiantes/listar"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
	}

	@Test
	void testObtenerEstudiantePorId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/estudiantes/obtenerId?id=" + 1))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.cedula").value(1234567));
	}

	@Test
	void testObtenerEstudiantePorCedula() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/estudiantes/obtenerCedula?cedula=" + 1234567))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				// Puedes agregar más aserciones para verificar que los datos devueltos son correctos
				.andExpect(MockMvcResultMatchers.jsonPath("$.cedula").value(1234567))
				.andExpect(MockMvcResultMatchers.jsonPath("$.correo_institucional").value("juan.perez@universidad.edu"));
	}
}