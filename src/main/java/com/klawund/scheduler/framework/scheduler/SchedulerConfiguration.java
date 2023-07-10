package com.klawund.scheduler.framework.scheduler;

import com.klawund.scheduler.framework.descriptor.JobDescriptor;
import java.util.Set;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
public class SchedulerConfiguration
{
	@Bean
	JobFactory jobFactory(ApplicationContext applicationContext)
	{
		var factory = new SpringBeanJobFactory();
		factory.setApplicationContext(applicationContext);
		return factory;
	}

	@Bean
	Scheduler scheduler(JobFactory jobFactory, Set<JobDescriptor> descriptors) throws SchedulerException
	{
		var scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.setJobFactory(jobFactory);

		for (var descriptor : descriptors)
		{
			scheduler.scheduleJob(descriptor.buildJobDetail(), descriptor.buildTrigger());
		}

		scheduler.start();
		return scheduler;
	}
}
