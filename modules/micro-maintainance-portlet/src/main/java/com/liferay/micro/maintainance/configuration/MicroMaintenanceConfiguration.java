package com.liferay.micro.maintainance.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.liferay.micro.maintainance.configuration.MicroMaintenanceConfiguration")
public interface MicroMaintenanceConfiguration {

	@Meta.AD(
		deflt = "14",
		required = true
	)
	public int votingPeriodDays();

	@Meta.AD(
		deflt = "0",
		required = true
	)
	public int votingPeriodHours();

	@Meta.AD(
		deflt = "0",
		required = true
	)
	public int votingPeriodMinutes();
}
