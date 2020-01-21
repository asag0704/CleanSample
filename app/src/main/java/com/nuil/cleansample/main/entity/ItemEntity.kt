package com.nuil.cleansample.main.entity

/**
 * Entity Layer는 순수 Java, Kotlin 모듈로 안드로이드와 의존성이 없는 레이어이다.
 * 즉 사용자가 생각하는 기준의 데이터 개념
 *
 * ViewModel에서 사용하기 위한 데이터클래스
 * */
data class ItemEntity(
    val title: String,
    val currentTime: Long
)