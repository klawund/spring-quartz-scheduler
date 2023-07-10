package com.klawund.scheduler.sample;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleJob implements Job
{
	private final SampleService service;

	@Autowired
	public SampleJob(SampleService service)
	{
		this.service = service;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		service.log();
	}
}
