package com.klawund.scheduler.framework.descriptor;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.lang.NonNull;

public interface JobDescriptor
{
	@NonNull
	JobDetail buildJobDetail();

	@NonNull
	Trigger buildTrigger();
}
