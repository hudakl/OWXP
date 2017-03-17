package com.liferay.micro.maintainance.action;

import javax.mail.internet.InternetAddress;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.micro.maintainance.analysis.model.AnalysisEntry;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

public class NotifyCreatorAction implements Action {

	@Override
	public boolean performAction(AnalysisEntry analysisEntry) {

		try {
			long companyId = CompanyThreadLocal.getCompanyId();

			User user = UserLocalServiceUtil.getUser(analysisEntry.getUserId());

			User sender = UserLocalServiceUtil.getUserByScreenName(companyId, "glados");

			if(Validator.isNull(user)) {
				sender = UserLocalServiceUtil.getDefaultUser(companyId);
			}

			_sentMail(sender.getEmailAddress(),
					sender.getFullName(), user.getEmailAddress(), 
						SUBJECT, analysisEntry.getAnalysisData());

		} catch (Exception px) {
			return false;
		}

		return true;
	}

	private void _sentMail(
			String fromAddress, String fromName,
			String toAddres, String subject,
			String body) throws Exception {

			InternetAddress fromInternetAddress = new InternetAddress(
				fromAddress, fromName);

			MailMessage mailMessage = new MailMessage(
				fromInternetAddress, subject, body, true);

			
			InternetAddress toInternetAddress = new InternetAddress(
					toAddres);

			mailMessage.setTo(toInternetAddress);

			MailServiceUtil.sendEmail(mailMessage);
	}

	private final static String SUBJECT = "Outdated page";
}
