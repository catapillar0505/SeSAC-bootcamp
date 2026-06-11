package com.example.valid.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.valid.dto.MemberCreateRequest;
import com.example.valid.dto.MemberDto;
import com.example.valid.dto.MemberUpdateRequest;
import com.example.valid.exception.CustomException;
import com.example.valid.exception.ErrorCode;

@Service
public class MemberService {
  private final Map<Long, MemberDto> store = new ConcurrentHashMap<>();

  private final AtomicLong sequence = new AtomicLong(0);

  public MemberService() {
    save(MemberCreateRequest.builder()
        .userName("kim")
        .email("kim@test.com")
        .build());
    save(MemberCreateRequest.builder()
        .userName("jina")
        .email("jina@test.com")
        .build());
    save(MemberCreateRequest.builder()
        .userName("cgoi")
        .email("dfsf@test.com")
        .build());
  }

  // save
  public MemberDto save(MemberCreateRequest request) {
    // 회원 중 한명이라도 이메일 같으면
    boolean isExistEmail = store.values().stream().anyMatch(member -> member.email().equals(request.email()));
  
    // 이메일 중복 검증
     if(isExistEmail) {
        throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
     }

    Long id = sequence.incrementAndGet();
    MemberDto member = MemberDto.builder()
        .id(id)
        .userName(request.userName())
        .email(request.email())
        .createdAt(LocalDateTime.now())
        .build();
    store.put(id, member);
    return member;
  }

  // read all
  public List<MemberDto> findAll() {
    return new ArrayList<>(store.values());
  }

  // read one
  public MemberDto findById(Long id) {
    MemberDto foundMember = store.get(id);
     if(foundMember == null) {
      throw new CustomException(ErrorCode.MEMBER_NOT_FOUND);
     }
    return foundMember;
  }

  // update
  public MemberDto updateMember(Long id, MemberUpdateRequest request) {
    MemberDto foundMember = findById(id);
    MemberDto updatedMemberDto = MemberDto.builder()
        .id(foundMember.id())
        .userName(foundMember.userName())
        .email(request.email())
        .createdAt(foundMember.createdAt())
        .build();
    store.put(id, updatedMemberDto);
    return updatedMemberDto;
  }

  // delete
  public void deleteById(Long id){
    findById(id);
    store.remove(id);
  }
  
}
