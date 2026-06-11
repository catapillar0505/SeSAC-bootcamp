package com.example.rest_api.service;

import java.util.List;

import com.example.rest_api.dto.MemberRequest;
import com.example.rest_api.dto.MemberResponse;

public interface MemberService {
  MemberResponse save(MemberRequest request);

  List<MemberResponse> findAll();

  MemberResponse findMemberById(Long id);

  MemberResponse update(MemberRequest request, Long id);

  void deleteById(Long id);
}
