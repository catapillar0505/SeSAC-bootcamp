package com.example.rest_api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.rest_api.dto.MemberRequest;
import com.example.rest_api.dto.MemberResponse;

@Service
public class MemberServiceImpl implements MemberService {

  // 인메모리 데이터베이스
  private final Map<Long, MemberResponse> members = new ConcurrentHashMap<>();
  private final AtomicLong sequence = new AtomicLong();

  // mock 데이터 10개 만들기
  public MemberServiceImpl() {
    for (int i = 0; i < 10; i++) {
      save(MemberRequest.builder()
          .email("member" + i + "@test.com")
          .build());
    }
  }

  @Override
  public MemberResponse save(MemberRequest request) {
    Long id = sequence.incrementAndGet();
    String email = request.email(); // record 에서는 게터가 아닌 email이다.
    LocalDateTime createdAt = LocalDateTime.now();

    MemberResponse memberResponse = new MemberResponse(id, email, createdAt);
    members.put(id, memberResponse);
    return memberResponse;
  }

  @Override
  public List<MemberResponse> findAll() {
    return new ArrayList<>(members.values());
  }

  @Override
  public MemberResponse findMemberById(Long id) {
    MemberResponse response = members.get(id);
    if (response == null) {
      throw new RuntimeException(" 존재하지 않는 객체");
    }
    return response;

  }

  @Override
  public MemberResponse update(MemberRequest request, Long id) {
    MemberResponse foundMember = findMemberById(id);
    MemberResponse updatedMember = MemberResponse.builder()
        .id(id)
        .email(request.email())
        .createAt(foundMember.createAt())
        .build();
    members.put(id, updatedMember);
    return updatedMember;
  }

  @Override
  public void deleteById(Long id) {
    MemberResponse foundMember = findMemberById(id);
    members.remove(id);

  }

}
