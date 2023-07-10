package com.klawund.scheduler.sample;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import com.klawund.scheduler.framework.descriptor.JobDescriptor;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class SampleJobDescriptor implements JobDescriptor
{
	@Override
	@NonNull
	public JobDetail buildJobDetail()
	{
		return JobBuilder.newJob().ofType(SampleJob.class)
			.storeDurably()
			.withIdentity("Sample job detail")
			.withDescription("Sample job description")
			.build();
	}

	@Override
	@NonNull
	public Trigger buildTrigger()
	{
		return TriggerBuilder.newTrigger().forJob(buildJobDetail())
			.withIdentity("Sample job trigger")
			.withDescription("Triggers sample job")
			.withSchedule(simpleSchedule().repeatForever().withIntervalInSeconds(5))
			.build();
	}
}
