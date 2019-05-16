package org.som.admin.bo;

import java.security.InvalidKeyException;
import java.util.concurrent.ExecutionException;

import org.som.admin.OTPService;
import org.som.bean.OTPFormBean;
import org.som.bean.model.Users;
import org.som.bean.util.RestClientUtil;
import org.som.dao.UserDao;
import org.som.event.service.AdminProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OTPBoImpl implements OTPBo
{
	private static final long	serialVersionUID	= 1949352771664273090L;

	@Autowired
	protected OTPService		otpService;

	@Autowired
	AdminProducer				producer;

	@Autowired
	protected UserDao			userDao;

	@Override
	public String generateOTP(OTPFormBean otpForm) throws InvalidKeyException
	{
		Users user = userDao.findByUserId(otpForm.user.getUserId());
		if(user == null)
			throw new InvalidKeyException("Invalid user Id");
		otpForm.user = user;
		String[] otps = otpService.generate(user.getUserId(), 6);
		otpForm.id = otps[0];
		otpForm.user.setOtp(otps[1]);
		userDao.save(user);
		try {
			RestClientUtil.sendPasswordResetOtp(otpForm);
//			producer.sendSMSMessage(ETemplate.SMS_OTP, otpForm);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return otps[0];
	}

	@Override
	public String validateOTP(OTPFormBean otpForm) throws ExecutionException
	{
		return otpService.validate(otpForm.id,otpForm.user.getUserId(), otpForm.otp).name();
	}

}
