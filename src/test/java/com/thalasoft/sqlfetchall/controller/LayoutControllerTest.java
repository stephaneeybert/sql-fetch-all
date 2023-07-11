package com.thalasoft.sqlfetchall.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

import com.thalasoft.sqlfetchall.data.repository.LayoutRepository;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SqlGroup({
  @Sql(value = "classpath:fixture/data.reset.sql", executionPhase = BEFORE_TEST_METHOD),
  @Sql(value = "classpath:fixture/data.init.sql", executionPhase = BEFORE_TEST_METHOD)
})
public class LayoutControllerTest {

  @Autowired
  private LayoutRepository layoutRepository;

  @Autowired
  private MockMvc mockMvc;

  private Long layoutId = 2L;

  @Test
  void should_find_one() throws Exception {
    this.mockMvc.perform(get("/layout/find/{id}", layoutId))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(layoutId))
        .andExpect(jsonPath("$.name").value("My simple layout"))
        .andExpect(jsonPath("$.profile.profileType.profileTypeEnum").value("CAR"));
  }

  @Test
  void should_find_all() throws Exception {
    this.mockMvc.perform(get("/layout/findAll"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$.[0].id").value(layoutId));
  }

  @Test
  void should_create_one() throws Exception {
    final File jsonFile = new ClassPathResource("fixture/data.layout.json").getFile();
    final String content = Files.readString(jsonFile.toPath());

    this.mockMvc.perform(post("/layout/create/{profileId}", 1)
        .contentType(APPLICATION_JSON)
        .content(content))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$").isMap())
        .andExpect(jsonPath("$", aMapWithSize(4)))
        .andExpect(jsonPath("$.name").value("Another name"));

    assertThat(this.layoutRepository.findAll()).hasSize(2);
  }

  @Test
  void should_delete_one() throws Exception {
    this.mockMvc.perform(delete("/layout/delete/{id}", layoutId))
        .andDo(print())
        .andExpect(status().isNoContent());
    assertThat(this.layoutRepository.findAll()).isEmpty();
  }
}
