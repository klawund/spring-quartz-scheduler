package com.klawund.scheduler.sample;

import org.springframework.stereotype.Service;

@Service
public class SampleService
{
	public void log()
	{
		System.out.println("sample job executed");
	}
}
