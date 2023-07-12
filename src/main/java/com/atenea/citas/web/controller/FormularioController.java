package com.atenea.citas.web.controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formulario")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*")
public class FormularioController {
    private JsonNode miEsquema; // Variable para almacenar el JSON-Schema

    private final String jsonSchema = "{\n" +
            "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
            "  \"definitions\": {\n" +
            "    \"Paciente\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"cedula\": {\n" +
            "          \"type\": \"integer\"\n" +
            "        },\n" +
            "        \"nombre\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"apellido\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"fechaNacimiento\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"date-time\"\n" +
            "        },\n" +
            "        \"telefono\": {\n" +
            "          \"type\": \"string\"\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"Medico\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"tarjetaProfesional\": {\n" +
            "          \"type\": \"integer\"\n" +
            "        },\n" +
            "        \"nombre\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"apellido\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"consultorio\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"telefono\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"email\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"Especialidad\": {\n" +
            "          \"anyOf\": [\n" +
            "            {\n" +
            "              \"$ref\": \"#/definitions/Especialidad\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"type\": \"null\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"Cita\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"idCita\": {\n" +
            "          \"type\": \"integer\"\n" +
            "        },\n" +
            "        \"fechaCita\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"date-time\"\n" +
            "        },\n" +
            "        \"Paciente\": {\n" +
            "          \"anyOf\": [\n" +
            "            {\n" +
            "              \"$ref\": \"#/definitions/Paciente\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"type\": \"null\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        \"Medico\": {\n" +
            "          \"anyOf\": [\n" +
            "            {\n" +
            "              \"$ref\": \"#/definitions/Medico\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"type\": \"null\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"Especialidad\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"idEspecialidad\": {\n" +
            "          \"type\": \"integer\"\n" +
            "        },\n" +
            "        \"nombre\": {\n" +
            "          \"type\": \"string\"\n" +
            "        },\n" +
            "        \"Medico\": {\n" +
            "          \"type\": \"array\",\n" +
            "          \"items\": {\n" +
            "            \"$ref\": \"#/definitions/Medico\"\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"type\": \"object\",\n" +
            "  \"properties\": {\n" +
            "    \"paciente\": {\n" +
            "      \"$ref\": \"#/definitions/Paciente\"\n" +
            "    },\n" +
            "    \"medico\": {\n" +
            "      \"$ref\": \"#/definitions/Medico\"\n" +
            "    },\n" +
            "    \"cita\": {\n" +
            "      \"$ref\": \"#/definitions/Cita\"\n" +
            "    },\n" +
            "    \"especialidad\": {\n" +
            "      \"$ref\": \"#/definitions/Especialidad\"\n" +
            "    }\n" +
            "  }\n" +
            "}";

    public FormularioController() {
        // Realiza la lectura y el análisis del JSON-Schema utilizando Jackson
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            miEsquema = objectMapper.readTree(jsonSchema);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/{formulario}")
    public ResponseEntity<?> obtenerDefinicion(@PathVariable String formulario) {
        if (miEsquema != null) {
            JsonNode definicionFormulario = miEsquema.path("definitions").path(formulario);

            if (definicionFormulario.isObject()) {
                return ResponseEntity.ok(definicionFormulario);
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Formulario no encontrado");
    }
}


