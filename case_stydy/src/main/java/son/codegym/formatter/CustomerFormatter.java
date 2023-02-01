package son.codegym.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import son.codegym.entity.Customer;
import son.codegym.service.customer.ICustomerService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CustomerFormatter implements Formatter<Customer> {
    private ICustomerService service;
    @Autowired
    public CustomerFormatter(ICustomerService service) {
        this.service = service;
    }
    @Override
    public Customer parse(String text, Locale locale) throws ParseException {
        return service.findById(text);
    }

    @Override
    public String print(Customer object, Locale locale) {
        return object.toString();
    }
}
