package com.liferay.micro.maintainance.task;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.micro.maintainance.action.NotifyCreatorAction;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.micro.maintainance.api.Action;
import com.liferay.micro.maintainance.api.AutoFlaggable;
import com.liferay.micro.maintainance.api.Task;
import com.liferay.micro.maintainance.task.model.CandidateMaintenance;
import com.liferay.micro.maintainance.util.VoteCalculations;
import com.liferay.micro.maintainance.util.VoteConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.wiki.model.WikiPage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Rimi Saadou
 * @author Laszlo Hudak
 */
public class OutdatedTask implements Task, AutoFlaggable {

	public static OutdatedTask getOutdatedTaskInstance() {
		if (_outdatedTask == null) {
			_outdatedTask = new OutdatedTask();
		}

		return _outdatedTask;
	}

	@Override
	public List<Action> analyze(AnalysisEntry analysisEntry) {
		List<Action> actions = new ArrayList<>();

		double percentageYesVotes = VoteCalculations.getVotePercentage(
			analysisEntry.getAnalysisData(), VoteConstants.YES_DESCRIPTION);
		int totalUsers = UserLocalServiceUtil.getUsersCount();
		int totalVotedUsers = VoteCalculations.getTotalVotes(
			analysisEntry.getAnalysisData());
		double percentageVoted = 0.00;

		if (totalVotedUsers > 0) {
			percentageVoted = totalVotedUsers * 100 / totalUsers;
		}

		if ((percentageVoted > _requiredVotingPercentage) &&
			(percentageYesVotes > _requiredYesVotesPercentage)) {

			actions.add(new NotifyCreatorAction());
		}

		return actions;
	}

	@Override
	public List<Action> autoFlaggedAnalyze(AnalysisEntry analysisEntry) {
		List<Action> actions = new ArrayList<>();

		double percentageYesVotes = VoteCalculations.getVotePercentage(
			analysisEntry.getAnalysisData(), VoteConstants.YES_DESCRIPTION);
		int totalUsers = UserLocalServiceUtil.getUsersCount();
		int totalVotedUsers = VoteCalculations.getTotalVotes(
			analysisEntry.getAnalysisData());
		double percentageVoted = 0.00;

		if (totalVotedUsers > 0) {
			percentageVoted = totalVotedUsers * 100 / totalUsers;
		}

		if ((percentageVoted > _requiredVotingPercentageAutoFlagged) &&
			(percentageYesVotes > _requiredYesVotesPercentageAutoFlagged)) {

			actions.add(new NotifyCreatorAction());
		}

		return actions;
	}

	@Override
	public String getOutcome() {
		return _outcome;
	}

	public String[] getRequiredTagFragments() {
		return _requiredTagFragments;
	}

	public int getRequiredViewCountForAutoFlagging() {
		return _requiredViewCountForAutoFlagging;
	}

	public int getRequiredVotingPercentage() {
		return _requiredVotingPercentage;
	}

	public int getRequiredVotingPercentageAutoFlagged() {
		return _requiredVotingPercentageAutoFlagged;
	}

	public int getRequiredYesVotesPercentage() {
		return _requiredYesVotesPercentage;
	}

	public int getRequiredYesVotesPercentageAutoFlagged() {
		return _requiredYesVotesPercentageAutoFlagged;
	}

	@Override
	public long getTaskId() {
		return _taskId;
	}

	@Override
	public String getTaskName() {
		return _TASK_NAME;
	}

	public int getVotingPeriodDays() {
		return _votingPeriodDays;
	}

	@Override
	public boolean isAnalyseReady(CandidateMaintenance candidateMaintenance) {
		Date now = new Date();

		if (DateUtil.getDaysBetween(now, candidateMaintenance.getCreateDate()) >
				_votingPeriodDays) {

			return true;
		}

		return false;
	}

	@Override
	public boolean isAutoFlaggable(WikiPage wikiPage) {
		boolean isAutoFlaggable = false;

		try {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
				WikiPage.class.getName(), wikiPage.getResourcePrimKey());

			String[] assetTags = assetEntry.getTagNames();

			if (assetEntry.getViewCount() > _requiredViewCountForAutoFlagging) {
				return false;
			}

			for (String tag : assetTags) {
				for (String requiredTag : _requiredTagFragments) {
					if (StringUtil.toLowerCase(tag).contains(
							StringUtil.toLowerCase(requiredTag))) {

						isAutoFlaggable = true;
						break;
					}
				}

				if (isAutoFlaggable) {
					break;
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		return isAutoFlaggable;
	}

	@Override
	public boolean isAutoFlaggedAnalyseReady(
		CandidateMaintenance candidateMaintenance) {

		Date now = new Date();

		if (DateUtil.getDaysBetween(now, candidateMaintenance.getCreateDate()) >
				_votingPeriodDaysAutoFlagged) {

			return true;
		}

		return false;
	}

	public void setRequiredTagFragments(String _requiredTagFragments) {
		this._requiredTagFragments = _requiredTagFragments.split(", ");
	}

	public void setRequiredViewCountForAutoFlagging(
		int requiredViewCountForAutoFlagging) {

		_requiredViewCountForAutoFlagging = requiredViewCountForAutoFlagging;
	}

	public void setRequiredVotingPercentage(int requiredVotingPercentage) {
		_requiredVotingPercentage = requiredVotingPercentage;
	}

	public void setRequiredVotingPercentageAutoFlagged(
		int _requiredVotingPercentageAutoFlagged) {

		this._requiredVotingPercentageAutoFlagged =
			_requiredVotingPercentageAutoFlagged;
	}

	public void setRequiredYesVotesPercentage(int requiredYesVotesPercentage) {
		_requiredYesVotesPercentage = requiredYesVotesPercentage;
	}

	public void setRequiredYesVotesPercentageAutoFlagged(
		int _requiredYesVotesPercentageAutoFlagged) {

		this._requiredYesVotesPercentageAutoFlagged =
			_requiredYesVotesPercentageAutoFlagged;
	}

	@Override
	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public void setVotingPeriodDays(int votingPeriodDays) {
		_votingPeriodDays = votingPeriodDays;
	}

	public void setVotingPeriodDaysAutoFlagged(int votingPeriodDays) {
		_votingPeriodDaysAutoFlagged = votingPeriodDays;
	}

	protected OutdatedTask() {
		_taskId = 0;
	}

	private static final String _TASK_NAME = "Outdated";

	private static OutdatedTask _outdatedTask;

	private String _outcome = "";
	private String[] _requiredTagFragments;
	private int _requiredViewCountForAutoFlagging = 0;
	private int _requiredVotingPercentage;
	private int _requiredVotingPercentageAutoFlagged;
	private int _requiredYesVotesPercentage;
	private int _requiredYesVotesPercentageAutoFlagged;
	private long _taskId = 0;
	private int _votingPeriodDays;
	private int _votingPeriodDaysAutoFlagged;

}