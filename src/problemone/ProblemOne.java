package problemone;

import problemone.address.Address;
import problemone.customer.Customer;

public class ProblemOne {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Jules","Kounde","SSN1234");
        Customer customer2 = new Customer("Robert","Lewandowski","SSN3406");
        Customer customer3 = new Customer("Lamine","Yamal","SSN0989");

        //initialize Problem1.address for customer1
        Address billingAddressCustomer1 = new Address("Western Avenue","eee","Elgin","60007");
        Address shippingAddressCustomer1 = new Address("Eastern Avenue","Chicago","Elgin","60007");
        customer1.setBillingAddress(billingAddressCustomer1);
        customer1.setShippingAddress(shippingAddressCustomer1);

        //initialize Problem1.address for customer2
        Address billingAddressCustomer2 = new Address("Fifth Avenue","Albany","New York","65207");
        Address shippingAddressCustomer2 = new Address("Fourth Avenue","Albany","New York","65207");
        customer2.setBillingAddress(billingAddressCustomer2);
        customer2.setShippingAddress(shippingAddressCustomer2);

        //initialize Problem1.address for customer3
        Address billingAddressCustomer3 = new Address("Davenport","Chicago","Iowa","60007");
        Address shippingAddressCustomer3 = new Address("Burrington","FairField","Iowa","60007");
        customer3.setBillingAddress(billingAddressCustomer3);
        customer3.setShippingAddress(shippingAddressCustomer3);

        Customer[] customers = {customer1, customer2, customer3};
        for (Customer customer : customers) {
            if(customer.getBillingAddress().getCity().equals("Chicago")){
                System.out.println(customer);
            }
        }

    }
}
