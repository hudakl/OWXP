package com.liferay.micro.maintainance.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

public class VotesJSONSerializer {

	public static String createVotes() {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("yes", 0);
		jsonObject.put("no", 0);
		jsonObject.put("not_voted", 0);

		return jsonObject.toString();
	}

	public static int getTotalVotes(String analysisData) {

		try {
			JSONObject jsonObject = _jsonFactory.createJSONObject(
					analysisData);

			int noVotes = jsonObject.getInt(VoteConstants.NO_DESCRIPTION);
			int yesVotes = jsonObject.getInt(VoteConstants.YES_DESCRIPTION);
			int notVoted = jsonObject.getInt(VoteConstants.NOT_VOTED_DESCRIPTION);

			return noVotes + yesVotes + notVoted;

		} catch (JSONException e) {
		}

		return 0;
	}

	public static int getVoteCount(String analysisData, String voteConstants) {

		try {
			JSONObject jsonObject = _jsonFactory.createJSONObject(
					analysisData);

			return jsonObject.getInt(voteConstants);

		} catch (JSONException e) {
		}

		return 0;
	}

	public static double getVotePercentage(String analysisData, String voteConstants){
		int total = getTotalVotes(analysisData);
		int noVotes = getVoteCount(analysisData, voteConstants);

		return _calculatePercentage(total, noVotes);
	}

	public static String toReadableFormat(
			String analysisData) throws JSONException {

		int total = getTotalVotes(analysisData);
		int noVotes = getVoteCount(analysisData, VoteConstants.NO_DESCRIPTION);
		int yesVotes = getVoteCount(analysisData, VoteConstants.YES_DESCRIPTION);
		int notVoted = getVoteCount(analysisData, VoteConstants.NOT_VOTED_DESCRIPTION);

		return String.format("%d (%.2f %%) voted '%s' \n"
				+ "%d (%.2f %%) voted '%s' \n"
				+ "%d (%.2f %%) did not vote \n",
				noVotes, _calculatePercentage(total, noVotes), 
				VoteConstants.NO_DESCRIPTION,
				yesVotes, _calculatePercentage(total, yesVotes), 
				VoteConstants.YES_DESCRIPTION,
				notVoted, _calculatePercentage(total, notVoted));
	}

	public static String updateVotes(
			String analysisData, int previousVote, int vote) 
		throws JSONException {

		JSONObject jsonObject = _jsonFactory.createJSONObject(
			analysisData);

		if (previousVote == VoteConstants.NO) {
			decreaseVote(jsonObject, VoteConstants.NO_DESCRIPTION);
		}
		else if (previousVote == VoteConstants.YES) {
			decreaseVote(jsonObject, VoteConstants.YES_DESCRIPTION);
		}
		else if (previousVote == VoteConstants.NOT_VOTED) {
			decreaseVote(jsonObject, VoteConstants.NOT_VOTED_DESCRIPTION);
		}

		if (vote == VoteConstants.NO) {
			increaseVote(jsonObject, VoteConstants.NO_DESCRIPTION);
		}
		else if (vote == VoteConstants.YES) {
			increaseVote(jsonObject, VoteConstants.YES_DESCRIPTION);
		}
		else if (vote == VoteConstants.NOT_VOTED) {
			increaseVote(jsonObject, VoteConstants.NOT_VOTED_DESCRIPTION);
		}

		return jsonObject.toString();
	}
	
	private static void increaseVote(JSONObject jsonObject, String vote) {
		int votes = jsonObject.getInt(vote);
		jsonObject.put(vote, ++votes);
	}

	private static void decreaseVote(JSONObject jsonObject, String vote) {
		int votes = jsonObject.getInt(vote);
		jsonObject.put(vote, -votes);
	}

	private static double _calculatePercentage(int total, int score) {
		if(total <= 0 || score <= 0) {
			return 0.00;
		}

		return (score * 100/ total);
	}

	private static JSONFactory _jsonFactory;
}
