/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.micro.maintainance.decision.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.micro.maintainance.candidate.model.CandidateEntry;
import com.liferay.micro.maintainance.candidate.service.CandidateEntryLocalServiceUtil;
import com.liferay.micro.maintainance.decision.model.DecisionEntry;
import com.liferay.micro.maintainance.decision.service.base.DecisionEntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.wiki.model.WikiPage;
import com.liferay.wiki.service.WikiPageLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the decision entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.micro.maintainance.decision.service.DecisionEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DecisionEntryLocalServiceBaseImpl
 * @see com.liferay.micro.maintainance.decision.service.DecisionEntryLocalServiceUtil
 */
@ProviderType
public class DecisionEntryLocalServiceImpl
	extends DecisionEntryLocalServiceBaseImpl {

	/**
	 * Adds the results of an analysis to the database
	 * 
	 * @param userId: the id of the user who flagged the page
	 * @param analysisData: the gathered votes
	 * @param candidateId: the id of the candidate entry belonging to the
	 *   flagged wiki page
	 * @param outcome: the actions to be taken
	 * @param handled: indicates if the actions could be executed
	 * @return the DecisionEntry that was added
	 * @throws PortalException
	 */
	@Override
	public DecisionEntry addDecisionEntry(
			long userId, String analysisData, long candidateId, String outcome,
			boolean handled) 
		throws PortalException {
		
		User user = userPersistence.findByPrimaryKey(userId);
		long decisionId = counterLocalService.increment();
		Date now = new Date();

		DecisionEntry decision = decisionEntryPersistence.create(decisionId);
		
		CandidateEntry candidate = 
			CandidateEntryLocalServiceUtil.getCandidateEntry(candidateId);

		WikiPage wikiPage = 
			WikiPageLocalServiceUtil.getPageByPageId(candidate.getWikiPageId());

		decision.setCompanyId(user.getCompanyId());
		decision.setUserId(userId);
		decision.setUserName(user.getFullName());
		decision.setCreateDate(now);
		decision.setModifiedDate(now);

		decision.setAnalysisData(analysisData);
		decision.setWikiPageId(wikiPage.getPageId());
		decision.setWikiPageName(wikiPage.getTitle());
		decision.setOutcome(outcome);
		decision.setHandled(handled);

		return decision;
	}

	@Override
	public List<DecisionEntry> search(long companyId, boolean handled){

		return decisionEntryPersistence.findByC_H(companyId, handled);
	}

	@Override
	public List<DecisionEntry> findByWikiPageName(String wikiPageName) {

		return decisionEntryPersistence.findByWikiPageName(wikiPageName);
	}

	@Override
	public Hits search(long companyId, long groupId,
			String wikiPageName, Long userId, String userName, Date createDate, boolean handled, int status,
			boolean andSearch, int start,
			int end, Sort sort) {
		Indexer<DecisionEntry> indexer = IndexerRegistryUtil.getIndexer(
				DecisionEntry.class.getName());
		
		SearchContext searchContext = buildSearchContext(companyId, groupId,
				wikiPageName, userId, userName, createDate, handled, status,
				andSearch, start,
				end, sort);
		
		return indexer.search(searchContext);
	}
	
	protected SearchContext buildSearchContext(
			long companyId, long groupId,
			String wikiPageName, Long userId, String userName, Date createDate, boolean handled,
			int status, boolean andSearch, int start,
			int end, Sort sort) {

			SearchContext searchContext = new SearchContext();

			searchContext.setAndSearch(andSearch);

			Map<String, Serializable> attributes = new HashMap<>();

			if(Validator.isNotNull(wikiPageName)){
				attributes.put("wikipagename", wikiPageName);
			}

			if(Validator.isNotNull(userName)) {
				attributes.put("username", userName);
			}

			if(Validator.isNotNull(userId)) {
				attributes.put("userId", userName);
			}

			if(Validator.isNotNull(createDate)) {
				attributes.put("createdate", createDate);
			}

			attributes.put("handled", handled);
			//attributes.put(Field.CLASS_NAME_ID, classNameId);
			attributes.put(Field.STATUS, status);

			searchContext.setAttributes(attributes);

			searchContext.setCompanyId(companyId);
			searchContext.setEnd(end);
			searchContext.setGroupIds(new long[] {groupId});

			QueryConfig queryConfig = new QueryConfig();

			queryConfig.setHighlightEnabled(false);
			queryConfig.setScoreEnabled(false);

			searchContext.setQueryConfig(queryConfig);

			if (sort != null) {
				searchContext.setSorts(sort);
			}

			searchContext.setStart(start);

			return searchContext;
		}
}