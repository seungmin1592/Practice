package com.cos.person.events;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public class Event {
	
	private Integer id;
	
	private String name;
	private String desciption;
	private LocalDateTime beginEnrollmentDateTime;
	private LocalDateTime closeEnrollmentDateTime;
	private LocalDateTime endEventDateTime;
	private String location; //(optional) 이게 없으면 온라인 모임
	private int basePrice; // (optional)
	private int maxPrice; // (optional)
	private int limitOfErollment;
	
	private boolean offline;
	private boolean free;
	private EventStatus eventStatus;
}
