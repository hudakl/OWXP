package com.liferay.micro.maintainance.task;

import java.util.ArrayList;
import java.util.List;

import com.liferay.micro.maintainance.action.Action;
import com.liferay.micro.maintainance.action.NotifyCreatorAction;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.util.VoteConstants;
import com.liferay.micro.maintainance.util.VotesJSONSerializer;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class OutdatedTask implements Task {

	protected OutdatedTask() {
		this.taskId = 0;
	}

	public static OutdatedTask getOutdatedTaskInstance() {
		if(outdatedTask == null) {
			outdatedTask = new OutdatedTask();
		}

		return outdatedTask;
	}

	@Override
	public List<Action> analyze(AnalysisEntry analysisEntry) {
		List<Action> actions = new ArrayList<Action>();

		double percentageYesVotes =VotesJSONSerializer.getVotePercentage(
				analysisEntry.getAnalysisData(), VoteConstants.YES_DESCRIPTION);
		
		int totalUsers = UserLocalServiceUtil.getUsersCount();
		int totalVotedUsers = VotesJSONSerializer.getTotalVotes(analysisEntry.getAnalysisData());
		double percentageVoted = 0.00;

		if(totalVotedUsers > 0) {
			percentageVoted = (totalVotedUsers * 100/ totalUsers);
		}

		if(percentageVoted > 5 && percentageYesVotes > 5) {
			actions.add(new NotifyCreatorAction());
		}

		return actions;
	}

	@Override
	public long getTaskId() {
		return taskId;
	}

	@Override
	public String getTaskName() {
		return TASK_NAME;
	}

	@Override
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	@Override
	public boolean isAnalyseReady(CandidateMaintenance canMain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getOutcome() {
		return outcome;
	}

	private static String TASK_NAME = "Outdated";
	private long taskId = 0;
	private static OutdatedTask outdatedTask = null;
	private String outcome = "";
}
