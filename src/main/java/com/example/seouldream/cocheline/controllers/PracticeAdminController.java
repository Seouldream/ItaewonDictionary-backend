package com.example.seouldream.cocheline.controllers;

import com.example.seouldream.cocheline.dtos.*;
import com.example.seouldream.cocheline.services.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class PracticeAdminController {
  private DeletePracticeService deletePracticeService;

  public PracticeAdminController(DeletePracticeService deletePracticeService) {
    this.deletePracticeService = deletePracticeService;
  }

  @DeleteMapping("/practice/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(
      @PathVariable("id") Long id
  ) {
    deletePracticeService.delete(id);
  }
}
