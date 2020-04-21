package com;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import ukr.astelit.cim.CustomerAccount;
import ukr.astelit.cim.CustomerPayment;
import ukr.astelit.cim.Money;
import ukr.astelit.fm.*;
import ukr.astelit.tm.fm.ws.soap.ChainOperateResponse;
import ukr.astelit.tm.fm.ws.soap.FinancialManagement;
import ukr.astelit.tm.fm.ws.soap.FinancialManagement_Service;
import ukr.astelit.tm.fm.ws.soap.FinancialTransactionRequest;

import javax.xml.ws.BindingProvider;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ClientTest {

    public static void main(String[] args) {
/*

        URL url = FinancialManagementService.class.getResource("/META-INF/FinancialManagement.wsdl");
        QName qname = new QName("astelit.ukr:fm", "FinancialManagement");
        Service service = Service.create(url, qname);

        FinancialManagementService port = service.getPort(FinancialManagementService.class);
*/

/*
        FinancialManagement_Service management_service = new FinancialManagement_Service();

        FinancialManagement managementService = management_service.getFinancialManagementPort();

        BindingProvider bindingProvider = (BindingProvider) managementService;
        Map<String, Object> requestContext = bindingProvider.getRequestContext();

        String endpointAddress = "http://dev-test-tm-fm-1.dev.ict:8080/" + "astelit-fm-ws/fm-services/v2/fm";

        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);
        requestContext.put(BindingProvider.USERNAME_PROPERTY, "iguana");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, "iguana");
        requestContext.put(BindingProviderProperties.REQUEST_TIMEOUT, 10000);
        requestContext.put(BindingProviderProperties.CONNECT_TIMEOUT, 10000);

        RegistryDetailsResponse registryDetails = managementService.getRegistryDetails(new RegistryDetailsRequest());
        System.out.println(registryDetails);
*/

/*
        FinancialManagement management = new FinancialManagement();
        FinancialManagementService financialManagementPort = management.getFinancialManagementPort();

        BindingProvider bindingProvider = (BindingProvider) financialManagementPort;
        Map<String, Object> requestContext = bindingProvider.getRequestContext();

        String endpointAddress = "http://dev-test-tm-fm-1.dev.ict:8080/" + "astelit-fm-ws/fm-services/fm";

        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);
        requestContext.put(BindingProvider.USERNAME_PROPERTY, "iguana");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, "iguana");
        requestContext.put(BindingProviderProperties.REQUEST_TIMEOUT, 10000);
        requestContext.put(BindingProviderProperties.CONNECT_TIMEOUT, 10000);

        FinancialTransactionRequest request = new FinancialTransactionRequest();
        request.setChannel("A");
        request.setProfileId("payment");

        CustomerPayment payment = new CustomerPayment();
        payment.setId("Z3xEP0");

        Money money = new Money();
        money.setAmount(new BigDecimal(1));
        payment.setAmount(new Money());

        payment.setPaymentDate(new XMLGregorianCalendarImpl());

        List<CustomerAccount> paymentReceivedFor = payment.getPaymentReceivedFor();

        CustomerAccount account = new CustomerAccount();

        request.setCustomerPayment(payment);

        GeneralOperateResult generalOperateResult = financialManagementPort.doPayment(request);

        System.out.println(generalOperateResult.getTransactionId());
*/

        FinancialManagement_Service management = new FinancialManagement_Service();
        FinancialManagement financialManagementPort = management.getFinancialManagementPort();

        BindingProvider bindingProvider = (BindingProvider) financialManagementPort;
        Map<String, Object> requestContext = bindingProvider.getRequestContext();

        String endpointAddress = "http://dev-test-tm-fm-1.dev.ict:8080/" + "astelit-fm-ws/fm-services/v2/fm";

        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);
        requestContext.put(BindingProvider.USERNAME_PROPERTY, "iguana");
        requestContext.put(BindingProvider.PASSWORD_PROPERTY, "iguana");
        requestContext.put(BindingProviderProperties.REQUEST_TIMEOUT, 10000);
        requestContext.put(BindingProviderProperties.CONNECT_TIMEOUT, 10000);

        FinancialTransactionRequest request = new FinancialTransactionRequest();
        request.setChannel("A");
        request.setProfileId("payment");

        CustomerPayment payment = new CustomerPayment();
        payment.setId("Z3xEP0");

        Money money = new Money();
        money.setAmount(new BigDecimal(1));
        payment.setAmount(new Money());

        payment.setPaymentDate(new XMLGregorianCalendarImpl());

        List<CustomerAccount> paymentReceivedFor = payment.getPaymentReceivedFor();

        CustomerAccount account = new CustomerAccount();

        request.setCustomerPayment(payment);

        ChainOperateResponse chainOperateResponse = financialManagementPort.doPayment(request);

        System.out.println(chainOperateResponse.getTransactionId());

    }


}
