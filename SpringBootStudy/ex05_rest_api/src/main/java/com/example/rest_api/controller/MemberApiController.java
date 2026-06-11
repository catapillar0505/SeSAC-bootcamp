package com.example.rest_api.controller;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_api.dto.MemberRequest;
import com.example.rest_api.dto.MemberResponse;
import com.example.rest_api.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/members")
@RequiredArgsConstructor
@RestController
public class MemberApiController {
  private final MemberService memberService;

  @PostMapping
  public ResponseEntity<MemberResponse> createMember(@RequestBody MemberRequest memberRequest) {
    MemberResponse savedMember = memberService.save(memberRequest);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
  }

  @GetMapping
  public ResponseEntity<List<MemberResponse>> getAllMembers() {
    List<MemberResponse> savedMemberList = memberService.findAll();

    return ResponseEntity.ok(savedMemberList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<MemberResponse> getMemberById(@PathVariable("id") Long id) {
    try {
      MemberResponse foundMember = memberService.findMemberById(id);
      return ResponseEntity.ok(foundMember);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }

  }

  @PutMapping("/{id}")
  public ResponseEntity<MemberResponse> updateMember(
      @PathVariable("id") Long id,
      @RequestBody MemberRequest request) {
    try {
      MemberResponse updatedMember = memberService.update(request, id);

      return ResponseEntity.ok(updatedMember);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMember(@PathVariable("id") Long id) {
    try {
      memberService.deleteById(id);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

}
