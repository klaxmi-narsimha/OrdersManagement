package com.kln.service.impl;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.kln.dao.CustomerRepository;
import com.kln.dto.CustomerDetailsRequestDTO;
import com.kln.model.Address;
import com.kln.model.Customer;
import com.kln.service.CustomerService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void addNewCustomer(CustomerDetailsRequestDTO customer) {
		
		//SimpleMailMessage mail = new SimpleMailMessage();
		Customer newCustomer = new Customer();
		
		 newCustomer.setName(customer.getName());
		 newCustomer.setMobileNumber(customer.getMobileNumber());
	     newCustomer.setEmail(customer.getEmail());
		 
	     Address address = new Address();

		address.setPincode(customer.address.getPincode());
		address.setCity(customer.address.getCity());
		address.setVillage(customer.address.getVillage());
		address.setColonyName(customer.address.getColonyName());
		address.setHouseNumber(customer.address.getHouseNumber());

		newCustomer.setAddress(address);

		customerRepository.save(newCustomer);
		
		 MimeMessage message = mailSender.createMimeMessage();

	        try {
	            MimeMessageHelper helper =
	                    new MimeMessageHelper(message, true);

	            helper.setTo(customer.getEmail());
	            helper.setSubject("Customer Registration Successful");

	            String html = """
	                    <!DOCTYPE html>
	                    <html>
	                    <body style="margin:0; padding:0; background-color:#f2f5f9; 
	                                 font-family:Arial, sans-serif;">

	                        <table width="100%%" cellpadding="0" cellspacing="0"
	                               style="background-color:#f2f5f9; padding:40px 0;">

	                            <tr>
	                                <td align="center">

	                                    <table width="600" cellpadding="0" cellspacing="0"
	                                           style="background-color:white; 
	                                                  border-radius:12px; overflow:hidden;">

	                                        <!-- Header -->
	                                        <tr>
	                                            <td style="background-color:#2563eb; 
	                                                       padding:30px; text-align:center;">

	                                                <h1 style="color:white; margin:0;
	                                                           font-size:28px;">
	                                                    Welcome!
	                                                </h1>

	                                                <p style="color:#dbeafe; margin:10px 0 0;">
	                                                    Registration Successful
	                                                </p>

	                                            </td>
	                                        </tr>

	                                        <!-- Content -->
	                                        <tr>
	                                            <td style="padding:35px;">

	                                                <h2 style="color:#1e293b; margin-top:0;">
	                                                    Hello %s,
	                                                </h2>

	                                                <p style="color:#475569; font-size:16px;
	                                                          line-height:1.6;">
	                                                    Your customer registration has been
	                                                    completed successfully.
	                                                </p>

	                                                <!-- Customer Details -->
	                                                <table width="100%%" cellpadding="0"
	                                                       cellspacing="0"
	                                                       style="margin-top:25px;
	                                                              background-color:#f8fafc;
	                                                              border-radius:8px;">

	                                                    <tr>
	                                                        <td style="padding:15px;
	                                                                   color:#64748b;">
	                                                            <b>Name</b>
	                                                        </td>

	                                                        <td style="padding:15px;
	                                                                   color:#1e293b;">
	                                                            %s
	                                                        </td>
	                                                    </tr>

	                                                    <tr>
	                                                        <td style="padding:15px;
	                                                                   color:#64748b;">
	                                                            <b>Mobile</b>
	                                                        </td>

	                                                        <td style="padding:15px;
	                                                                   color:#1e293b;">
	                                                            %s
	                                                        </td>
	                                                    </tr>

	                                                    <tr>
	                                                        <td style="padding:15px;
	                                                                   color:#64748b;">
	                                                            <b>Email</b>
	                                                        </td>

	                                                        <td style="padding:15px;
	                                                                   color:#1e293b;">
	                                                            %s
	                                                        </td>
	                                                    </tr>

	                                                </table>

	                                                <!-- Button -->
	                                                <div style="text-align:center;
	                                                            margin:30px 0;">

	                                                    <a href="http://localhost:8080/login"
	                                                       style="background-color:#2563eb;
	                                                              color:white;
	                                                              padding:14px 28px;
	                                                              text-decoration:none;
	                                                              border-radius:6px;
	                                                              font-weight:bold;
	                                                              display:inline-block;">
	                                                        Login to Your Account
	                                                    </a>

	                                                </div>

	                                                <p style="color:#64748b; font-size:14px;
	                                                          line-height:1.6;">
	                                                    Thank you for registering with us.
	                                                    We are happy to have you with us.
	                                                </p>

	                                            </td>
	                                        </tr>

	                                        <!-- Footer -->
	                                        <tr>
	                                            <td style="background-color:#0f172a;
	                                                       padding:20px;
	                                                       text-align:center;">

	                                                <p style="color:#94a3b8;
	                                                          margin:0;
	                                                          font-size:13px;">
	                                                    © 2026 Your Application
	                                                </p>

	                                                <p style="color:#64748b;
	                                                          margin:8px 0 0;
	                                                          font-size:12px;">
	                                                    This is an automated email.
	                                                </p>

	                                            </td>
	                                        </tr>

	                                    </table>

	                                </td>
	                            </tr>

	                        </table>

	                    </body>
	                    </html>
	                    """.formatted(
	                        customer.getName(),
	                        customer.getName(),
	                        customer.getMobileNumber(),
	                        customer.getEmail()
	                    );
	            // true = HTML email
	            helper.setText(html, true);

	            mailSender.send(message);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	}
}
