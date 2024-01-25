package com.sebin.microservices.core.user.persistence;

/**
 * ACTIVE : 인증 사용자
 * INACTIVE : 미인증 사용자
 * SUSPENDED: 정지 사용자
 * DELETED: 탈퇴 사용자
 * @author : sebin
 * @fileName : UserStatus
 * @since : 1/18/24
 */
public enum UserStatus {
    ACTIVE,
    INACTIVE,
    SUSPENDED,
    DELETED
}