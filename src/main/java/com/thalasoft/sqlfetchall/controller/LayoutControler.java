package com.thalasoft.sqlfetchall.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.thalasoft.sqlfetchall.data.model.dto.LayoutGetDto;
import com.thalasoft.sqlfetchall.data.model.dto.LayoutPostDto;
import com.thalasoft.sqlfetchall.data.model.dto.mapper.LayoutMapper;
import com.thalasoft.sqlfetchall.data.service.LayoutService;
import com.thalasoft.sqlfetchall.data.service.ProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/layout")
@RequiredArgsConstructor
public class LayoutControler {

  private final LayoutService layoutService;

  private final ProfileService profileService;

  private final LayoutMapper layoutMapper;

  @PostMapping("/create/{profileId}")
  @ResponseStatus(HttpStatus.CREATED)
  public LayoutGetDto create(@PathVariable("profileId") Long profileId, @RequestBody LayoutPostDto layoutDto) {
    layoutDto.setProfileDto(this.layoutMapper.entityToDto(profileService.findById(profileId)));
    return this.layoutMapper.entityToDto(this.layoutService.create(this.layoutMapper.dtoToEntity(layoutDto)));
  }

  @GetMapping("/find/{id}")
  @ResponseStatus(HttpStatus.OK)
  public LayoutGetDto findById(@PathVariable long id) {
    // TODO
    // Is the Hibernate session closed when leaving the service ?
    // Then does a lazily fetched property have to be retrieved in the service ?
    // Does the mapping have to be done in the service ?
    // When doing the mapping in the controller, if the Hibernate session is already closed, then is it too late to do the mapping ?
    return this.layoutMapper.entityToDto(this.layoutService.findById(id));
  }

  @GetMapping("/findAll")
  @ResponseStatus(HttpStatus.OK)
  public List<LayoutGetDto> findAll() {
    return this.layoutService.findAll()
    .stream()
    .map(layoutMapper::entityToDto)
    .collect(Collectors.toList());
  }

  @DeleteMapping("delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOneLayout(@PathVariable("id") int id) {
    this.layoutService.deleteById(id);
  }
}
